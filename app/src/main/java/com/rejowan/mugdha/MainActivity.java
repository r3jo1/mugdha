package com.rejowan.mugdha;

import androidx.appcompat.app.AppCompatActivity;

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


        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                String text = binding.editText.getText().toString();

                if (text.length() == 0) {
                    binding.text.setText("Enter A Password");
                } else if (text.length() < 8) {
                    binding.text.setText("Password is too short");
                } else {

                    if (!isUpperCase(text)){
                        binding.text.setText("Password must contain at least one uppercase letter");
                    } else if (!isLowerCase(text)){
                        binding.text.setText("Password must contain at least one lowercase letter");
                    } else if (!isDigit(text)){
                        binding.text.setText("Password must contain at least one digit");
                    } else if (!isLetterOrDigit(text)){
                        binding.text.setText("Password must contain at least one special character");
                    } else {
                        binding.text.setText("Password is valid");
                    }

                }


            }


        });

    }


    private boolean isUpperCase(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isLowerCase(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLowerCase(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isLetterOrDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetterOrDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }


}