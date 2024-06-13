package com.demoapp.rockpaperscissor;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rlHome, rlGame;

    LinearLayout layoutButton;

    MaterialButton btnStartGame;


    ImageView ivRock, ivPaper, ivScissor;

    ImageView ivRestartGame, ivHome;

    TextView tvOutput;
    ImageView ivOutput;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStartGame = findViewById(R.id.btnStartGame);
        rlGame = findViewById(R.id.layoutGame);
        rlHome = findViewById(R.id.layoutHome);
        tvOutput = findViewById(R.id.tvOutput);
        ivOutput = findViewById(R.id.ivOutput);

        ivRock = findViewById(R.id.ivRock);
        ivPaper = findViewById(R.id.ivPaper);
        ivScissor = findViewById(R.id.ivScissor);

        ivRestartGame = findViewById(R.id.ivRestart);
        ivHome = findViewById(R.id.ivHome);

        rlGame.setVisibility(View.GONE);
        rlHome.setVisibility(View.VISIBLE);

        layoutButton = findViewById(R.id.layoutButton);

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlHome.setVisibility(View.GONE);
                rlGame.setVisibility(View.VISIBLE);

                startTimer();
            }
        });



        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlHome.setVisibility(View.VISIBLE);
                rlGame.setVisibility(View.GONE);
                resetGame();
            }
        });

        ivRestartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
                startTimer();
            }
        });


    }


    void resetGame(){

        counter = 3;
        ivOutput.setVisibility(View.GONE);
        layoutButton.setVisibility(View.GONE);
    }
    void startTimer() {
        resetGame();


        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvOutput.setText(String.valueOf(counter));
                counter--;
            }

            @Override
            public void onFinish() {
                startPlaying();
            }
        }.start();
    }

    void startPlaying() {
        ivOutput.setVisibility(View.VISIBLE);
        layoutButton.setVisibility(View.VISIBLE);

        Random random = new Random();
        int randomNumber = random.nextInt(3);

        if (randomNumber == 0) {
            ivOutput.setImageResource(R.drawable.ic_rock);
            tvOutput.setText("Rock");
        }
        if (randomNumber == 1) {
            ivOutput.setImageResource(R.drawable.ic_paper);
            tvOutput.setText("Paper");
        }
        if (randomNumber == 2) {
            ivOutput.setImageResource(R.drawable.ic_scissor);
            tvOutput.setText("Scissor");
        }

    }


}