package com.rejowan.mugdha;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.rejowan.mugdha.databinding.ActivityPasswordCheckerBinding;

import java.lang.reflect.Array;

public class PasswordChecker extends AppCompatActivity {

    ActivityPasswordCheckerBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPasswordCheckerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setInvisible();

        Log.e("TAG", "onCreate: " + binding.passwordField.getInputType() );


        binding.visibilityButton.setOnClickListener(v -> {

            if (binding.passwordField.getInputType()== InputType.TYPE_TEXT_VARIATION_PASSWORD + InputType.TYPE_CLASS_TEXT){
                binding.passwordField.setInputType(InputType.TYPE_CLASS_TEXT);
                binding.visibilityButton.setImageResource(R.drawable.ic_visibility_on);
            } else {
                binding.passwordField.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD + InputType.TYPE_CLASS_TEXT);
                binding.visibilityButton.setImageResource(R.drawable.ic_visibility_off);
            }
            binding.passwordField.setSelection(binding.passwordField.getText().length());


        });


        binding.visibilityButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        binding.passwordField.setInputType(InputType.TYPE_CLASS_TEXT);
                        binding.visibilityButton.setImageResource(R.drawable.ic_visibility_on);
                        binding.passwordField.setSelection(binding.passwordField.getText().length());
                        break;
                    case MotionEvent.ACTION_UP:
                        binding.passwordField.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD + InputType.TYPE_CLASS_TEXT);
                        binding.visibilityButton.setImageResource(R.drawable.ic_visibility_off);
                        binding.passwordField.setSelection(binding.passwordField.getText().length());
                        break;
                }
                return true;
            }
        });





        binding.passwordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                String text = binding.passwordField.getText().toString();

                if (text.length() == 0) {
                    setInvisible();
                } else if (text.length() < 8) {
                    setVisible();

                    binding.errorPassShort.setTextColor(Color.RED);

                    if (!isUpperCase(text)) {
                       binding.errorPassUppercase.setTextColor(Color.RED);
                    } else {
                        binding.errorPassUppercase.setTextColor(getResources().getColor(R.color.green));
                    }
                    if (!isLowerCase(text)) {
                        binding.errorPassLowercase.setTextColor(Color.RED);
                    } else {
                        binding.errorPassLowercase.setTextColor(getResources().getColor(R.color.green));
                    }
                    if (!isDigit(text)) {
                        binding.errorPassDigit.setTextColor(Color.RED);
                    } else {
                        binding.errorPassDigit.setTextColor(getResources().getColor(R.color.green));
                    }
                    if (!isLetterOrDigit(text)) {
                        binding.errorPassSpecial.setTextColor(Color.RED);
                    } else {
                        binding.errorPassSpecial.setTextColor(getResources().getColor(R.color.green));
                    }

                    badPassword();


                } else {

                    setVisible();

                    binding.errorPassShort.setTextColor(getResources().getColor(R.color.green));

                    if (!isUpperCase(text)) {
                        binding.errorPassUppercase.setTextColor(Color.RED);
                    } else {
                        binding.errorPassUppercase.setTextColor(getResources().getColor(R.color.green));
                    }
                    if (!isLowerCase(text)) {
                        binding.errorPassLowercase.setTextColor(Color.RED);
                    } else {
                        binding.errorPassLowercase.setTextColor(getResources().getColor(R.color.green));
                    }
                    if (!isDigit(text)) {
                        binding.errorPassDigit.setTextColor(Color.RED);
                    } else {
                        binding.errorPassDigit.setTextColor(getResources().getColor(R.color.green));
                    }
                    if (!isLetterOrDigit(text)) {
                        binding.errorPassSpecial.setTextColor(Color.RED);
                    } else {
                        binding.errorPassSpecial.setTextColor(getResources().getColor(R.color.green));
                    }

                    if (!isUpperCase(text) || !isLowerCase(text) || !isDigit(text) || !isLetterOrDigit(text)) {
                        badPassword();
                    }

                    if (isUpperCase(text) && isLowerCase(text) && isDigit(text) && isLetterOrDigit(text)) {
                       goodPassword();
                    }


                }


            }
        });

    }

    private void setInvisible() {
        binding.resultLayout.setVisibility(View.INVISIBLE);
        binding.emojiLayout.setVisibility(View.INVISIBLE);
    }

    private void setVisible() {
        binding.resultLayout.setVisibility(View.VISIBLE);
        binding.emojiLayout.setVisibility(View.VISIBLE);
    }

    private void goodPassword() {
        binding.emojiImage.setImageResource(R.drawable.party);
        binding.emojiText.setText("Good Password");
    }

    private void badPassword() {
        binding.emojiImage.setImageResource(R.drawable.sad);
        binding.emojiText.setText("Not a Good Password");
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