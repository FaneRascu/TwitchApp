package rascu.stefan.twitchapp.controller.component;

import javax.inject.Singleton;

import dagger.Component;
import rascu.stefan.twitchapp.controller.module.TwitchModuleGames;
import rascu.stefan.twitchapp.service.TwitchRestClientGames;

@Singleton
@Component(modules = {TwitchModuleGames.class})
public interface TwitchComponentGames {

    public TwitchRestClientGames provideTwitchRestClient();

}
