package com.luckybear.androidanimation;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValueAnimator anim = ValueAnimator.ofInt(0, 300);
        anim.setDuration(300);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                android.util.Log.d("TAG", "current value is " + currentValue);
            }
        });
        anim.start();
    }
}
