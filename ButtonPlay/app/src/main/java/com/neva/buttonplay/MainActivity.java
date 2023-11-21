package com.neva.buttonplay;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView t60,t1;
    TextView t2,t3,t4,t5,t6,t7,t8,t9,t10;
    TextView t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
    TextView t21,t22,t23,t24,t25,t26,t27,t28,t29, t30;
    TextView t31, t32,t33,t34,t35,t36,t37,t38,t39,t40;
    TextView t41, t42,t43,t44,t45,t46,t47,t48,t49,t50;
    TextView t51, t52,t53,t54,t55,t56,t57,t58,t59;

    TextView[] tvArr = new TextView[60];
    Animation rotateAnim;
    MediaPlayer player;

    ImageView dice;
    Random diceRoller;
    Button play, reset;
    int currentPos = 1, randomNumber = 0, maxPos = 60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiaze();
        TextView[] textViews = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,
                t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,
                t21,t22,t23,t24,t25,t26,t27,t28,t29, t30,t31,
                t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,
                t42,t43,t44,t45,t46,t47,t48,t49,t50,
                t51, t52,t53,t54,t55,t56,t57,t58,t59,t60};
        tvArr(textViews);

        dice = (ImageView) findViewById(R.id.diceImage);
        diceRoller = new Random();
        rotateAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        player = MediaPlayer.create(getApplicationContext(), R.raw.dicesound);

        play = (Button) findViewById(R.id.Play);
    }

    public void play(View view) {
        randomNumber = diceRoller.nextInt(6) + 1;
        rollDice(randomNumber);
    }
    public void reset(View view){
        currentPos = 1;
        player = MediaPlayer.create(getApplicationContext(), R.raw.dicesound);
        for(TextView textview : tvArr) {
            textview.setBackgroundColor(Color.WHITE);
        }
    }
    public void checkLoc(int randomNumber){
        currentPos += randomNumber;
        int lastPos = currentPos - randomNumber;

        if (currentPos > maxPos) {
            currentPos = 2 * maxPos - currentPos;
        }
        for(TextView textview : tvArr) {
            if (textview.getText().toString().equals(String.valueOf(currentPos))) {
                textview.setBackgroundColor(Color.BLUE);
            }else if(textview.getText().toString().equals(String.valueOf(lastPos))){
                textview.setBackgroundColor(Color.RED);
            }else if(currentPos == maxPos && textview.getText().equals("FINISH")){
                textview.setBackgroundColor(Color.GREEN);
                player = MediaPlayer.create(getApplicationContext(), R.raw.win);
                player.start();
            }
        }
    }
    public void rollDice(int randomNumber){
        int drawableId = getDrawableID(randomNumber);
        dice.startAnimation(rotateAnim);
        rotateAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                player.start();
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                dice.setImageResource(drawableId);
                checkLoc(randomNumber);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
    public int getDrawableID(int randomNumber) {
        switch(randomNumber){
            case 1:
                return R.drawable.diceface1;
            case 2:
                return R.drawable.diceface2;
            case 3:
                return R.drawable.diceface3;
            case 4:
                return R.drawable.diceface4;
            case 5:
                return R.drawable.diceface5;
            case 6:
                return R.drawable.diceface6;
            default:
                return R.drawable.diceface1;
        }
    }
    public void tvArr(TextView[] textViews){
        for(int i = 0; i < textViews.length; i++) {
            tvArr[i] = textViews[i];
        }
    }
    public void initiaze(){
        t1 = (TextView) findViewById(R.id.START);
        t2 = (TextView) findViewById(R.id.r12c2);
        t3 = (TextView) findViewById(R.id.r12c3);
        t4 = (TextView) findViewById(R.id.r12c4);
        t5 = (TextView) findViewById(R.id.r12c5);
        t6 = (TextView) findViewById(R.id.r11c5);
        t7 = (TextView) findViewById(R.id.r11c4);
        t8 = (TextView) findViewById(R.id.r11c3);
        t9 = (TextView) findViewById(R.id.r11c2);
        t10 = (TextView) findViewById(R.id.r11c1);
        t11 = (TextView) findViewById(R.id.r10c1);
        t12 = (TextView) findViewById(R.id.r10c2);
        t13 = (TextView) findViewById(R.id.r10c3);
        t14 = (TextView) findViewById(R.id.r10c4);
        t15 = (TextView) findViewById(R.id.r10c5);
        t16 = (TextView) findViewById(R.id.r9c5);
        t17 = (TextView) findViewById(R.id.r9c4);
        t18 = (TextView) findViewById(R.id.r9c3);
        t19 = (TextView) findViewById(R.id.r9c2);
        t20 = (TextView) findViewById(R.id.r9c1);
        t21 = (TextView) findViewById(R.id.r8c1);
        t22 = (TextView) findViewById(R.id.r8c2);
        t23 = (TextView) findViewById(R.id.r8c3);
        t24 = (TextView) findViewById(R.id.r8c4);
        t25 = (TextView) findViewById(R.id.r8c5);
        t26 = (TextView) findViewById(R.id.r7c5);
        t27 = (TextView) findViewById(R.id.r7c4);
        t28 = (TextView) findViewById(R.id.r7c3);
        t29 = (TextView) findViewById(R.id.r7c2);
        t30 = (TextView) findViewById(R.id.r7c1);
        t31 = (TextView) findViewById(R.id.r6c1);
        t32 = (TextView) findViewById(R.id.r6c2);
        t33 = (TextView) findViewById(R.id.r6c3);
        t34 = (TextView) findViewById(R.id.r6c4);
        t35 = (TextView) findViewById(R.id.r6c5);
        t36 = (TextView) findViewById(R.id.r5c5);
        t37 = (TextView) findViewById(R.id.r5c4);
        t38 = (TextView) findViewById(R.id.r5c3);
        t39 = (TextView) findViewById(R.id.r5c2);
        t40 = (TextView) findViewById(R.id.r5c1);
        t41 = (TextView) findViewById(R.id.r4c1);
        t42 = (TextView) findViewById(R.id.r4c2);
        t43 = (TextView) findViewById(R.id.r4c3);
        t44 = (TextView) findViewById(R.id.r4c4);
        t45 = (TextView) findViewById(R.id.r4c5);
        t46 = (TextView) findViewById(R.id.r3c5);
        t47 = (TextView) findViewById(R.id.r3c4);
        t48 = (TextView) findViewById(R.id.r3c3);
        t49 = (TextView) findViewById(R.id.r3c2);
        t50 = (TextView) findViewById(R.id.r3c1);
        t51 = (TextView) findViewById(R.id.r2c1);
        t52 = (TextView) findViewById(R.id.r2c2);
        t53 = (TextView) findViewById(R.id.r2c3);
        t54 = (TextView) findViewById(R.id.r2c4);
        t55 = (TextView) findViewById(R.id.r2c5);
        t56 = (TextView) findViewById(R.id.r1c5);
        t57 = (TextView) findViewById(R.id.r1c4);
        t58 = (TextView) findViewById(R.id.r1c3);
        t59 = (TextView) findViewById(R.id.r1c2);
        t60 = (TextView) findViewById(R.id.finish);
    }
}
