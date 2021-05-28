package com.example.kiemtra2_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewpager ;
    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Trần Tiến Dũng - B17DCCN165 -E17CN2",Toast.LENGTH_SHORT).show();
        viewpager = findViewById(R.id.vp);
        bnv = findViewById(R.id.nav);
        MainAdapter ma = new MainAdapter(getSupportFragmentManager(),3);
        viewpager.setAdapter(ma);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:{
                        bnv.getMenu().findItem(R.id.cafe1).setChecked(true);
                        break;
                    }
                    case 1:{
                        bnv.getMenu().findItem(R.id.cafe2).setChecked(true);
                        break;
                    }
                    case 2:{
                        bnv.getMenu().findItem(R.id.cafe3).setChecked(true);
                        break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.cafe1:
                    {
                        viewpager.setCurrentItem(0);
                        break;
                    }
                    case R.id.cafe2:
                    {
                        viewpager.setCurrentItem(1);
                        break;
                    }
                    case R.id.cafe3:
                    {
                        viewpager.setCurrentItem(2);
                    }
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item = menu.findItem(R.id.infor);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.e("ss","ss");
                Toast.makeText(MainActivity.this,"Trần Tiến Dũng - B17DCCN165 -E17CN2",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        MenuItem item2 = menu.findItem(R.id.Exit);
        item2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                System.exit(0);
                return false;
            }
        });
        MenuItem item3 = menu.findItem(R.id.switchfragment);
        item3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                viewpager.setCurrentItem(1);
                bnv.getMenu().findItem(R.id.cafe2).setChecked(true);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}