package testproject.vlad.humeniuk.testproject.domain.facade.implementation;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.domain.facade.TabConfigInteractor;
import testproject.vlad.humeniuk.testproject.domain.mapper.TabConfigMapper;
import testproject.vlad.humeniuk.testproject.network.ConfigApi;
import testproject.vlad.humeniuk.testproject.network.entity.config.ConfigResponse;

public class TabConfigNetInteractor implements TabConfigInteractor {

    private ConfigApi api;
    private TabConfigMapper mapper;

    public TabConfigNetInteractor(ConfigApi api) {
        this(api, new TabConfigMapper());
    }

    public TabConfigNetInteractor(ConfigApi api, TabConfigMapper mapper) {
        this.api = api;
        this.mapper = mapper;
    }

    @Override
    public List<TabConfig> getTabConfigList() {
        ConfigResponse configResponse;
        try {
            Response response = api.getConfig().execute();
            if (response.isSuccessful()) {
                configResponse = (ConfigResponse) response.body();
            } else {
                configResponse = null;
            }
        } catch (IOException ignored) {
            configResponse = null;
        }
        return configResponse == null ? null : mapper.map(configResponse);
    }
}
