package vn.asiantech.learnenglish.fragment;

import android.app.Dialog;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.activities.MainActivity_;

@EFragment(R.layout.fragment_login)
public class LoginFragment extends Fragment {
    @ViewById(R.id.edtUsername)
    EditText mEdtusername;

    @ViewById(R.id.edtPassword)
    EditText mEditPassword;

    @ViewById(R.id.txtErorr)
    TextView mTxterorr;


    @Click(R.id.btnSignup)
    void setmBtnSignup(){
        replaceFragment(R.id.frameContain, SignupFragment_.builder().build(), "SignupFragment", null);
    }
    @Click(R.id.btnSignin)
    void setmBtnSignin(){
        String username = mEdtusername.getText().toString();
        String password = mEditPassword.getText().toString();

        if(username.equals("admin") && password.equals("admin")){
            MainActivity_.intent(this).start();
        }
        else{
            mTxterorr.setText(getResources().getString(R.string.error_account));
        }
    }
    @Click(R.id.txtForgetpassword)
    void setmTxtForgetpassword(){
        final Dialog mDialog = new Dialog(getActivity());
        mDialog.setContentView(R.layout.dialog_forgetpassword);
        mDialog.setTitle(getResources().getString(R.string.dialog_forget_password_title));
        EditText mEdtDialogUsername = (EditText) mDialog.findViewById(R.id.edtDialogUsername);
        Button mBntConfirm = (Button) mDialog.findViewById(R.id.bntConfirm);
        Button mBntCancel = (Button) mDialog.findViewById(R.id.bntCancel);

        mBntConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBntCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        mDialog.show();

    }

    @AfterViews
    void afterView(){

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
