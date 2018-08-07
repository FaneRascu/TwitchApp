package rascu.stefan.twitchapp.service;

import java.util.Map;

import rascu.stefan.twitchapp.model.games.GamesListContent;
import rascu.stefan.twitchapp.util.Constant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface TwitchRestClientGames {

    @Headers({Constant.ACCEPT_HEADER, Constant.Client_ID})
    @GET(Constant.PATH_GAMES)
    public Call<GamesListContent> getTopGames();

    @Headers({Constant.ACCEPT_HEADER, Constant.Client_ID})
    @GET(Constant.PATH_GAMES)
    public Call<GamesListContent> getTopGames(@QueryMap Map<String, String> parameters);
}
