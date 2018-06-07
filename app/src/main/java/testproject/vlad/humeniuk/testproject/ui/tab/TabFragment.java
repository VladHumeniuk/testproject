package testproject.vlad.humeniuk.testproject.ui.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import testproject.vlad.humeniuk.testproject.R;
import testproject.vlad.humeniuk.testproject.domain.entity.TabConfig;

public class TabFragment extends Fragment {

    private static final String CONFIG_ARG = "config_arg";

    @BindView(R.id.tab_body)
    AppCompatTextView bodyView;

    private Unbinder unbinder;

    public static TabFragment newInstance(TabConfig tabConfig) {
        Bundle args = new Bundle();
        args.putParcelable(CONFIG_ARG, tabConfig);

        TabFragment fragment = new TabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        unbinder = ButterKnife.bind(this, view);
        TabConfig config = getArguments().getParcelable(CONFIG_ARG);
        bodyView.setText(config.getBody());
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
