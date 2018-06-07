package testproject.vlad.humeniuk.testproject.ui.main.view;

import java.util.List;

import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;

public interface MainView {

    void showProgress(boolean show);

    void showTabs(List<TabConfig> tabConfigList);
}
