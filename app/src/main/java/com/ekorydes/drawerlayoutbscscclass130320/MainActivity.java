package com.ekorydes.drawerlayoutbscscclass130320;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView objectNavigationView;
    private DrawerLayout objectDrawerLayout;

    private View headerView;
    private ImageView profileIV;

    private ActionBarDrawerToggle objectActionBarDrawerToggle;
    private Toolbar objectToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStartedObjects();
    }

    private void getStartedObjects()
    {
        try
        {
            objectNavigationView=findViewById(R.id.navigationView);
            objectDrawerLayout=findViewById(R.id.drawerLayout);

            headerView=objectNavigationView.getHeaderView(0);
            profileIV=headerView.findViewById(R.id.header_IV);

            objectToolbar=findViewById(R.id.toolBar);
            profileIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Profile is clicked", Toast.LENGTH_SHORT).show();
                }
            });
            objectNavigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            if(item.getItemId()==R.id.item_songs)
                            {
                                Toast.makeText(MainActivity.this, "Sons is here", Toast.LENGTH_SHORT).show();
                                closeMyDrawer();
                                return true;
                            }
                            else if(item.getItemId()==R.id.item_search)
                            {
                                Toast.makeText(MainActivity.this, "Search is here", Toast.LENGTH_SHORT).show();
                                closeMyDrawer();
                                return true;
                            }
                            return false;
                        }
                    }
            );

            setUpHamBurgerIcon();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "getStartedObjects:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void closeMyDrawer()
    {
        try
        {
            objectDrawerLayout.closeDrawer(GravityCompat.START);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "closeMyDrawer:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setUpHamBurgerIcon()
    {
        try
        {
            objectActionBarDrawerToggle=new ActionBarDrawerToggle(
                this,
                    objectDrawerLayout,objectToolbar,(R.string.open)
                    ,(R.string.close)
            );

            objectActionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(
                    R.color.colorPrimary
            ));

            objectActionBarDrawerToggle.syncState();


        }
        catch (Exception e)
            {
                Toast.makeText(this, "setUpHamBurgerIcon:"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
    }
}
