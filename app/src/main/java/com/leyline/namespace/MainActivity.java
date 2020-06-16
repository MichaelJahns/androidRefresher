package com.leyline.namespace;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private PointFragment pointFragment;
    private LineFragment lineFragment;
    private ShapeFragment shapeFragment;
    private FormFragment formFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabLayout);

        pointFragment = new PointFragment();
        lineFragment = new LineFragment();
        shapeFragment = new ShapeFragment();
        formFragment = new FormFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //
        viewPagerAdapter.addFragment(pointFragment, "point");
        viewPagerAdapter.addFragment(lineFragment, "line");
        viewPagerAdapter.addFragment(shapeFragment, "shape");
        viewPagerAdapter.addFragment(formFragment, "form");

        viewPager.setAdapter(viewPagerAdapter);

        //Giving icons to TabItems
        tabLayout.getTabAt(0).setIcon(R.drawable.point);
        tabLayout.getTabAt(1).setIcon(R.drawable.line);
        tabLayout.getTabAt(2).setIcon(R.drawable.shape);
        tabLayout.getTabAt(3).setIcon(R.drawable.form);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }


        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}
