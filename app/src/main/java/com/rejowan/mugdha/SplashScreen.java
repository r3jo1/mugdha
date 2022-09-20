package com.rejowan.mugdha;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.rejowan.mugdha.databinding.ActivitySplashScreenBinding;

import java.util.concurrent.Executors;


@SuppressLint("CustomSplashScreen")
@SuppressWarnings("BusyWait")
public class SplashScreen extends AppCompatActivity {

    ActivitySplashScreenBinding binding;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        new Thread(() -> {
            for (i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(10);
                    binding.progressBar2.setProgress(i);


                    if (i == 100) {
                        Intent intent = new Intent(SplashScreen.this, PasswordChecker.class);
                        startActivity(intent);
                        finish();
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();


//        Executors.newSingleThreadExecutor().execute(() -> {
//            for (i = 0; i <= 100; i++) {
//                try {
//                    Thread.sleep(10);
//                    binding.progressBar2.setProgress(i);
//
//                    runOnUiThread(() -> {
//                        if (i == 100) {
//                            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                    });
//
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });


    }
}