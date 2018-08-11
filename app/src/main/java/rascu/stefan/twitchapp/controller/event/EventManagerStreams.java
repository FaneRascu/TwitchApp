package rascu.stefan.twitchapp.controller.event;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.controller.component.DaggerTwitchComponentGames;
import rascu.stefan.twitchapp.controller.component.DaggerTwitchComponentStreams;
import rascu.stefan.twitchapp.controller.component.TwitchComponentStreams;
import rascu.stefan.twitchapp.controller.event.request.RequestStreamsListEvent;
import rascu.stefan.twitchapp.controller.event.response.ResponseStreamsListEvent;
import rascu.stefan.twitchapp.controller.module.TwitchModuleStreams;
import rascu.stefan.twitchapp.model.streams.StreamListContent;
import rascu.stefan.twitchapp.service.TwitchRestClientStreams;
import rascu.stefan.twitchapp.util.Constants;
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

    @Subscribe
    public void onEvent(final RequestStreamsListEvent event) {
        this.context = event.getContext();

        if (!GenericUtil.isOnline(this.context)) {
            EventBus.getDefault().post(new ErrorEvent(this.context.getString(R.string.offline)));
            return;
        }

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(Constants.LIMIT_PARAMETER, Constants.DEFAULT_LIMIT);
        parameters.put(Constants.OFFSET_PARAMETER, String.valueOf(event.getOffset()));

        Call<StreamListContent> call = this.restClient.getTopStreams(parameters);
        call.enqueue(new Callback<StreamListContent>() {
            @Override
            public void onResponse(Call<StreamListContent> call, Response<StreamListContent> response) {
                if (response.isSuccessful()) {
                    StreamListContent featuredStreamsListContent = response.body();
                    EventBus.getDefault().post(new ResponseStreamsListEvent(featuredStreamsListContent, event.getOffset()));
                }
            }

            @Override
            public void onFailure(Call<StreamListContent> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new ErrorEvent(t.getMessage()));
            }
        });

    }

    public void destroy() {
        EventBus.getDefault().unregister(this);
    }
}


