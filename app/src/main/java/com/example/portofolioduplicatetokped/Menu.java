package com.example.portofolioduplicatetokped;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.portofolioduplicatetokped.MenuMain.SectionPagerAdapter;
import com.example.portofolioduplicatetokped.MenuMain.fragmentAkun;
import com.example.portofolioduplicatetokped.MenuMain.fragmentFeed;
import com.example.portofolioduplicatetokped.MenuMain.fragmentHome;
import com.example.portofolioduplicatetokped.MenuMain.fragmentKeranjang;
import com.example.portofolioduplicatetokped.MenuMain.fragmentOfficial;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Menu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        loadFragment(new fragmentHome());// inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }
//    private void setupViewPager(ViewPager viewPager) {
//        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new fragmentHome(), "Home");
//        adapter.addFragment(new fragmentFeed(), "MANAGE");
//
//        viewPager.setAdapter(adapter);
//    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }   return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;   switch (item.getItemId()){
            case R.id.home_menu:
                fragment = new fragmentHome();
                break;
            case R.id.feed_menu:
                fragment = new fragmentFeed();
                break;
            case R.id.official_menu:
                fragment = new fragmentKeranjang();
                break;
            case R.id.keranjang_menu:
                fragment = new fragmentAkun();
                break;
            case R.id.account_menu:
                fragment = new fragmentOfficial();
                break;
        }   return loadFragment(fragment);
    }
}
