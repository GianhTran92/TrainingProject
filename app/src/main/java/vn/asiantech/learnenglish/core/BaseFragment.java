package vn.asiantech.learnenglish.core;


import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * base for fragment extends to add and replace fragment
 */
public class BaseFragment extends Fragment {
    public String TAG = this.getClass().getSimpleName();
    public void addFragment(@IdRes int containerViewId,
                            @NonNull Fragment fragment,
                            @NonNull String fragmentTag) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();

    }
    public void replaceFragment(@IdRes int containerViewId,
                                   @NonNull Fragment fragment,
                                   @NonNull String fragmentTag,
                                   @Nullable String backStackStateName) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .addToBackStack(null)
                .commit();
    }
    public void replaceChildFragment(Activity activity,int view,Fragment fragment, boolean addToBackStack) {

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        } else {
            transaction.addToBackStack(fragment.getTag());
        }
        transaction.replace(view, fragment);

        if (activity != null && !activity.isFinishing()) {
            transaction.commitAllowingStateLoss();
        }
        getChildFragmentManager().executePendingTransactions();
    }
}
