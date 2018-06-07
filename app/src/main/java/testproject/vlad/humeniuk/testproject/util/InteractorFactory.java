package testproject.vlad.humeniuk.testproject.util;

import android.content.res.Resources;

import testproject.vlad.humeniuk.testproject.domain.facade.TabConfigInteractor;
import testproject.vlad.humeniuk.testproject.domain.facade.implementation.TabConfigCacheInteractor;
import testproject.vlad.humeniuk.testproject.domain.facade.implementation.TabConfigInteractorImpl;
import testproject.vlad.humeniuk.testproject.domain.facade.implementation.TabConfigNetInteractor;
import testproject.vlad.humeniuk.testproject.network.ConfigApi;

public class InteractorFactory {

    private ConfigApi api;

    private Resources resources;

    public InteractorFactory(ConfigApi api, Resources resources) {
        this.api = api;
        this.resources = resources;
    }

    public TabConfigInteractor provideTabConfigInteractor() {
        return new TabConfigInteractorImpl(provideTabConfigNetInteractor(), provideTabConfigCacheInteractor());
    }

    public TabConfigInteractor provideTabConfigCacheInteractor() {
        return new TabConfigCacheInteractor(new ResourceReader(resources));
    }

    public TabConfigInteractor provideTabConfigNetInteractor() {
        return new TabConfigNetInteractor(api);
    }
}
