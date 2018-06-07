package testproject.vlad.humeniuk.testproject.ui.main.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import testproject.vlad.humeniuk.testproject.R;
import testproject.vlad.humeniuk.testproject.TabApplication;
import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.ui.main.presenter.MainPresenter;
import testproject.vlad.humeniuk.testproject.ui.main.presenter.MainPresenterImpl;
import testproject.vlad.humeniuk.testproject.ui.main.view.pager.PagerAdapter;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager viewPager;

    private PagerAdapter pagerAdapter;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(tabListener);

        presenter = new MainPresenterImpl(((TabApplication) getApplication())
                .getInteractorFactory().provideTabConfigInteractor());
        presenter.setView(this);

        presenter.init();
    }

    @Override
    public void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showTabs(List<TabConfig> tabConfigList) {
        for (TabConfig tabConfig : tabConfigList) {
            tabLayout.addTab(tabLayout.newTab().setText(tabConfig.getTitle()));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabConfigList);
        viewPager.setAdapter(pagerAdapter);
    }

    private TabLayout.OnTabSelectedListener tabListener = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
}
