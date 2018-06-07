package testproject.vlad.humeniuk.testproject.ui.main.view.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;
import testproject.vlad.humeniuk.testproject.ui.tab.TabFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private List<TabConfig> tabConfigList;

    public PagerAdapter(FragmentManager fm, List<TabConfig> tabConfigList) {
        super(fm);
        this.tabConfigList = tabConfigList;
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(tabConfigList.get(position));
    }

    @Override
    public int getCount() {
        return tabConfigList.size();
    }
}
