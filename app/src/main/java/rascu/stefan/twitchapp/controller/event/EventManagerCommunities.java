package rascu.stefan.twitchapp.controller.event;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.controller.component.DaggerTwitchComponentCommunities;

import rascu.stefan.twitchapp.controller.component.TwitchComponentCommunities;

import rascu.stefan.twitchapp.controller.event.request.RequestCommunitiesListEvent;

import rascu.stefan.twitchapp.controller.event.response.ResponseCommunitiesListEvent;

import rascu.stefan.twitchapp.controller.module.TwitchModuleCommunities;

import rascu.stefan.twitchapp.model.communities.CommunityListContent;

import rascu.stefan.twitchapp.service.TwitchRestClientCommunities;

import rascu.stefan.twitchapp.util.Constants;
import rascu.stefan.twitchapp.util.GenericUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventManagerCommunities {

    private static EventManagerCommunities instance;

    private TwitchRestClientCommunities restClient;

    protected Context context;

    private EventManagerCommunities() {}

    public static EventManagerCommunities getInstance() {
        if (instance == null) {
            instance = new EventManagerCommunities();
        }

        return instance;
    }

    public void init() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        if (this.restClient == null) {
            TwitchComponentCommunities twitchComponentGames = DaggerTwitchComponentCommunities.builder()
                    .twitchModuleCommunities(new TwitchModuleCommunities())
                    .build();

            this.restClient = twitchComponentGames.provideTwitchRestClient();
        }

    }

    @Subscribe
    public void onEvent(final RequestCommunitiesListEvent event) {
        this.context = event.getContext();

        if (!GenericUtil.isOnline(this.context)) {
            EventBus.getDefault().post(new ErrorEvent(this.context.getString(R.string.offline)));
            return;
        }

        Map<String, String> parameters = new HashMap<String, String>();
//        parameters.put(Constants.LIMIT_PARAMETER, Constants.DEFAULT_LIMIT);
//        parameters.put(Constants.OFFSET_PARAMETER, String.valueOf(event.getOffset()));

        Call<CommunityListContent> call = this.restClient.getTopCommunities(parameters);
        call.enqueue(new Callback<CommunityListContent>() {
            @Override
            public void onResponse(Call<CommunityListContent> call, Response<CommunityListContent> response) {
                if (response.isSuccessful()) {
                    CommunityListContent communityListContent = response.body();
                    EventBus.getDefault().post(new ResponseCommunitiesListEvent(communityListContent, event.getOffset()));
                }
            }

            @Override
            public void onFailure(Call<CommunityListContent> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new ErrorEvent(t.getMessage()));
            }
        });

    }

    public void destroy() {
        EventBus.getDefault().unregister(this);
    }
}

