package vn.asiantech.learnenglish.containers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.fragment.TopFragment_;

/**
 * Created by conall on 07/09/2015.
 */
public class TopContainers extends BaseContainerFragment{
    private boolean mIsViewInited;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.contain_layout, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!mIsViewInited) {
            mIsViewInited = true;
            initView();
        }
    }
    private void initView() {
        replaceFragment(new TopFragment_(), false);
    }

    @Override
    public Fragment getChildFragment() {
        return getChildFragmentManager().findFragmentById(R.id.container_framelayout);
    }
}
