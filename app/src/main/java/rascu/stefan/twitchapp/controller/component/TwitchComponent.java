package rascu.stefan.twitchapp.controller.component;

import javax.inject.Singleton;

import dagger.Component;
import rascu.stefan.twitchapp.controller.module.TwitchModule;
import rascu.stefan.twitchapp.service.TwitchRestClient;

@Singleton
@Component(modules = {TwitchModule.class})
public interface TwitchComponent {

    public TwitchRestClient provideTwitchRestClient();

}
