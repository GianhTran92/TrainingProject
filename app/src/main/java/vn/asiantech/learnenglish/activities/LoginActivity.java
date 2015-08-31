package vn.asiantech.learnenglish.activities;

import android.app.Activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import vn.asiantech.learnenglish.R;

@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity {
    @AfterViews
    void afterViews(){

    }

    @Click(R.id.btnTest)
    void test(){
       MainActivity_.intent(this).start();
    }
}
