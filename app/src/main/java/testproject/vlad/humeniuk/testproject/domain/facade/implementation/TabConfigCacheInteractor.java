package testproject.vlad.humeniuk.testproject.domain.facade.implementation;

import com.google.gson.Gson;

import java.util.List;

import testproject.vlad.humeniuk.testproject.R;
import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.domain.facade.TabConfigInteractor;
import testproject.vlad.humeniuk.testproject.domain.mapper.TabConfigMapper;
import testproject.vlad.humeniuk.testproject.network.entity.config.ConfigResponse;
import testproject.vlad.humeniuk.testproject.util.ResourceReader;

public class TabConfigCacheInteractor implements TabConfigInteractor {

    private ResourceReader resourceReader;
    private TabConfigMapper mapper;
    private Gson gson;

    public TabConfigCacheInteractor(ResourceReader resourceReader) {
        this(resourceReader, new TabConfigMapper(), new Gson());
    }

    public TabConfigCacheInteractor(ResourceReader resourceReader, TabConfigMapper mapper, Gson gson) {
        this.resourceReader = resourceReader;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public List<TabConfig> getTabConfigList() {
        return mapper.map(gson.fromJson(resourceReader.readRawResource(R.raw.cachedconfig),
                ConfigResponse.class));
    }
}
