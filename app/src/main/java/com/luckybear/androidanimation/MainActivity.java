package com.luckybear.androidanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "HX_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.tv_animation);
        // 注释代码段是使用xml方式实现的动画，与之后代码实现的效果相同
        /*Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_animtation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i(TAG, "animation start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i(TAG, "animation end");
                textView.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i(TAG, "animation repeat");
            }
        });
        textView.startAnimation(animation);*/

        //参数为false，不共享Interpolator
        AnimationSet set = new AnimationSet(false);
        set.setDuration(1500);
        set.setFillAfter(true);

        // Scale动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 2f, 1.0f, 2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        set.addAnimation(scaleAnimation);

        // secondSet集合
        AnimationSet secondSet = new AnimationSet(true);
        secondSet.setInterpolator(new AccelerateInterpolator());
        secondSet.setDuration(2000);
        secondSet.setStartOffset(1500);

        // Scale动画
        ScaleAnimation secondScaleAnimation = new ScaleAnimation(2f, 1f, 2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        secondSet.addAnimation(secondScaleAnimation);

        // Rotate动画
        RotateAnimation secondRotateAnimation = new RotateAnimation(0.0f, -45.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        secondSet.addAnimation(secondRotateAnimation);

        set.addAnimation(secondSet);

        AnimationSet thirdSet = new AnimationSet(true);
        thirdSet.setDuration(2500);
        thirdSet.setInterpolator(new LinearInterpolator());
        thirdSet.setStartOffset(3500);

        AlphaAnimation thirdAlphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        thirdSet.addAnimation(thirdAlphaAnimation);

        TranslateAnimation thirdTranslateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_PARENT, 0.92f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_PARENT, 0.92f);
        thirdSet.addAnimation(thirdTranslateAnimation);

        set.addAnimation(thirdSet);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i(TAG, "animation start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i(TAG, "animation end");
                textView.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i(TAG, "animation repeat");
            }
        });

        textView.startAnimation(set);
    }
}
