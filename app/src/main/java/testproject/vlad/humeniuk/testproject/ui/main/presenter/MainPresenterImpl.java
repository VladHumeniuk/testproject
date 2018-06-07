package testproject.vlad.humeniuk.testproject.ui.main.presenter;

import android.os.Handler;
import android.os.Looper;

import java.util.List;

import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.domain.facade.TabConfigInteractor;
import testproject.vlad.humeniuk.testproject.ui.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;

    private TabConfigInteractor tabConfigInteractor;

    private ConfigLoader configLoader;

    public MainPresenterImpl(TabConfigInteractor tabConfigInteractor) {
        this.tabConfigInteractor = tabConfigInteractor;
        this.configLoader = new ConfigLoader();
    }

    @Override
    public void setView(MainView view) {
        this.view = view;
    }

    @Override
    public void init() {
        loadTabConfig();
    }

    private void loadTabConfig() {
        view.showProgress(true);
        new Thread(configLoader).start();
    }

    private void showConfig(List<TabConfig> tabConfigs) {
        view.showProgress(false);
        view.showTabs(tabConfigs);
    }

    private class ConfigLoader implements Runnable {

        @Override
        public void run() {
            List<TabConfig> tabConfigs = tabConfigInteractor.getTabConfigList();
            new Handler(Looper.getMainLooper()).post(() -> showConfig(tabConfigs));
        }
    }
}
