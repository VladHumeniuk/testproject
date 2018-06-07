package testproject.vlad.humeniuk.testproject.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.domain.facade.TabConfigInteractor;
import testproject.vlad.humeniuk.testproject.domain.facade.implementation.TabConfigCacheInteractor;
import testproject.vlad.humeniuk.testproject.domain.facade.implementation.TabConfigInteractorImpl;
import testproject.vlad.humeniuk.testproject.domain.facade.implementation.TabConfigNetInteractor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TabConfigInteractorTest {

    @Mock
    public TabConfigCacheInteractor mockedCache;

    @Mock
    public TabConfigNetInteractor mockedNet;

    private TabConfigInteractor interactor;

    @Before
    public void init() {
        interactor = new TabConfigInteractorImpl(mockedNet, mockedCache);
    }

    @Test
    public void testGetCachedConfig() {
        when(mockedNet.getTabConfigList()).thenReturn(null);
        when(mockedCache.getTabConfigList()).thenReturn(getExpected());

        List<TabConfig> actual = interactor.getTabConfigList();

        assertEquals(getExpected(), actual);
    }

    @Test
    public void testGetNetConfig() {
        when(mockedNet.getTabConfigList()).thenReturn(getExpected());

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
