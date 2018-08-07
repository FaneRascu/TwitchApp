package rascu.stefan.twitchapp.service;

import java.util.Map;

import rascu.stefan.twitchapp.model.streams.StreamsListContent;
import rascu.stefan.twitchapp.util.Constant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface TwitchRestClientStreams {
    @Headers({Constant.ACCEPT_HEADER, Constant.Client_ID})
    @GET(Constant.PATH_STREAMS)
    public Call<StreamsListContent> getTopStreams();

    @Headers({Constant.ACCEPT_HEADER, Constant.Client_ID})
    @GET(Constant.PATH_STREAMS)
    public Call<StreamsListContent> getTopStreams(@QueryMap Map<String, String> parameters);
}
