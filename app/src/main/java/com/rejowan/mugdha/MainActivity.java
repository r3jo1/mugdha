package com.rejowan.mugdha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.rejowan.mugdha.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.passwordButton.setOnClickListener(v -> startActivity(new Intent(this,PasswordChecker.class)));

    }




}