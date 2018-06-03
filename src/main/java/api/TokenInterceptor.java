package api;

import com.itis.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public final class TokenInterceptor implements Interceptor {

    private final static String API_KEY_PARAM = "circle-token";

    private TokenInterceptor() {
    }

    public static Interceptor create() {
        return new TokenInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .url(getUrl(original)).build();
        return chain.proceed(request);
    }

    private HttpUrl getUrl(Request request) {
        String key = BuildConfig.TEST_TOKEN;
        return request.url().newBuilder()
                .addQueryParameter(API_KEY_PARAM, key)
                .build();
    }
}
