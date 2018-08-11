package rascu.stefan.twitchapp.service;

import java.util.Map;

import rascu.stefan.twitchapp.model.streams.StreamListContent;
import rascu.stefan.twitchapp.util.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface TwitchRestClientStreams {
    @Headers({Constants.ACCEPT_HEADER, Constants.Client_ID})
    @GET(Constants.PATH_STREAMS)
    public Call<StreamListContent> getTopStreams();

    @Headers({Constants.ACCEPT_HEADER, Constants.Client_ID})
    @GET(Constants.PATH_STREAMS)
    public Call<StreamListContent> getTopStreams(@QueryMap Map<String, String> parameters);
}

