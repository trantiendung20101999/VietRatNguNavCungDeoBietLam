package com.example.kiemtra2_demo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainAdapter extends FragmentStatePagerAdapter {
    private int pagenum;
    public MainAdapter(@NonNull FragmentManager fm,int behavior) {
        super(fm);
        this.pagenum=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new CafeFragment1();
            case 1: return new CafeFragment2();
            case 2: return new CafeFragment3();
            default: return new CafeFragment1();
        }
    }

    @Override
    public int getCount() {
        return pagenum;
    }
}
