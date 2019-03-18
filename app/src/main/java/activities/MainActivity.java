package activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cookingtime.cookingtime.R;

import fragments.AboutFragment;
import fragments.ContactsFragment;
import fragments.DashboardFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // If the activity is being created for the first time, then display the QuotationFragment,
        // otherwise let the system recreate whatever was being displayed previously
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new DashboardFragment())
                    .commit();

            ((NavigationView) findViewById(R.id.nav_view)).setCheckedItem(R.id.mDashboardNavigation);
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        String tag = null;

        // Determine the action to take place according to the Id of the action selected
        switch (item.getItemId()) {
            case R.id.mDashboardNavigation:
                tag = "dashboard";
                fragment = getSupportFragmentManager().findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = DashboardFragment.newInstance("username");
                }
                // Display the LogInFragment title on the ActionBar
                toolbar.setTitle(R.string.title_dashboard_fragment);
                break;

            case R.id.mAboutNavigation:
                tag = "about";
                fragment = getSupportFragmentManager().findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = AboutFragment.newInstance();
                }
                // Display the LogInFragment title on the ActionBar
                toolbar.setTitle(R.string.title_about_fragment);
                break;

            case R.id.mContacsNavigation:
                tag = "contacts";
                fragment = getSupportFragmentManager().findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = ContactsFragment.newInstance();
                }
                // Display the LogInFragment title on the ActionBar
                toolbar.setTitle(R.string.title_contacts_fragment);
                break;
            case R.id.mDonateNavigation:
                tag = "donate";
                break;
            case R.id.mFavouriteNavigation:
                tag = "favourite";
                break;
            case R.id.mGroupsNavigation:
                tag = "groups";
                break;
            case R.id.mSearchNavigation:
                tag = "search";
                break;
            case R.id.mSettingsNavigation:
                tag = "settings";
                break;
            case R.id.mTwitterNavigation:
                tag = "twitter";
                break;

        }

        // Replace the existing Fragment by the new one
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment, tag)
                .commit();

        item.setChecked(true);

        // Close the drawer
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
