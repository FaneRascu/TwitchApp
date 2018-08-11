package rascu.stefan.twitchapp.service;

import java.util.Map;

import rascu.stefan.twitchapp.model.communities.CommunityListContent;
import rascu.stefan.twitchapp.util.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface TwitchRestClientCommunities {

    @Headers({Constants.ACCEPT_HEADER, Constants.Client_ID})
    @GET(Constants.PATH_COMMUNITIES)
    public Call<CommunityListContent> getTopCommunities();

    @Headers({Constants.ACCEPT_HEADER, Constants.Client_ID})
    @GET(Constants.PATH_COMMUNITIES)
    public Call<CommunityListContent> getTopCommunities(@QueryMap Map<String, String> parameters);
}
