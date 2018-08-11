package rascu.stefan.twitchapp.controller.component;

import javax.inject.Singleton;

import dagger.Component;
import rascu.stefan.twitchapp.controller.module.TwitchModuleStreams;
import rascu.stefan.twitchapp.service.TwitchRestClientStreams;

@Singleton
@Component(modules = {TwitchModuleStreams.class})
public interface TwitchComponentStreams {

    public TwitchRestClientStreams provideTwitchRestClient();

}
