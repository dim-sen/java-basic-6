package com.dimsen.highlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int randomNumber, guessInt;
    private EditText editNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber = findViewById(R.id.edtNumber);
        Button btnGuess = findViewById(R.id.btnGuess);

        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;

        btnGuess.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        guessInt = Integer.parseInt(editNumber.getText().toString());
        if (guessInt > randomNumber) {
            toast("Lower!");
        } else if (guessInt < randomNumber) {
            toast("Higher!");
        } else {
            toast("You are right!");
            Random random = new Random();
            randomNumber = random.nextInt(20) + 1;
        }
    }

    public void toast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}