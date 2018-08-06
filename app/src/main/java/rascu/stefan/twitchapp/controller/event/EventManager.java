package rascu.stefan.twitchapp.controller.event;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;
import rascu.stefan.twitchapp.R;
import rascu.stefan.twitchapp.controller.component.DaggerTwitchComponent;
import rascu.stefan.twitchapp.controller.event.request.RequestGamesListEvent;
import rascu.stefan.twitchapp.controller.event.response.ResponseGamesListEvent;
import rascu.stefan.twitchapp.controller.module.TwitchModule;
import rascu.stefan.twitchapp.model.GamesListContent;
import rascu.stefan.twitchapp.service.TwitchRestClient;
import rascu.stefan.twitchapp.util.Constant;
import rascu.stefan.twitchapp.util.GenericUtil;
import rascu.stefan.twitchapp.controller.component.TwitchComponent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventManager {

    private static EventManager instance;

    private TwitchRestClient restClient;

    protected Context context;

    private EventManager() {}

    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }

        return instance;
    }

    public void init() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        if (this.restClient == null) {
            TwitchComponent twitchComponent = DaggerTwitchComponent.builder()
                    .twitchModule(new TwitchModule())
                    .build();

            this.restClient = twitchComponent.provideTwitchRestClient();
        }

    }

    public void onEvent(final RequestGamesListEvent event) {
        this.context = event.getContext();

        if (!GenericUtil.isOnline(this.context)) {
            EventBus.getDefault().post(new ErrorEvent(this.context.getString(R.string.offline)));
            return;
        }

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(Constant.LIMIT_PARAMETER, Constant.DEFAULT_LIMIT);
        parameters.put(Constant.OFFSET_PARAMETER, String.valueOf(event.getOffset()));

        Call<GamesListContent> call = this.restClient.getTopGames(parameters);
        call.enqueue(new Callback<GamesListContent>() {
            @Override
            public void onResponse(Call<GamesListContent> call, Response<GamesListContent> response) {
                if (response.isSuccessful()) {
                    GamesListContent gamesListContent = response.body();
                    EventBus.getDefault().post(new ResponseGamesListEvent(gamesListContent, event.getOffset()));
                }
            }

            @Override
            public void onFailure(Call<GamesListContent> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new ErrorEvent(t.getMessage()));
            }
        });

    }

    public void destroy() {
        EventBus.getDefault().unregister(this);
    }
}
