package testproject.vlad.humeniuk.testproject.domain.facade.implementation;

import java.util.List;

import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.domain.facade.TabConfigInteractor;

public class TabConfigInteractorImpl implements TabConfigInteractor {

    private TabConfigInteractor netInteractor;

    private TabConfigInteractor cacheInteractor;

    public TabConfigInteractorImpl(TabConfigInteractor netInteractor, TabConfigInteractor cacheInteractor) {
        this.netInteractor = netInteractor;
        this.cacheInteractor = cacheInteractor;
    }

    @Override
    public List<TabConfig> getTabConfigList() {
        List<TabConfig> configs = netInteractor.getTabConfigList();
        if (configs == null) {
            configs = cacheInteractor.getTabConfigList();
        }
        return configs;
    }
}
