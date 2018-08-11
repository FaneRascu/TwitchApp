package rascu.stefan.twitchapp.service;

import java.util.Map;

import rascu.stefan.twitchapp.model.streams.FeaturedStreamsListContent;
import rascu.stefan.twitchapp.util.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface TwitchRestClientFeaturedStreams {
    @Headers({Constants.ACCEPT_HEADER, Constants.Client_ID})
    @GET(Constants.PATH_FEATURED_STREAMS)
    public Call<FeaturedStreamsListContent> getTopFeaturedStreams();

    @Headers({Constants.ACCEPT_HEADER, Constants.Client_ID})
    @GET(Constants.PATH_FEATURED_STREAMS)
    public Call<FeaturedStreamsListContent> getTopFeaturedStreams(@QueryMap Map<String, String> parameters);
}
