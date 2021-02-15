
package com.branding.middaymeal.ui.dashboard;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.branding.middaymeal.R;
import com.branding.middaymeal.pojo.DrawerItem;
import com.branding.middaymeal.ui.sidemenu.BlankFragment;
import com.branding.middaymeal.ui.sidemenu.NavRecyclerViewAdapter;
import com.branding.middaymeal.ui.sidemenu.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Dashboard extends AppCompatActivity implements IDashboardCallback {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView drawerRV;

    List<DrawerItem> drawerItemList;
    NavRecyclerViewAdapter navRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerRV = findViewById(R.id.drawerRV);
        drawerRV.setHasFixedSize(true);
        drawerItemList = new ArrayList<>();

        addDrawerItems();

        navRecyclerViewAdapter = new NavRecyclerViewAdapter(drawerItemList,this);
        drawerRV.setLayoutManager(new LinearLayoutManager(this));
        drawerRV.setAdapter(navRecyclerViewAdapter);


        drawer = findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

        };
        drawer.addDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

        selectItemInDrawer(drawerItemList.get(0),0);

    }

    private void addDrawerItems() {
        DrawerItem drawerItem = new DrawerItem();
        drawerItem.setDrawerMenuItem(R.drawable.ic_home_or_24dp);
        drawerItem.setMenuName("Home");
        drawerItem.setActive(true);
        drawerItemList.add(drawerItem);

        drawerItem = new DrawerItem();
        drawerItem.setDrawerMenuItem(R.drawable.ic_person_add_or_24dp);
        drawerItem.setMenuName("Add school ID");
        drawerItem.setActive(false);
        drawerItemList.add(drawerItem);

        drawerItem = new DrawerItem();
        drawerItem.setDrawerMenuItem(R.drawable.ic_account_box_or_24dp);
        drawerItem.setMenuName("My Account");
        drawerItem.setActive(false);
        drawerItemList.add(drawerItem);

        drawerItem = new DrawerItem();
        drawerItem.setDrawerMenuItem(R.drawable.ic_settings_or_24dp);
        drawerItem.setMenuName("Settings");
        drawerItem.setActive(false);
        drawerItemList.add(drawerItem);


        drawerItem = new DrawerItem();
        drawerItem.setDrawerMenuItem(R.drawable.ic_help_outline_or_24dp);
        drawerItem.setMenuName("Help");
        drawerItem.setActive(false);
        drawerItemList.add(drawerItem);

        drawerItem = new DrawerItem();
        drawerItem.setDrawerMenuItem(R.drawable.ic_feedback_or_24dp);
        drawerItem.setMenuName("Feedback");
        drawerItem.setActive(false);
        drawerItemList.add(drawerItem);
    }

    @Override
    public void selectItemInDrawer(DrawerItem drawerItem, int pos) {
        for(DrawerItem drawerItem1 : drawerItemList) {
            drawerItem1.setActive(false);
        }
        drawerItemList.get(pos).setActive(true);
        navRecyclerViewAdapter.notifyDataSetChanged();

        callRelevantFragment(drawerItem,pos);
    }

    private void callRelevantFragment(DrawerItem drawerItem, int pos) {
        Fragment f;
        switch (pos){
            case 0:
                f = new HomeFragment();
                break;
            default:
                f = new BlankFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout,f).commit();
        if(drawer.isDrawerOpen(Gravity.LEFT)) {
            drawer.closeDrawer(Gravity.LEFT);
        }

    }
}
