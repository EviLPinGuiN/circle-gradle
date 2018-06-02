package api;

import io.reactivex.Single;
import model.UserHolder;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CircleService {

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @GET("me")
    Single<UserHolder> getProfile(@Query("circle-token") String token);
}
