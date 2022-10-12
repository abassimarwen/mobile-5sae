package com.example.app;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class Adapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public Adapter(FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               SigninController signinController = new SigninController();
                return signinController;
            case 1:
                SignupController signupController = new SignupController();
                return signupController;
            default:
                return null;
        }
    }
}
