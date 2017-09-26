package com.luckybear.androidanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.iv_frame);
        AnimationDrawable animationDrawable = (AnimationDrawable) getDrawable(R.drawable.frame_list);
        imageView.setBackground(animationDrawable);
        animationDrawable.start();
    }
}
