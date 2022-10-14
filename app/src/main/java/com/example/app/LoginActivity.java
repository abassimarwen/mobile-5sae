package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    FloatingActionButton fb,twitter,google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewPager = findViewById(R.id.login_view_pager);
        tabLayout = findViewById(R.id.tabLayout2);
        fb = findViewById(R.id.facebook_button);
        twitter = findViewById(R.id.twitter_button);
        google = findViewById(R.id.google_button);
        tabLayout.addTab(tabLayout.newTab().setText("sign in"));
        tabLayout.addTab(tabLayout.newTab().setText("sign up"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final Adapter adapter = new Adapter(getSupportFragmentManager(),this,tabLayout.getTabCount());

        //  viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(adapter);
    }
}