package rascu.stefan.twitchapp.controller.module;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import rascu.stefan.twitchapp.service.TwitchRestClientFeaturedStreams;
import rascu.stefan.twitchapp.util.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class TwitchModuleFeaturedStreams {
    @Provides
    @Singleton
    TwitchRestClientFeaturedStreams provideTwitchRestClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

/*
        // TODO implementar o tratamento offline usando cache em disco atraves do OkHttpClient
        // handle cache response
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        Cache cache = new Cache(httpCacheDirectory, Constants.CACHE_SIZE);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(CacheControlInterceptor.getInstance())
                .cache(cache)
                .build();
*/

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Executor executor = Executors.newCachedThreadPool();

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .callbackExecutor(executor)
                .client(client)
                .build()
                .create(TwitchRestClientFeaturedStreams.class);
    }


}