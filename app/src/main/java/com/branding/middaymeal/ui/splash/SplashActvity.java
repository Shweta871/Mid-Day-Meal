/*

 */

/*
 *
 */

package com.branding.middaymeal.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.branding.middaymeal.R;
import com.branding.middaymeal.ui.login.Login2Activity;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actvity);

        final TextView textView = findViewById(R.id.text_home);
        final ImageView imageView = findViewById(R.id.imageView);
        final ImageView bottomImageView = findViewById(R.id.bottomImage);
        bottomImageView.setVisibility(View.INVISIBLE);
        final TextView poweredByTV = findViewById(R.id.poweredBy);
        poweredByTV.setVisibility(View.INVISIBLE);

        Animation scaleUp = AnimationUtils.loadAnimation(SplashActvity.this, R.anim.scale_up);
        imageView.startAnimation(scaleUp);

        scaleUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Animation slideFromLeft = AnimationUtils.loadAnimation(SplashActvity.this,R.anim.slide_from_left);
                bottomImageView.setVisibility(View.VISIBLE);
                bottomImageView.startAnimation(slideFromLeft);


                slideFromLeft.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Animation fadeIn = AnimationUtils.loadAnimation(SplashActvity.this,R.anim.fade_in);
                        poweredByTV.setVisibility(View.VISIBLE);
                        poweredByTV.startAnimation(fadeIn);

                        poweredByTV.postDelayed(() -> {
                            Intent i = new Intent(SplashActvity.this, Login2Activity.class);
                            startActivity(i);
                            overridePendingTransition(R.anim.slide_from_right,R.anim.hold);
                            finish();
                        },10);


                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });



            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
