package testproject.vlad.humeniuk.testproject.mock;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;
import testproject.vlad.humeniuk.testproject.network.ConfigApi;
import testproject.vlad.humeniuk.testproject.network.entity.config.ConfigResponse;

public class ErrorConfigApiMock implements ConfigApi {

    private final BehaviorDelegate<ConfigApi> delegate;

    public ErrorConfigApiMock(BehaviorDelegate<ConfigApi> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Call<ConfigResponse> getConfig() {
        Response response = Response.error(500,
                ResponseBody.create(MediaType.parse("application/json"), "{}"));
        return delegate.returning(Calls.response(response)).getConfig();
    }
}
