package rascu.stefan.twitchapp.controller.component;

import javax.inject.Singleton;

import dagger.Component;
import rascu.stefan.twitchapp.controller.module.TwitchModuleFeaturedStreams;
import rascu.stefan.twitchapp.service.TwitchRestClientFeaturedStreams;

@Singleton
@Component(modules = {TwitchModuleFeaturedStreams.class})
public interface TwitchComponentFeaturedStreams {

    public TwitchRestClientFeaturedStreams provideTwitchRestClient();

}