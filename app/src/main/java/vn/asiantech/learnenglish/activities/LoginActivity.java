package vn.asiantech.learnenglish.activities;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.fragment.LoginFragment_;

@EActivity(R.layout.activity_login)
public class LoginActivity extends FragmentActivity {
    @ViewById(R.id.imgLogosmall)
    ImageView mImglogosmall;

    @AfterViews
    void afterViews(){
        loadSplashscreen();
    }

    public void loadSplashscreen() {
        Thread splashTimer = new Thread() {

            @Override
            public void run() {
                try {
                    int LogoTimer = 0;
                    while (LogoTimer < 3000) {
                        sleep(100);
                        LogoTimer += 100;
                        //Log.e(TAG, "run " + LogoTimer);
                    }
                    addFragment(R.id.frameContain, LoginFragment_.builder().build(), "LoginFragment");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    /* finish(); */
                }
            }
        };
        splashTimer.start();
    }
    public void addFragment(@IdRes int containerViewId,
                            @NonNull Fragment fragment,
                            @NonNull String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();

    }
}
