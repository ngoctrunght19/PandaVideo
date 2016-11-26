package com.example.lenovo.pandavideo;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    // chỗ này thay dổi icon cho từng tab
    // hiên tại để cả bốn tab giống nhau
    private int[] tabIcons = {
            R.drawable.ic_home_black_24px,
            R.drawable.ic_play_circle_filled_black_24px,
            R.drawable.ic_subscriptions_black_24px,
            R.drawable.ic_account_circle_black_24px
    };

    private int nTabs = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        setSupportActionBar(toolbar);


        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        setTabIcons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapterWithoutTitle adapter = new ViewPagerAdapterWithoutTitle(getSupportFragmentManager());
        adapter.addFragment(new Tab1());
        adapter.addFragment(new Tab1());
        adapter.addFragment(new Tab1());
        adapter.addFragment(new TabAccount());
        viewPager.setAdapter(adapter);
    }

    private void setTabIcons() {

        for (int i = 0; i < nTabs; i++) {
            Log.v("i: ", "" + i);
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }

        final int colorAccent = getResources().getColor(R.color.colorAccent);
        final int colorUnselect = getResources().getColor(R.color.colorUnselect);

        tabLayout.getTabAt(0).getIcon().setColorFilter(colorAccent, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(colorUnselect, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(colorUnselect, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(colorUnselect, PorterDuff.Mode.SRC_IN);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(colorAccent, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(colorUnselect, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}