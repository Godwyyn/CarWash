package com.godwyn.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String LOG_TAG = MainActivity.class.getSimpleName();
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    ActionBarDrawerToggle drawerToggle;
    CircleImageView profilePix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();

        ab.setHomeAsUpIndicator(R.drawable.ic_drawer);
        ab.setDisplayHomeAsUpEnabled(true);

        //navigation_traveler menu

        // Find our drawer view
        nvDrawer = (NavigationView) mDrawer.findViewById(R.id.nvView);


        View header = nvDrawer.inflateHeaderView(R.layout.nav_header);

        // Tie DrawerLayout events to the ActionBarToggle
        drawerToggle = setupDrawerToggle();
        mDrawer.setDrawerListener(drawerToggle);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    }


    private void setupDrawerContent(NavigationView navigationView) {

        // get login and logout MenuItem so Dynamic visib
       // logoutMenuItem = navigationView.getMenu().findItem(R.id.logout);
       // loginMenuItem = navigationView.getMenu().findItem(R.id.login_item);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }


    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the planet to show based on
        // position
        Fragment fragment = null;


        Class fragmentClass;
        switch (menuItem.getItemId()) {
            //case R.id.nav_first_fragment:
            ///// Toast.makeText(this , "navigation_traveler first ", Toast.LENGTH_LONG).show();
            //  fragmentClass  =  BeginTransferFragment.class ;
            // break;


            case R.id.invite_friend_item:
              //  onInviteClicked();

                break;

            case R.id.profile_item:

                // check if its a guess user or none login user, ask for login first
              /*  if (currentUser.isAnonymous() || currentUser == null) {
                    login();
                } else {
                    Intent profileIntent = new Intent(IbomHome.this, Profile.class);
                    startActivity(profileIntent);
                }*/
                break;

            case R.id.help_item:
                //Intent helpIntent = new Intent(IbomHome.this, Help.class);
              //  startActivity(helpIntent);

                break;

            case R.id.login_item:
              //  login();
                break;

            case R.id.logout:

               // logout();
                break;

            case R.id.settings_item:

               // Intent settingsIntent = new Intent(IbomHome.this, Settings.class);
              //  startActivity(settingsIntent);


                break;


            default:
                Toast.makeText(this, "navigation second ", Toast.LENGTH_LONG).show();

                //fragmentClass = BeginTransferFragment.class;

        }

        try {
            // fragment = (Fragment) BeginTransferFragment.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        // fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();


    }

}
