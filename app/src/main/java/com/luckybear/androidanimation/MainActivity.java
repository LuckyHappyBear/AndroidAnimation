package com.luckybear.androidanimation;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.iv_demo);
        Button valueAnimBtn = (Button) findViewById(R.id.btn_value_alpha);
        Button objectAnimBtn = (Button) findViewById(R.id.btn_object_alpha);

        basicIntValueAnimator(0, 1000, 1000, new AccelerateInterpolator());

        basicFloatValueAnimator(0f, 1f, 1000, new LinearInterpolator());

        valueAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaChangeValueAnim(imageView, 1f, 0f, 1000, new LinearInterpolator());
            }
        });

        objectAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaChangeObjectAnim(imageView, 1f, 0f, 1000, new LinearInterpolator());
            }
        });
    }

    public static void basicIntValueAnimator(int start, int end, int duration,
                                             TimeInterpolator timeInterpolator) {
        ValueAnimator anim = ValueAnimator.ofInt(start, end);
        anim.setDuration(duration);
        anim.setInterpolator(timeInterpolator);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                android.util.Log.d("TAG", "current int value is " + (int) animation.getAnimatedValue());
            }
        });
        anim.start();
    }

    public static void basicFloatValueAnimator(float start, float end, int duration,
                                               TimeInterpolator timeInterpolator) {
        ValueAnimator anim = ValueAnimator.ofFloat(start, end);
        anim.setDuration(duration);
        anim.setInterpolator(timeInterpolator);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                android.util.Log.d("TAG", "current float value is " + (float) animation.getAnimatedValue());
            }
        });
        anim.start();
    }

    public static void alphaChangeValueAnim(final View view, float alphaFrom, float alphaTo,
                                            int duration, TimeInterpolator timeInterpolator) {
        ValueAnimator anim = ValueAnimator.ofFloat(alphaFrom, alphaTo);
        anim.setDuration(duration);
        anim.setInterpolator(timeInterpolator);
        if (view != null) {
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    view.setAlpha((float)animation.getAnimatedValue());
                }
            });
        }
        anim.start();
    }

    public static void alphaChangeObjectAnim(final View view, float alphaFrom, float alphaTo,
                                             int duration, TimeInterpolator timeInterpolator) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", alphaFrom, alphaTo);
        anim.setDuration(duration);
        anim.setInterpolator(timeInterpolator);
        anim.start();
    }
}
