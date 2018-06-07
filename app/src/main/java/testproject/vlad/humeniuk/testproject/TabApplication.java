package testproject.vlad.humeniuk.testproject;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import testproject.vlad.humeniuk.testproject.network.ConfigApi;
import testproject.vlad.humeniuk.testproject.util.InteractorFactory;

public class TabApplication extends Application {

    private InteractorFactory interactorFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        interactorFactory = new InteractorFactory(buildApi(), getResources());
    }

    public InteractorFactory getInteractorFactory() {
        return interactorFactory;
    }

    private ConfigApi buildApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ConfigApi.class);
    }

    private OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }
}
