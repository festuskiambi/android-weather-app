package com.festus.refuniteandroidchallenge.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import com.festus.refuniteandroidchallenge.R;
import com.festus.refuniteandroidchallenge.fragments.AllCitiesFragment;
import com.festus.refuniteandroidchallenge.fragments.MyLocationFragment;
import com.festus.refuniteandroidchallenge.helpers.CheckConnectivity;


public class MainActivity extends AppCompatActivity {
    private static ViewPager viewPager;
    public  static  android.app.AlertDialog alertDialog;


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

        if (!checkConnectivity()){
            connectionErrorDialog(this);
        }
       else {

        }
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
                return "Nearby";


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
    public   boolean checkConnectivity() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null)
            return false;
        NetworkInfo infoMobi = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo infoWifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo.State connectionMobi = NetworkInfo.State.DISCONNECTED;
        NetworkInfo.State connectionWifi = NetworkInfo.State.DISCONNECTED;
        if (infoMobi != null)
            connectionMobi = infoMobi.getState();
        if (infoWifi != null)
            connectionWifi = infoWifi.getState();
        return (connectionMobi == NetworkInfo.State.CONNECTED) || (connectionWifi == NetworkInfo.State.CONNECTED);
    }
    public void connectionErrorDialog(final Context ctx) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ctx);

        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.connectivity_error, null))
                .setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                /*.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();

                        new LoadMyLibraryAsyncTask().execute();
                    }
                });
*/
        // create alert dialog
        alertDialog = builder.create();

        // show it
        alertDialog.show();

    }

}
