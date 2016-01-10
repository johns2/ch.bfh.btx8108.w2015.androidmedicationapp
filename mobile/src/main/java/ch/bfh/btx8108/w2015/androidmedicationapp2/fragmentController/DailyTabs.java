package ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController;

import android.support.v4.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.bfh.btx8108.w2015.androidmedicationapp2.R;

/**
 * @Created by johns2@bfh.ch at 26.11.2015.
 */
public class DailyTabs extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int items = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.activity_daily_tabs, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        viewPager.setAdapter(new TabAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return x;
    }

    class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new DailyDosette();
                case 1:
                    return new DailyList();
            }
            return null;
        }

        public int getCount() {
            return items;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Dosett";
                case 1:
                    return "Liste";
            }
            return null;
        }
    }
}