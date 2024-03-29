package vn.asiantech.learnenglish.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.activities.MainActivity_;
import vn.asiantech.learnenglish.core.BaseFragment;
/*
 * fragment for login to app
 */
@EFragment(R.layout.fragment_login)
public class LoginFragment extends BaseFragment implements OnClickListener{
    private Dialog mDialog;

    @ViewById(R.id.edtUsername)
    EditText mEdtUserName;

    @ViewById(R.id.edtPassword)
    EditText mEditPassword;

    @ViewById(R.id.txtError)
    TextView mTxtError;

    @ViewById(R.id.edtDialogUsername)
    EditText mEdtDialogUserName;

    @ViewById(R.id.btnConfirm)
    Button mBtnConfirm;

    @ViewById(R.id.btnCancel)
    Button mBtnCancel;


    @Click(R.id.btnSignup)
    void clickSignUp(){
        replaceFragment(R.id.frameContain, SignupFragment_.builder().build(), "SignupFragment", null);
    }
    @Click(R.id.btnSignin)
    void clickSignIn(){
        String username = mEdtUserName.getText().toString();
        String password = mEditPassword.getText().toString();

        if(username.equals("admin") && password.equals("admin")){
            MainActivity_.intent(this).start();
        }
        else{
            mTxtError.setText(getResources().getString(R.string.error_account));
        }
    }
    @Click(R.id.txtForgetpassword)
    void clickForgetPassword(){
        mDialog = new Dialog(getActivity());
        mDialog.setContentView(R.layout.dialog_forgetpassword);
        mDialog.setTitle(getResources().getString(R.string.dialog_forget_password_title));
        mDialog.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfirm:
                mEdtDialogUserName.getText().toString().trim();
            case R.id.btnCancel:
                mDialog.dismiss();
            break;
        }
    }
}
