package com.example.test.animations;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.animview);
    }

    public void startAnimation(View view){
        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "TextScaleX", 0, 4);
        anim.setDuration(1000);
        anim.start();
    }
    public void colorAnimation(View view){
        ObjectAnimator anim = ObjectAnimator.ofArgb(textView, "TextColor", Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN);
        anim.setDuration(5000);

        ObjectAnimator animBgr = ObjectAnimator.ofArgb(textView, "BackgroundColor",  Color.CYAN, Color.GREEN, Color.MAGENTA, Color.BLUE);
        animBgr.setDuration(5000);

        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim).with(animBgr);
        animSet.start();
    }
    public void shadowAnimation(View view){
        ObjectAnimator elevationAnim = ObjectAnimator.ofFloat(textView, "Elevation", 0, 20);
        elevationAnim.setDuration(4000);
        elevationAnim.start();
    }
    public void slideAnimation(View view){
        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "ScaleX", 0, 1);
        anim.setDuration(2000);
        anim.start();
    }
    public void rotateAnimation(View view){
        RotateAnimation rotateAnimation = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setDuration(3000);

        textView.startAnimation(rotateAnimation);
    }
    public void fadeAnimation(View view){
        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "Alpha", 0, 1);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.setDuration(700);
        anim.start();
    }
    public void moveAnimation(View view){
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,.85f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0.65f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(1200);

        textView.startAnimation(translateAnimation);
    }
    public void zoomAnimation(View view){
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f,4f,1f,4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(1800);

        textView.startAnimation(scaleAnimation);
    }
    public void bounceAnimation(View view){
        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "ScaleY", 0, 1);
        anim.setInterpolator(new BounceInterpolator());
        anim.setDuration(2000);
        anim.start();
    }
}


// TODO: 17.04.17
/*
    Color Animation
    Animating text color can be done using ObjectAnimator’s ofArgb() method. You need to pass list
    of colors to be animated through in addition to object and property. In the same way, view’s
    back ground can be animated. Below code snippet shows how to animate text color and back ground
    color together using AnimatorSet.

        ObjectAnimator anim = ObjectAnimator.ofArgb(textView, "TextColor", Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN);
        anim.setDuration(5000);

        ObjectAnimator animBgr = ObjectAnimator.ofArgb(textView, "BackgroundColor",  Color.CYAN, Color.GREEN, Color.MAGENTA, Color.BLUE);
        animBgr.setDuration(5000);

        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim).with(animBgr);
        animSet.start();



    Shadow Animation
    Shadow animation can be achieved by animating elevation property of target view.

        ObjectAnimator elevationAnim = ObjectAnimator.ofFloat(textView, "Elevation", 0, 20);
        elevationAnim.setDuration(4000);
        elevationAnim.start();


    Slide Down
    Slide down animation can be achieved by animating ScaleY from value 0 to 1.

        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "ScaleY", 0, 1);
        anim.setDuration(4000);
        anim.start();

    Slide Up
    Slide up animation can be achieved by animating ScaleY from value 1 to 0.

        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "ScaleY", 1, 0);
        anim.setDuration(2000);
        anim.start();

    Slide In
    Slide in animation can be achieved by animating ScaleX from value 1 to 0.

        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "ScaleX", 1, 0);
        anim.setDuration(2000);
        anim.start();

    Slide Out
    Slide Out animation can be achieved by animating ScaleX from value 0 to 1.

        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "ScaleX", 0, 1);
        anim.setDuration(2000);
        anim.start();

    Rotate Animation
    Rotate animation can be achieved using RotateAnimation class. RotateAnimation’s constructor
    takes from degree, to degree, x axis and y axis for rotation of target object.
    You can specify x axis and y axis type also. Axis type RELATIVE_TO_SELF allows you to specify
    coordinate values as percentage of width and height of target object, setting the both axis
    values 0.5 makes target object rotate at center point.To use RotateAnimation, you need to set
    interpolator and set it to target object by calling startAnimation() method.

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(3000);

        textView.startAnimation(rotateAnimation);


    Rotate Anti Clockwise
    To rotate object anti clockwise, you need to set from degree as 360 and to degree as 0.

        RotateAnimation rotateAnimation = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new AccelerateInterpolator());
        rotateAnimation.setDuration(3000);

        textView.startAnimation(rotateAnimation);


    Fade In Animation
    Fade animation can be achieved by animating alpha property.

        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "Alpha", 0, 1);
        anim.setDuration(5000);
        anim.start();

    Fade Out Animation
    Fade out animation can be created by animating alpha property from 1 to 0.

        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "Alpha", 1, 0);
        anim.setDuration(5000);
        anim.start();

    Blink Animation
    Using alpha property you can create blink animation by setting the duration to few
    milliseconds and repeating the animation.

        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "Alpha", 0, 1);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.setDuration(700);
        anim.start();

    Move Animation
    Position of an object can be animated using TranslateAnimation. TranslateAnimation’s constructor
    takes delta x and delta y values.

        TranslateAnimation translateAnimation = new TranslateAnimation (Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,.85f,
        Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0.65f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(1200);

        textView.startAnimation(translateAnimation);

    Zoom Out Animation
    Zoom animation can be created by using scaleAnimation class. scaleAnimation’s constructor takes
    from and to scale x and scale y values and pivot x and y values. By setting pivot x and pivot y
    to center of object and changing scalex and scaley from high values to low values, zoom out
    animation of target object can be achieved.

        ScaleAnimation scaleAnimation = new ScaleAnimation(1f,0.5f,1f,.50f,
        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setDuration(1800);

        textView.startAnimation(scaleAnimation);

    Zoom In Animation
    By setting pivot x and pivot y to center of object and changing scalex and scaley from low
    values to high values, zoom in animation of target object can be achieved.

        ScaleAnimation scaleAnimation = new ScaleAnimation(1f,4f,1f,4f,
        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(1800);

        textView.startAnimation(scaleAnimation);

    Bounce Animation
        ObjectAnimator anim = ObjectAnimator.ofFloat(textView, "ScaleY", 0, 1);
        anim.setInterpolator(new BounceInterpolator());
        anim.setDuration(1000);
        anim.start();

    it's all from http://www.zoftino.com/view-animation-effects-in-android
    and see other part http://www.zoftino.com/how-to-create-animations-in-android

*/