package testproject.vlad.humeniuk.testproject.interactor;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import testproject.vlad.humeniuk.testproject.Constants;
import testproject.vlad.humeniuk.testproject.R;
import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.domain.facade.TabConfigInteractor;
import testproject.vlad.humeniuk.testproject.domain.facade.implementation.TabConfigCacheInteractor;
import testproject.vlad.humeniuk.testproject.util.ResourceReader;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TabConfigCacheInteractorTest {

    @Mock
    private ResourceReader mockedResourceReader;

    private TabConfigInteractor interactor;

    @Before
    public void init() {
        interactor = new TabConfigCacheInteractor(mockedResourceReader);
    }

    @Test
    public void testGetConfig() {
        when(mockedResourceReader.readRawResource(R.raw.cachedconfig)).thenReturn(Constants.Response.TEST_RESPONSE);

        List<TabConfig> actual = interactor.getTabConfigList();
        assertEquals(getExpected(), actual);
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
