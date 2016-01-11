package ch.bfh.btx8108.w2015.androidmedicationapp2;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController.MedicationData;
import ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController.UserData;
import ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController.DailyTabs;
import ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController.Export;
import ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController.Medications;
import ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController.Settings;
import ch.bfh.btx8108.w2015.androidmedicationapp2.models.User;

/**
 * This java classes handles as a controller the starting view MainView
 *
 * @Created by johns2@bfh.ch on 05.11.2015
 */

public class MainView extends AppCompatActivity {
public static final int LOGGED_IN_USER_ID = 1;

    /**
     * This method is automatically generated by Android Studio and declares the actions while starting the app
     *
     * @param savedInstanceState Returns the saved instance state of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DailyTabs dailyTabs = new DailyTabs();
        setContentView(R.layout.activity_main);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //set username in drawer_header
        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        TextView navigationUsername = (TextView)headerView.findViewById(R.id.nav_header_main_userName);
        navigationUsername.setText(this.getCurrentUserObject(this.getApplicationContext()).getUsername());
        TextView navigationMailAddress = (TextView)headerView.findViewById(R.id.nav_header_main_mailAddress);
        navigationMailAddress.setText(this.getCurrentUserObject(this.getApplicationContext()).geteMailAddress());


        final FragmentManager fragmentManager;
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new DailyTabs()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawer.closeDrawers();

                int id = menuItem.getItemId();

                if (id == R.id.nav_medicationPlan) {
                    // Handle the daily tabs
                    FragmentTransaction fragmentTransaction =
                            fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new DailyTabs()).commit();
                } else if (id == R.id.nav_medicaments) {
                    openMedicationsFragment(fragmentManager);
                } else if (id == R.id.nav_export) {
                    // Handle the export feature
                    FragmentTransaction fragmentTransaction =
                            fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new Export()).commit();
                } else if (id == R.id.nav_settings) {
                    openSettingsFragment(fragmentManager);
                }
                return false;
            }
        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,drawer, toolbar,R.string.app_name,
                R.string.app_name);

        drawer.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();
    }

    public void openMedicationsFragment(FragmentManager fragmentManager){
        // Handle the medications fragment
        Medications newMedicationsFragment = new Medications();
        newMedicationsFragment.initMedicationsList(this.getMedicationsList(newMedicationsFragment.getContext()));
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, newMedicationsFragment).commit();
    }

    public void openSettingsFragment(FragmentManager fragmentManager){
        // Handle the settings fragment
        Bundle dataBundle = new Bundle();
        Settings newSettingsFragment = new Settings();
        newSettingsFragment.setArguments(dataBundle);

        User currentUser = this.getCurrentUserObject(newSettingsFragment.getContext());
        dataBundle.putParcelable("USERDATA", currentUser);

        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, newSettingsFragment).commit();
    }

    public ArrayList getMedicationsList(Context fragmentContext){
        MedicationData medicationsList = new MedicationData(fragmentContext);
        return medicationsList.getMedicationsListByAttribute("LongNameGerman");
    }

    public User getCurrentUserObject(Context fragmentContext){
        UserData UserList = new UserData(fragmentContext);
        return UserList.getUserObjects().get(LOGGED_IN_USER_ID);
    }

    public void updateCurrentUserObject(Context fragmentContext, User currentUser){
        UserData UserList = new UserData(fragmentContext);
        UserList.updateUser(currentUser.getUser_id(), currentUser.getUsername(), currentUser.getFirstname(),
                currentUser.getLastname(), currentUser.geteMailAddress(), currentUser.getMute(),
                currentUser.getNotificationSound(), currentUser.getNotificationVibration());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
