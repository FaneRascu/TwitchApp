package rascu.stefan.twitchapp.controller.module;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import rascu.stefan.twitchapp.util.Constant;

public class CacheControlInterceptor implements Interceptor {

    private static CacheControlInterceptor instance;

    public CacheControlInterceptor() {}

    public static CacheControlInterceptor getInstance() {
        if (instance == null) {
            instance = new CacheControlInterceptor();
        }

        return instance;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        // online response
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .header("Cache-Control", "public, max-age=" + Constant.MAX_AGE)
                .build();
        /*
            // offline response
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + Constant.MAX_STALE)
                    .build();
        */
    }
}