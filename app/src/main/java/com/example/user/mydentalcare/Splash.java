package com.example.user.mydentalcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private TextView tv_splash;
    private ImageView iv_splash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv_splash = (TextView)findViewById(R.id.tv_splash);
        iv_splash = (ImageView) findViewById(R.id.iv_splash);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        tv_splash.startAnimation(myanim);
        iv_splash.startAnimation(myanim);

        final Intent i = new Intent(this, MainActivity.class);

        Thread timer = new Thread(){
            public void run () {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
