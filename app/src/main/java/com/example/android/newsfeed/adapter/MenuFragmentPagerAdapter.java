package com.example.android.newsfeed.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.newsfeed.R;
import com.example.android.newsfeed.fragment.MenuFragment;
import com.example.android.newsfeed.fragment.OrdersFragment;
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
        switch (position) {
            case Constants.HOME:
                return new Fragment();
            case Constants.MENU:
                return new MenuFragment();
            case Constants.ORDERS:
                return new OrdersFragment();
//            case Constants.SPORT:
//                return new Fragment();
            default:
                return new MenuFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int titleResId;
        switch (position) {
            case Constants.HOME:
                titleResId = R.string.ic_title_home;
                break;
            case Constants.MENU:
                titleResId = R.string.ic_title_world;
                break;
            case Constants.ORDERS:
                titleResId = R.string.ic_title_science;
                break;
//            case Constants.SPORT:
//                titleResId = R.string.ic_title_sport;
//                break;
            default:
                titleResId = R.string.ic_title_home;
                break;
        }
        return mContext.getString(titleResId);
    }
}
