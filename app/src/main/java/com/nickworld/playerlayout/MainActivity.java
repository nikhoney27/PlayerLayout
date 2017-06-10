package com.nickworld.playerlayout;

import android.content.Context;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nickworld.playerlayout.adapters.SlidingAdapter;
import com.nickworld.playerlayout.adapters.ViewPagerAdapter;
import com.nickworld.playerlayout.models.HeaderModel;
import com.viewpagerindicator.CirclePageIndicator;


import java.util.ArrayList;


/**
 * Created by Nikhil Sharma on 6/9/2017.
 */

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private Context mContext;
    private ArrayList<HeaderModel> modelArrayList;
    private Toolbar mToolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;


        //setting up toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextAppearance(mContext, R.style.MyTitleTextApperance);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("HOME");

        }

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pagerVertical);
        setupViewPager(viewPager);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.select_video);
        tabLayout.getTabAt(1).setIcon(R.drawable.image);
        tabLayout.getTabAt(2).setIcon(R.drawable.milestone);


        //toggle image on selected listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("VIDEOS")) {
                    tab.setIcon(R.drawable.select_video);

                } else if (tab.getText().equals("IMAGES")) {
                    tab.setIcon(R.drawable.select_image);
                } else {
                    tab.setIcon(R.drawable.select_milestone);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getText().equals("VIDEOS")) {
                    tab.setIcon(R.drawable.video);

                } else if (tab.getText().equals("IMAGES")) {
                    tab.setIcon(R.drawable.image);
                } else {
                    tab.setIcon(R.drawable.milestone);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // putting static data on to headerModel
        modelArrayList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            HeaderModel headerModel = new HeaderModel();
            headerModel.setImagePathName("eminem");
            headerModel.setImagetitle("New " + i);
            modelArrayList.add(headerModel);
        }


        //setting up ViewPager with PageIndicater
        setViewPager();

    }


    /**
     * This method is to set viewpager
     *
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VideoTab(), "VIDEOS");
        adapter.addFragment(new VideoTab(), "IMAGES");
        adapter.addFragment(new VideoTab(), "MILESTONE");
        viewPager.setAdapter(adapter);
    }


    /**
     * This method is to set view Pager and page indicator
     */
    private void setViewPager() {
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingAdapter(mContext, modelArrayList));
        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);
    }
}
