package com.leyline.namespace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.leyline.namespace.fragments.FormFragment;
import com.leyline.namespace.fragments.LineFragment;
import com.leyline.namespace.fragments.PointFragment;
import com.leyline.namespace.fragments.ShapeFragment;

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

        prepareTabBar();
    }

    public void prepareTabBar() {
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);

        createFragments();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        addFragmentsToViewPagerAdapter(viewPagerAdapter);
        viewPager.setAdapter(viewPagerAdapter);
        setAppBarIcons();
    }

    public void createFragments() {
        pointFragment = new PointFragment();
        lineFragment = new LineFragment();
        shapeFragment = new ShapeFragment();
        formFragment = new FormFragment();
    }

    private void addFragmentsToViewPagerAdapter(ViewPagerAdapter viewPagerAdapter) {
        viewPagerAdapter.addFragment(pointFragment, "point");
        viewPagerAdapter.addFragment(lineFragment, "line");
        viewPagerAdapter.addFragment(shapeFragment, "shape");
        viewPagerAdapter.addFragment(formFragment, "form");
    }

    private void setAppBarIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.point);
        tabLayout.getTabAt(1).setIcon(R.drawable.line);
        tabLayout.getTabAt(2).setIcon(R.drawable.shape);
        tabLayout.getTabAt(3).setIcon(R.drawable.form);
    }
}
