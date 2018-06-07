package testproject.vlad.humeniuk.testproject.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.domain.mapper.TabConfigMapper;
import testproject.vlad.humeniuk.testproject.network.entity.config.ConfigResponse;
import testproject.vlad.humeniuk.testproject.network.entity.config.TabAttributes;
import testproject.vlad.humeniuk.testproject.network.entity.config.TabData;

import static org.junit.Assert.assertEquals;

public class TabConfigMapperTest {

    private TabConfigMapper mapper;

    @Before
    public void init() {
        mapper = new TabConfigMapper();
    }

    @Test
    public void testMap() {
        List<TabConfig> actual = mapper.map(getResponse());

        assertEquals(getExpected(), actual);
    }

    private ConfigResponse getResponse() {
        ConfigResponse response = new ConfigResponse();
        TabData data = new TabData();
        TabAttributes attributes = new TabAttributes();
        attributes.setTitle("Tab 1 title");
        attributes.setBody("Tab 1 body");
        data.setAttributes(attributes);
        data.setId(1);
        data.setType("tabconfig");
        List<TabData> dataList = new ArrayList<>();
        dataList.add(data);
        response.setData(dataList);
        return response;
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
