package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itis.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiClient {

    private static OkHttpClient sClient;
    private static volatile CircleService circleService;

    private ApiClient() {
    }

    public static CircleService getPhraseService() {
        CircleService service = circleService;
        if (service == null) {
            synchronized (ApiClient.class) {
                service = circleService;
                if (service == null) {
                    service = circleService = buildRetrofit().create(CircleService.class);
                }
            }
        }
        return service;
    }

    private static Retrofit buildRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static Gson getGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiClient.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor.create())
                .build();
    }
}
