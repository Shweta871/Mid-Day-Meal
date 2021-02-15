/*

 */

/*
 *
 */

package com.branding.middaymeal.ui.login;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final int TOTAL_PAGES = 2;
    private final Context mContext;
    private LoginFragment loginFragment;
    private SignupFragment signupFragment;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            loginFragment = new LoginFragment();
            return loginFragment;
        } else {
            signupFragment = new SignupFragment();
            return signupFragment;
        }
    }


    @Override
    public int getCount() {
        return TOTAL_PAGES;
    }
}