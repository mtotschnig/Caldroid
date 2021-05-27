package com.roomorama.caldroid;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * MonthPagerAdapter holds 4 fragments, which provides fragment for current
 * month, previous month and next month. The extra fragment helps for recycle
 * fragments.
 *
 * @author thomasdao
 */
public class MonthPagerAdapter extends FragmentPagerAdapter {

    public MonthPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        DateGridFragment fragment = new DateGridFragment();
        Bundle args = new Bundle(1);
        args.putInt(CaldroidFragment.KEY_GRID_POSITION_IN_ADAPTER, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        // We need 4 gridviews for previous month, current month and next month,
        // and 1 extra fragment for fragment recycle
        return CaldroidFragment.NUMBER_OF_PAGES;
    }

}
