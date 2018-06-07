package testproject.vlad.humeniuk.testproject.interactor;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;
import testproject.vlad.humeniuk.testproject.BuildConfig;
import testproject.vlad.humeniuk.testproject.mock.BadConfigApiMock;
import testproject.vlad.humeniuk.testproject.mock.ConfigApiMock;
import testproject.vlad.humeniuk.testproject.Constants;
import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.domain.facade.implementation.TabConfigNetInteractor;
import testproject.vlad.humeniuk.testproject.mock.ErrorConfigApiMock;
import testproject.vlad.humeniuk.testproject.network.ConfigApi;
import testproject.vlad.humeniuk.testproject.network.entity.config.ConfigResponse;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TabConfigNetInteractorTest {

    private MockRetrofit mockRetrofit;
    private Retrofit retrofit;

    private ErrorConfigApiMock errorMock;
    private BadConfigApiMock badConfigApiMock;
    private ConfigApiMock apiMock;

    @Before
    public void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NetworkBehavior behavior = NetworkBehavior.create();
        mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build();
        apiMock = new ConfigApiMock(mockRetrofit.create(ConfigApi.class));
        errorMock = new ErrorConfigApiMock(mockRetrofit.create(ConfigApi.class));
        badConfigApiMock = new BadConfigApiMock(mockRetrofit.create(ConfigApi.class));
    }

    @Test
    public void testGetConfigPositive() {
        TabConfigNetInteractor interactor = new TabConfigNetInteractor(apiMock);
        List<TabConfig> actual = interactor.getTabConfigList();
        assertEquals(getExpected(), actual);
    }

    @Test
    public void testGetConfigNegative() {
        TabConfigNetInteractor interactor = new TabConfigNetInteractor(errorMock);
        List<TabConfig> actual = interactor.getTabConfigList();
        assertEquals(null, actual);
    }

    @Test
    public void testBadResponse() {
        TabConfigNetInteractor interactor = new TabConfigNetInteractor(badConfigApiMock);
        List<TabConfig> actual = interactor.getTabConfigList();
        assertEquals(null, actual);
    }

    private List<TabConfig> getExpected() {
        TabConfig tabConfig = new TabConfig();
        tabConfig.setTitle("Tab 1 title");
        tabConfig.setBody("Tab 1 body");
        List<TabConfig> expected = new ArrayList<>();
        expected.add(tabConfig);
        return expected;
    }
}
