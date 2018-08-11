package rascu.stefan.twitchapp.controller.event;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import rascu.stefan.twitchapp.R;

import rascu.stefan.twitchapp.controller.component.DaggerTwitchComponentFeaturedStreams;

import rascu.stefan.twitchapp.controller.component.TwitchComponentFeaturedStreams;

import rascu.stefan.twitchapp.controller.event.request.RequestFeaturedStreamsListEvent;

import rascu.stefan.twitchapp.controller.event.response.ResponseFeaturedStreamsListEvent;

import rascu.stefan.twitchapp.controller.module.TwitchModuleFeaturedStreams;

import rascu.stefan.twitchapp.model.streams.FeaturedStreamsListContent;

import rascu.stefan.twitchapp.service.TwitchRestClientFeaturedStreams;
import rascu.stefan.twitchapp.util.Constants;
import rascu.stefan.twitchapp.util.GenericUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventManagerFeaturedStreams {

    private static EventManagerFeaturedStreams instance;

    private TwitchRestClientFeaturedStreams restClient;

    protected Context context;

    private EventManagerFeaturedStreams() {}

    public static EventManagerFeaturedStreams getInstance() {
        if (instance == null) {
            instance = new EventManagerFeaturedStreams();
        }

        return instance;
    }

    public void init() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        if (this.restClient == null) {
            TwitchComponentFeaturedStreams twitchComponentFeaturedStreams = DaggerTwitchComponentFeaturedStreams.builder()
                    .twitchModuleFeaturedStreams(new TwitchModuleFeaturedStreams())
                    .build();

            this.restClient = twitchComponentFeaturedStreams.provideTwitchRestClient();
        }

    }

    @Subscribe
    public void onEvent(final RequestFeaturedStreamsListEvent event) {
        this.context = event.getContext();

        if (!GenericUtil.isOnline(this.context)) {
            EventBus.getDefault().post(new ErrorEvent(this.context.getString(R.string.offline)));
            return;
        }

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(Constants.LIMIT_PARAMETER, Constants.DEFAULT_LIMIT);
        parameters.put(Constants.OFFSET_PARAMETER, String.valueOf(event.getOffset()));

        Call<FeaturedStreamsListContent> call = this.restClient.getTopFeaturedStreams(parameters);
        call.enqueue(new Callback<FeaturedStreamsListContent>() {
            @Override
            public void onResponse(Call<FeaturedStreamsListContent> call, Response<FeaturedStreamsListContent> response) {
                if (response.isSuccessful()) {
                    FeaturedStreamsListContent featuredStreamsListContent = response.body();
                    EventBus.getDefault().post(new ResponseFeaturedStreamsListEvent(featuredStreamsListContent, event.getOffset()));
                }
            }

            @Override
            public void onFailure(Call<FeaturedStreamsListContent> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new ErrorEvent(t.getMessage()));
            }
        });

    }

    public void destroy() {
        EventBus.getDefault().unregister(this);
    }
}
