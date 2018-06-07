package testproject.vlad.humeniuk.testproject.mock;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.mock.BehaviorDelegate;
import testproject.vlad.humeniuk.testproject.Constants;
import testproject.vlad.humeniuk.testproject.network.ConfigApi;
import testproject.vlad.humeniuk.testproject.network.entity.config.ConfigResponse;

public class BadConfigApiMock implements ConfigApi {

    private final BehaviorDelegate<ConfigApi> delegate;

    public BadConfigApiMock(BehaviorDelegate<ConfigApi> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Call<ConfigResponse> getConfig() {
        return delegate.returningResponse(new Gson().fromJson(Constants.Response.BAD_RESPONSE,
                ConfigResponse.class)).getConfig();
    }
}
