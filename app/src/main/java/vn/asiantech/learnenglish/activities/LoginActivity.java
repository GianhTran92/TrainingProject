package vn.asiantech.learnenglish.activities;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.core.BaseActivity;
import vn.asiantech.learnenglish.fragment.LoginFragment_;

/***
 * the activity to load SplashScreen and contain to build login fragment and signUp fragment
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

    @AfterViews
    void afterViews() {
        loadSplashScreen();
    }

    private void loadSplashScreen() {
        Thread splashTimer = new Thread() {

            @Override
            public void run() {
                try {
                    int timer = 0;
                    while (timer < 3000) {
                        sleep(100);
                        timer += 100;
                    }
                    addFragment(R.id.frameContain, LoginFragment_.builder().build(), "LoginFragment");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        splashTimer.start();
    }

}
