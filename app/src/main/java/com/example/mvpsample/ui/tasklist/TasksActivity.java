package com.example.mvpsample.ui.tasklist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mvpsample.R;
import com.example.mvpsample.data.Injection;
import com.example.mvpsample.utils.ActivityUtils;
import com.google.android.material.navigation.NavigationView;

public class TasksActivity extends AppCompatActivity {

    private static final String CURRENT_FILTERING_KEY = "current_filtering_key";

    private DrawerLayout mDrawerLayout;

    private TasksPresenter mTasksPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("MvpDemo");

        //set up the navigation drawer
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this::itemSelected);
        }
        TasksFragment tasksFragment =
                (TasksFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            //create the fragment
            tasksFragment = TasksFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }

        mTasksPresenter = new TasksPresenter(Injection.provideTasksRepository(this), tasksFragment, Injection.providerSchedulerProvider());

    }

    private boolean itemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.list_navigation_menu_item:
                // Do nothing, we're already on that screen
                break;
            case R.id.statistics_navigation_menu_item:
//                Intent intent =
//                        new Intent(TasksActivity.this, StatisticsActivity.class);
//                startActivity(intent);
                break;
            default:
                break;
        }
        //close the navigation drawer when an item is selected
        menuItem.setChecked(true);
        mDrawerLayout.closeDrawers();
        return true;
    }

}

