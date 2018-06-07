package testproject.vlad.humeniuk.testproject.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.network.entity.config.ConfigResponse;
import testproject.vlad.humeniuk.testproject.network.entity.config.TabAttributes;
import testproject.vlad.humeniuk.testproject.network.entity.config.TabData;

public class TabConfigMapper implements BaseMapper<ConfigResponse, List<TabConfig>> {

    @Override
    public List<TabConfig> map(ConfigResponse entity) {
        List<TabConfig> tabConfigs = new ArrayList<>();
        if (entity.getData() == null) {
            return null;
        }
        for (TabData tabData : entity.getData()) {
            TabConfig tabConfig = new TabConfig();
            TabAttributes attributes = tabData.getAttributes();
            tabConfig.setTitle(attributes.getTitle());
            tabConfig.setBody(attributes.getBody());
            tabConfigs.add(tabConfig);
        }

        return tabConfigs;
    }
}
