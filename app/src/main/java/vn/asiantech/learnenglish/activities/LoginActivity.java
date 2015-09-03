package vn.asiantech.learnenglish.activities;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.core.BaseActivity;
import vn.asiantech.learnenglish.fragment.LoginFragment_;

/***
 * the activity to load SplashScreen and contain to build login fragment and signup fragment
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

    @AfterViews
    void afterViews(){
        loadSplashScreen();
    }

    public void loadSplashScreen() {
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

}
