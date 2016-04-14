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
            //中央的logo图标
            logoImg = (ImageView) findViewById(R.id.logo_img);
            //下方的文字图片
            onePieceImg = (ImageView) findViewById(R.id.one_piece);
            //logo图标上移动画
            ObjectAnimator moveImg = ObjectAnimator.ofFloat(logoImg, "translationY", -90);
            moveImg.setDuration(1000);
            //设置延迟300毫秒开始动画
            moveImg.setStartDelay(300);
            moveImg.setInterpolator(new DecelerateInterpolator(1.2f));

            //logo图标的旋转动画完成后
            final ObjectAnimator changeImg = ObjectAnimator.ofFloat(logoImg, "rotationY", 180);
            changeImg.setDuration(1000);
            changeImg.setStartDelay(200);
            changeImg.setInterpolator(new DecelerateInterpolator(1.2f));
            //设置动画监听器
            changeImg.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    //旋转动画完成后，更换图片
                    logoImg.setImageResource(R.drawable.lufi);
                }
            });

            //文字图片下移动画
            ObjectAnimator onePieceAnimate = ObjectAnimator.ofFloat(onePieceImg, "translationY", 20);
            onePieceAnimate.setDuration(1000);
            onePieceAnimate.setStartDelay(800);
            onePieceAnimate.setInterpolator(new DecelerateInterpolator(1.2f));

            //文字图片x轴方向的缩放动画
            ObjectAnimator scaleXAnimate = ObjectAnimator.ofFloat(onePieceImg, "ScaleX", 1);
            scaleXAnimate.setDuration(1000);
            scaleXAnimate.setStartDelay(200);
            scaleXAnimate.setInterpolator(new DecelerateInterpolator(1.2f));

            //文字图片Y轴方向的缩放动画
            ObjectAnimator scaleYAnimate = ObjectAnimator.ofFloat(onePieceImg, "ScaleY", 1);
            scaleYAnimate.setDuration(1000);
            scaleYAnimate.setStartDelay(200);
            scaleYAnimate.setInterpolator(new DecelerateInterpolator(1.2f));

            //使用AnimatorSet 播放多个动画
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(moveImg, changeImg);
            animatorSet.playTogether(onePieceAnimate, scaleXAnimate, scaleYAnimate);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //动画完成后的跳转Activity
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }
                    }, 500);
                }
            });
            animatorSet.start();
        }
    }