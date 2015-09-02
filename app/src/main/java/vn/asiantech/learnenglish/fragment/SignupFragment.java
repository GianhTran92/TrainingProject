package vn.asiantech.learnenglish.fragment;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.activities.MainActivity_;

@EFragment(R.layout.fragment_signup)
public class SignupFragment extends Fragment {
    @ViewById(R.id.edtUsername)
    EditText mEdtUsername;

    @ViewById(R.id.edtPassword)
    EditText mEdtPassword;

    @ViewById(R.id.edtEmail)
    EditText mEdtEmail;

    @ViewById(R.id.edtConfirmPassword)
    EditText mEdtConfirmPassword;

    @ViewById(R.id.edtPromotionCode)
    EditText mEdtPromotionCode;

    @ViewById(R.id.btnSignup)
    Button mBtnSignup;

    @ViewById(R.id.btnSignin)
    Button mBtnSignin;

    @AfterViews
    void affterView(){

    }

    @Click(R.id.btnSignup)
    void setmBntSignup(){
        MainActivity_.intent(this).start();
    }

    @Click(R.id.btnSignin)
    void setmBntSignin(){
        replaceFragment(R.id.frameContain, LoginFragment_.builder().build(), "SigninFragment", null);
    }

    protected void replaceFragment(@IdRes int containerViewId,
                                   @NonNull Fragment fragment,
                                   @NonNull String fragmentTag,
                                   @Nullable String backStackStateName) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .addToBackStack(null)
                .commit();
    }
}
