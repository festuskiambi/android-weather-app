package com.festus.refuniteandroidchallenge.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.festus.refuniteandroidchallenge.R;
import com.festus.refuniteandroidchallenge.fragments.AllCitiesFragment;
import com.festus.refuniteandroidchallenge.fragments.MyLocationFragment;


public class MainActivity extends AppCompatActivity {
    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.mainactivity_viewpager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_mainactvity);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment=null;
            if(i==0){
                fragment = new MyLocationFragment();

            }
            if(i==1){
                fragment = new AllCitiesFragment();
            }

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int i) {
            if(i==0){
                return "My Location";


            }
            else{
                return "Other Cities";
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
