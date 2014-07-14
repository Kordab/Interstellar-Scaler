package com.example.michiel.weegschaal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Weegschaal extends FragmentActivity {
    ViewPager viewPager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weegschaal);
        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }

    public void calcWeight(View v) {
        //get weight
        final EditText editText1 = (EditText) findViewById(R.id.userWeigth);
        String myString = editText1.getText().toString();
        double userWeightEarth = Double.parseDouble(myString), userWeight = userWeightEarth / 9.81;

        //get acceleration values
        double moonAcceleration = 1.62, sunAcceleration = 274;

        //calc
        double moonValue = userWeight * moonAcceleration;
        double sunValue = userWeight * sunAcceleration;

        //show values
            DecimalFormat df = new DecimalFormat("#.00");
        TextView moonWeight = (TextView) findViewById(R.id.titleMoon);
        moonWeight.setText(df.format(moonValue));
        TextView sunWeight = (TextView) findViewById(R.id.titleSun);
        //sunWeight.setText(df.format(sunValue));
    }
}

class MyAdapter extends FragmentStatePagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragments=null;
        if(i==0){
            fragments = new FragmentEarth();
        } else if(i==1) {
            fragments = new FragmentMoon();
        } else if(i==2) {
            fragments = new FragmentSun();
        } else if(i==3) {
            fragments = new FragmentMercury();
        } else if(i==4) {
            fragments = new FragmentVenus();
        } else if(i==5) {
            fragments = new FragmentMars();
        } else if(i==6) {
            fragments = new FragmentJupiter();
        } else if(i==7) {
            fragments = new FragmentSaturn();
        } else if(i==8) {
            fragments = new FragmentUranus();
        } else if(i==9) {
            fragments = new FragmentNeptune();
        } else {
            return null;
        }
        return fragments;
    }

    @Override
    public int getCount() {
        return 9; //Amount of pages
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0) {
            return "Earth";
        } else if(position==1) {
            return "Moon";
        } else if(position==2) {
            return "Sun";
        } else if(position==3) {
            return "Mercury";
        } else if(position==4) {
            return "Venus";
        } else if(position==5) {
            return "Mars";
        } else if(position==6) {
            return "Jupiter";
        } else if(position==7) {
            return "Saturn";
        } else if(position==8) {
            return "Uranus";
        } else if(position==9) {
            return "Neptune";
        }

        return null;
    }
}
