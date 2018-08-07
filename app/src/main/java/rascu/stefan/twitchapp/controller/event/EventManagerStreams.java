package rascu.stefan.twitchapp.controller.event;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;
import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.controller.component.DaggerTwitchComponentStreams;
import rascu.stefan.twitchapp.controller.component.TwitchComponentStreams;
import rascu.stefan.twitchapp.controller.event.request.RequestStreamsListEvent;
import rascu.stefan.twitchapp.controller.event.response.ResponseStreamsListEvent;
import rascu.stefan.twitchapp.controller.module.TwitchModuleStreams;
import rascu.stefan.twitchapp.model.streams.StreamsListContent;
import rascu.stefan.twitchapp.service.TwitchRestClientStreams;
import rascu.stefan.twitchapp.util.Constant;
import rascu.stefan.twitchapp.util.GenericUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventManagerStreams {
    private static EventManagerStreams instance;

    private TwitchRestClientStreams restClient;

    protected Context context;

    private EventManagerStreams() {}

    public static EventManagerStreams getInstance() {
        if (instance == null) {
            instance = new EventManagerStreams();
        }

        return instance;
    }

    public void init() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        if (this.restClient == null) {
            TwitchComponentStreams twitchComponentStreams = DaggerTwitchComponentStreams.builder()
                    .twitchModuleStreams(new TwitchModuleStreams())
                    .build();

            this.restClient = twitchComponentStreams.provideTwitchRestClient();
        }

    }

    public void onEvent(final RequestStreamsListEvent event) {
        this.context = event.getContext();

        if (!GenericUtil.isOnline(this.context)) {
            EventBus.getDefault().post(new ErrorEvent(this.context.getString(R.string.offline)));
            return;
        }

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(Constant.LIMIT_PARAMETER, Constant.DEFAULT_LIMIT);
        parameters.put(Constant.OFFSET_PARAMETER, String.valueOf(event.getOffset()));

        Call<StreamsListContent> call = this.restClient.getTopStreams(parameters);
        call.enqueue(new Callback<StreamsListContent>() {
            @Override
            public void onResponse(Call<StreamsListContent> call, Response<StreamsListContent> response) {
                if (response.isSuccessful()) {
                    StreamsListContent streamsListContent = response.body();
                    EventBus.getDefault().post(new ResponseStreamsListEvent(streamsListContent, event.getOffset()));
                }
            }

            @Override
            public void onFailure(Call<StreamsListContent> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new ErrorEvent(t.getMessage()));
            }
        });

    }

    public void destroy() {
        EventBus.getDefault().unregister(this);
    }
}