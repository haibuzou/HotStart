package haibuzou.hotstart;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;


public class SplashActivity extends Activity {

    Handler handler;
    ImageView logoImg;
    ImageView onePieceImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_Splash);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            animate();
        }


        super.onWindowFocusChanged(hasFocus);
    }

    public void animate() {
        logoImg = (ImageView) findViewById(R.id.logo_img);
        onePieceImg = (ImageView) findViewById(R.id.one_piece);
        ObjectAnimator moveImg = ObjectAnimator.ofFloat(logoImg, "translationY", -250);
        moveImg.setDuration(1000);
        moveImg.setStartDelay(300);
        moveImg.setInterpolator(new DecelerateInterpolator(1.2f));

        final ObjectAnimator changeImg = ObjectAnimator.ofFloat(logoImg, "rotationY", 180);
        changeImg.setDuration(1000);
        changeImg.setStartDelay(200);
        changeImg.setInterpolator(new DecelerateInterpolator(1.2f));
        changeImg.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                logoImg.setImageResource(R.drawable.lufi);
            }
        });

        ObjectAnimator onePieceAnimate = ObjectAnimator.ofFloat(onePieceImg, "translationY", 80);
        onePieceAnimate.setDuration(1000);
        onePieceAnimate.setStartDelay(200);
        onePieceAnimate.setInterpolator(new DecelerateInterpolator(1.2f));

        ObjectAnimator scaleXAnimate = ObjectAnimator.ofFloat(onePieceImg, "ScaleX", 1);
        onePieceAnimate.setDuration(1000);
        onePieceAnimate.setStartDelay(200);
        onePieceAnimate.setInterpolator(new DecelerateInterpolator(1.2f));

        ObjectAnimator scaleYAnimate = ObjectAnimator.ofFloat(onePieceImg, "ScaleY", 1);
        onePieceAnimate.setDuration(1000);
        onePieceAnimate.setInterpolator(new DecelerateInterpolator(1.2f));

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(moveImg).after(changeImg).after(onePieceAnimate).after(scaleXAnimate).with(scaleYAnimate);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                }, 500);
            }
        });
        animatorSet.start();
    }


}
