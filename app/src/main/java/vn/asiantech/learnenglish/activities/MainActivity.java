package vn.asiantech.learnenglish.activities;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.core.ActionBarCustom;
import vn.asiantech.learnenglish.fragment.FavoriteFragment_;
import vn.asiantech.learnenglish.fragment.QuestionFragment_;
import vn.asiantech.learnenglish.fragment.SettingFragment_;
import vn.asiantech.learnenglish.fragment.TopFragment_;
import vn.asiantech.learnenglish.tabstrip.PagerSlidingTabStrip;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    @ViewById
    ViewPager vpTest;
    @ViewById
    PagerSlidingTabStrip tabs;
    @ViewById
    ActionBarCustom toolbar;

    private String mTitle = "";
    private int mImageRight = R.drawable.icon_search;

    @AfterViews
    public void afterViews() {
        setTabsTrip();
        setEvent();
    }

    private void setTabsTrip() {
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        vpTest.setAdapter(adapter);
        tabs.setViewPager(vpTest);
        mTitle = getResources().getString(R.string.top);
        toolbar.setTitle(mTitle);
        toolbar.setImageResource(mImageRight);
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
                        mTitle = getResources().getString(R.string.top);
                        break;
                    case 1:
                        mTitle = getResources().getString(R.string.favorite);
                        break;
                    case 2:
                        mTitle = getResources().getString(R.string.question);
                        break;
                    case 3:
                        mTitle = getResources().getString(R.string.setting);
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
        private final int[] ICONS = {R.drawable.icon1,
                R.drawable.icon2,
                R.drawable.icon3,
                R.drawable.icon4};

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
                    return new TopFragment_();
                case 1:
                    return new FavoriteFragment_();
                case 2:
                    return new QuestionFragment_();
                case 3:
                    return new SettingFragment_();
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
