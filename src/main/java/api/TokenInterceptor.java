package api;

import gui.StaticComponents;
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
        final StaticComponents stat = StaticComponents.getInstance();
        String key = stat.getToken();
        return request.url().newBuilder()
                .addQueryParameter(API_KEY_PARAM, key)
                .build();
    }
}
