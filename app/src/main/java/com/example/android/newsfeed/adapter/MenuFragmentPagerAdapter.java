package com.example.android.newsfeed.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.newsfeed.R;
import com.example.android.newsfeed.fragment.HomeFragment;
import com.example.android.newsfeed.fragment.MenuFragment;
import com.example.android.newsfeed.fragment.ScienceFragment;
import com.example.android.newsfeed.fragment.SportFragment;
import com.example.android.newsfeed.fragment.WorldFragment;
import com.example.android.newsfeed.utils.Constants;

public class MenuFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public MenuFragmentPagerAdapter(Context context,@NonNull FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

//        return new MenuFragment();
        switch (position) {
            case Constants.HOME:
                return new Fragment();
            case Constants.WORLD:
                return new MenuFragment();
            case Constants.SCIENCE:
                return new Fragment();
            case Constants.SPORT:
                return new Fragment();
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int titleResId;
        switch (position) {
            case Constants.HOME:
                titleResId = R.string.ic_title_home;
                break;
            case Constants.WORLD:
                titleResId = R.string.ic_title_world;
                break;
            case Constants.SCIENCE:
                titleResId = R.string.ic_title_science;
                break;
            case Constants.SPORT:
                titleResId = R.string.ic_title_sport;
                break;
            default:
                titleResId = R.string.ic_title_home;
                break;
        }
        return mContext.getString(titleResId);
    }
}
