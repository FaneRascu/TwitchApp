package rascu.stefan.twitchapp.service;

import java.util.Map;

import rascu.stefan.twitchapp.model.communities.CommunityListContent;
import rascu.stefan.twitchapp.util.Constant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface TwitchRestClientCommunities {

    @Headers({Constant.ACCEPT_HEADER, Constant.Client_ID})
    @GET(Constant.PATH_COMMUNITIES)
    public Call<CommunityListContent> getTopCommunities();

    @Headers({Constant.ACCEPT_HEADER, Constant.Client_ID})
    @GET(Constant.PATH_COMMUNITIES)
    public Call<CommunityListContent> getTopCommunities(@QueryMap Map<String, String> parameters);
}
