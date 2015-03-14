package com.crosp.solutions.malibushop;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.crosp.solutions.malibushop.list_fragment.CategoryListFragment;
import com.crosp.solutions.malibushop.list_fragment.ListItemCallbacks;
import com.crosp.solutions.malibushop.navigation_drawer.NavigationDrawerCallbacks;
import com.crosp.solutions.malibushop.navigation_drawer.NavigationDrawerFragment;
import com.crosp.solutions.malibushop.slider.SlideFragment;


public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks,ListItemCallbacks {

    private Toolbar mToolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.list_container, new CategoryListFragment())
                    .add(R.id.slide_ad_container,new SlideFragment())
                    .commit();
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }

    @Override
    public void onListItemClick(int position) {
        Toast.makeText(this, "Item selected -> " + position, Toast.LENGTH_SHORT).show();
    }
}
