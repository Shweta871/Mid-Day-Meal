
/*

 */

package com.branding.middaymeal.ui.login;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.branding.middaymeal.R;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class Login2Activity extends AppCompatActivity {

    TextView loginTxt;
    TextView signupTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        loginTxt = findViewById(R.id.loginTxt);
        signupTxt = findViewById(R.id.signupTxt);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    loginTxt.setBackground(ContextCompat.getDrawable(Login2Activity.this,R.drawable.tab_bg_active));
                    loginTxt.setTextColor(Color.WHITE);
                    signupTxt.setBackground(ContextCompat.getDrawable(Login2Activity.this,R.drawable.tab_bg_inactive));
                    signupTxt.setTextColor(Color.BLACK);

                } else if(position == 1) {
                    signupTxt.setBackground(ContextCompat.getDrawable(Login2Activity.this,R.drawable.tab_bg_active));
                    signupTxt.setTextColor(Color.WHITE);
                    loginTxt.setBackground(ContextCompat.getDrawable(Login2Activity.this,R.drawable.tab_bg_inactive));
                    loginTxt.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}