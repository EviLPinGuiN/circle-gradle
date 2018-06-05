package api;

import io.reactivex.Single;
import model.BuildResponseBody;
import model.Project;
import model.UserHolder;
import model.build.BuildInfo;
import retrofit2.http.*;

import javax.annotation.Nullable;
import java.util.List;

public interface CircleService {

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @GET("me")
    Single<UserHolder> getProfile();

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @GET("projects")
    Single<List<Project>> getAllProjects();

    /**
     * @return Build summary for each of the last 30 recent builds, ordered by build_num
     */
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @GET("project/{vcs-type}/{username}/{project}/{build_num}")
    Single<BuildInfo> getSingleBuildInfo(@Path("vcs-type") String type, @Path("username") String username,
                                         @Path("project") String project, @Path("build_num") int buildNum);

    /**
     * https://circleci.com/docs/api/v1-reference/#recent-builds-project
     * @param limit The number of builds to return. Maximum 100, defaults to 30.
     * @param offset Returns builds starting from this offset, defaults to 0.
     * @param filter Restricts which builds are returned. Set to "completed",
     *               "successful", "failed", "running", or defaults to no filter.
     * @return Build summary for each of the last 30 builds for a single git repo.
     */
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @GET("project/{vcs-type}/{username}/{project}")
    Single<List<BuildInfo>> getRecentBuildInfo(@Path("vcs-type") String type, @Path("username") String username,
                                @Path("project") String project,
                                @Nullable @Query("limit") Integer limit,
                                @Nullable @Query("offset") Integer offset,
                                @Nullable @Query("filter") String filter);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("project/{vcs-type}/{username}/{project}/{build_num}/retry")
    Single<BuildResponseBody> retryBuild(@Path("vcs-type") String type, @Path("username") String username,
                                         @Path("project") String project, @Path("build_num") String buildNum);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("project/{vcs-type}/{username}/{project}/{build_num}/cancel")
    Single<BuildResponseBody> cancelBuild(@Path("vcs-type") String type, @Path("username") String username,
                                          @Path("project") String project, @Path("build_num") String buildNum);
}
