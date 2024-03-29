package emanage.com.eshopy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import emanage.com.eshopy.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        	case R.id.nav_Categories:
            {
                break;
            }
            case R.id.nav_Wishlist:
            {
                break;
            }
            case  R.id.nav_Order:
            {
                break;
            }
            case R.id.nav_cart:
            {
                break;
            }
            case R.id.nav_myAccount:
            {
                break;
            }
            case R.id.nav_Login:
            {
				Intent intent=new Intent(MainActivity.this,Login.class);
				startActivity(intent);
                break;
            }
            case R.id.nav_Register:
            {
				Intent intent=new Intent(MainActivity.this,Registration.class);
				startActivity(intent);
                break;
            }
        }
        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_Home) {
//        } else if (id == R.id.nav_Categories) {
//
//        } else if (id == R.id.nav_Wishlist) {
//
//        } else if (id == R.id.nav_Order) {
//
//        } else if (id == R.id.nav_cart) {
//
//        } else if (id == R.id.nav_myAccount) {
//
//        } else if (id == R.id.nav_Login) {
//
//		} else if (id == R.id.nav_Register) {
//
//		} else if(id==R.id.action_settings)
//        {
//            Intent intent=new Intent(MainActivity.this,Registration.class);
//            startActivity(intent);
//        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
