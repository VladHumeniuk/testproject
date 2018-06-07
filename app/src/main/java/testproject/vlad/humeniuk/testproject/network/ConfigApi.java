package testproject.vlad.humeniuk.testproject.network;

import retrofit2.Call;
import retrofit2.http.GET;
import testproject.vlad.humeniuk.testproject.network.entity.config.ConfigResponse;

public interface ConfigApi {

    @GET("config")
    Call<ConfigResponse> getConfig();
}
