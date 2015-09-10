package vn.asiantech.learnenglish.fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.core.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */


public class Tab4Fragment extends BaseFragment {
    private ImageButton imgBtnNotification;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab4, container, false);
        imgBtnNotification = (ImageButton) view.findViewById(R.id.imgBtnNotificationSettings);
        imgBtnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmFragment alarmFragment = new AlarmFragment();

                replaceFragment(R.id.frameContain,alarmFragment,"alarmFragment",null);



            }
        });
        return view;
    }

}
