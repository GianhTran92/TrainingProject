package vn.asiantech.learnenglish.activities;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.fragment.Tab1Fragment;
import vn.asiantech.learnenglish.fragment.Tab2Fragment;
import vn.asiantech.learnenglish.fragment.Tab3Fragment;
import vn.asiantech.learnenglish.fragment.Tab4Fragment;
import vn.asiantech.learnenglish.tabstrip.PagerSlidingTabStrip;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    @ViewById
    ViewPager vpTest;
    @ViewById
    PagerSlidingTabStrip tabs;
    @ViewById
    Toolbar toolbar;

    private String mTitle = "";

    @AfterViews
    public void afterViews() {
        setTabsTrip();
        setEvent();
    }

    private void setTabsTrip() {
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        vpTest.setAdapter(adapter);
        tabs.setViewPager(vpTest);
        mTitle = getResources().getString(R.string.hello_world)+1;
        toolbar.setTitle(mTitle);
    }

    private void setEvent() {
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mTitle = getResources().getString(R.string.hello_world)+position;
                        break;
                    case 1:
                        mTitle = getResources().getString(R.string.hello_world)+position;
                        break;
                    case 2:
                        mTitle = getResources().getString(R.string.hello_world)+position;
                        break;
                    case 3:
                        mTitle = getResources().getString(R.string.hello_world)+position;
                        break;
                    default:
                        break;
                }
                toolbar.setTitle(mTitle);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // ADAPTER VIEWPAGER
    public class PageAdapter extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
        private static final int CUSTOM_ICON = -1;
        private final int[] ICONS = {R.drawable.selector_tab,
                R.drawable.selector_tab,
                R.drawable.selector_tab,
                R.drawable.selector_tab};

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "position: " + position;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Tab1Fragment();
                case 1:
                    return new Tab2Fragment();
                case 2:
                    return new Tab3Fragment();
                case 3:
                    return new Tab4Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            FragmentManager manager = ((Fragment) object).getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.remove((Fragment) object);
            trans.commit();

            super.destroyItem(container, position, object);
        }

        @Override
        public Drawable getPageIconDrawable(int position) {
            if (ICONS[position] == CUSTOM_ICON) {
                return null;
            }
            return getResources().getDrawable(ICONS[position]);
        }
    }
}
