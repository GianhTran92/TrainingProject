package vn.asiantech.learnenglish.fragment;


import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.containers.TopContainers;
import vn.asiantech.learnenglish.core.BaseFragment;
import vn.asiantech.learnenglish.core.TopListItemAdapter;
import vn.asiantech.learnenglish.model.TopData;
import vn.asiantech.learnenglish.model.TopModel;

@EFragment(R.layout.fragment_top_list_item)
public class TopListItemFragment extends BaseFragment {
    ArrayList<TopModel> mTop;
    TopListItemAdapter mTopListItemAdapter;

    @ViewById(R.id.lvTopListItem)
    ListView mLvTopListItem;

    @AfterViews
    void afterViews(){
        mTop = new ArrayList<TopModel>();
        int i = 0;
        while(i< TopData.getTitle().length){
            TopModel mTopModel = new TopModel(TopData.getTitle()[i], TopData.getAvatar()[i]);
            mTop.add(mTopModel);
            i++;
        }
        mTopListItemAdapter = new TopListItemAdapter(getActivity(),mTop);
        mLvTopListItem.setAdapter(mTopListItemAdapter);
    }

    @ItemClick(R.id.lvTopListItem)
    void clickItems(){
        ((TopContainers)getParentFragment()).replaceFragment(new TopListItemDetailFragment_(), true);
    }

}
