package academy.tradeskills.helloworldandroid;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // calls the parent function
        super.onCreate(savedInstanceState);

        // This is the first function call in almost all android activities.
        // It uses an automatically generated R class to allow you to reference all of your resources
        // You then use that class to reference the layout you created for your activity.
        this.setContentView(R.layout.activity_main);
        // Now that the layout is loaded we can create references to the objects created there
        Toolbar toolbar = findViewById(R.id.toolbar);
        // Tells the parent where our toolbar is
        this.setSupportActionBar(toolbar);

        // Now we setup a listener to the click of our floating button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert("This is a fab button");
            }
        });

        // Next is our drawer on the side of the screen
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Then we grab a reference to our actual navigation toggle
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // Finally we connect the two together
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // First we check to see if the menu is open in order to close it before closing the app
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            // close the drawer
            drawer.closeDrawer(GravityCompat.START);
        } else {
            // close the app
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
            this.showAlert("This is where you go to the settings.");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            this.showAlert("This is where we go home");
        } else if (id == R.id.nav_gallery) {
            this.showAlert("This is where we go to the gallery");
        } else if (id == R.id.nav_slideshow) {
            this.showAlert("This is where we go to the slide show");
        } else if (id == R.id.nav_tools) {
            this.showAlert("This is where we go to the tools");
        } else if (id == R.id.nav_share) {
            this.showAlert("Sharing is fun");
        } else if (id == R.id.nav_send) {
            this.showAlert("Let's send something");
        }

        // Close the menu after we handle the click
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * This creates an aler for the user to see
     * @param message
     */
    public void showAlert(String message) {
        // Create an alert builder
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        // Set the message
        alert.setMessage(message);
        // Add a button
        alert.setPositiveButton("OK", new AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        // then we show it
        alert.show();
    }
}
