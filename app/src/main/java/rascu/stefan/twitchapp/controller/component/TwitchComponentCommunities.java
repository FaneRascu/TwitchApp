package rascu.stefan.twitchapp.controller.component;

import javax.inject.Singleton;

import dagger.Component;
import rascu.stefan.twitchapp.controller.module.TwitchModuleCommunities;
import rascu.stefan.twitchapp.service.TwitchRestClientCommunities;


@Singleton
@Component(modules = {TwitchModuleCommunities.class})
public interface TwitchComponentCommunities {

    public TwitchRestClientCommunities provideTwitchRestClient();

}