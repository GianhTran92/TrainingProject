package vn.asiantech.learnenglish.fragment;


import android.support.v4.app.Fragment;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.containers.TopContainers;
import vn.asiantech.learnenglish.core.BaseFragment;
import vn.asiantech.learnenglish.core.ListTopAdapter;
import vn.asiantech.learnenglish.model.TopData;
import vn.asiantech.learnenglish.model.TopModel;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_top)
public class TopFragment extends BaseFragment {

    ArrayList<TopModel> mTop;
    ListTopAdapter mTopAdapter;

    @ViewById(R.id.lvTop)
    ListView mLvTop;

    @AfterViews
    void afterView(){
        mTop = new ArrayList<TopModel>();
        int i = 0;
        while(i<TopData.getTitle().length){
            TopModel mTopModel = new TopModel(TopData.getTitle()[i], TopData.getAvatar()[i]);
            mTop.add(mTopModel);
            i++;
        }
        mTopAdapter = new ListTopAdapter(getActivity(), mTop);
        mLvTop.setAdapter(mTopAdapter);

    }

    @ItemClick(R.id.lvTop)
    void clickItems(){
        ((TopContainers)getParentFragment()).replaceFragment(new TopListItemFragment_(),true);
    }
}
