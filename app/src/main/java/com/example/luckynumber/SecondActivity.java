package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView score;
    Button shareLuckyNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        score = findViewById(R.id.textView3);
        shareLuckyNumber = findViewById(R.id.button2);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        int luckyNumber = generateRandomNumber();
        score.setText(""+luckyNumber);
        shareLuckyNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(name, luckyNumber);

            }
        });


    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upperLimit = 1000;
        int randomNumber = random.nextInt(upperLimit);
        return randomNumber;
    }

    public void shareData(String name, int number){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, name + " got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is: "+number);
        startActivity(Intent.createChooser(intent, "Choose a platform"));
    }
}