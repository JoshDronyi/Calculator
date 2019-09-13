package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    //Variables for the calculator

    TextView display;
    Button btnZero, btnOne, btnTwo, btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine;
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button buttonInstance = (Button) view;
            Toast.makeText(CalculatorActivity.this, buttonInstance.getText() , Toast.LENGTH_SHORT).show();
        }
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        //Button Instantiation
        btnZero = findViewById(R.id.btn_0);
        btnOne = findViewById(R.id.btn_1);
        btnTwo = findViewById(R.id.btn_2);
        btnThree = findViewById(R.id.btn_3);
        btnFour = findViewById(R.id.btn_4);
        btnFive = findViewById(R.id.btn_5);
        btnSix = findViewById(R.id.btn_6);
        btnSeven = findViewById(R.id.btn_7);
        btnEight = findViewById(R.id.btn_8);
        btnNine = findViewById(R.id.btn_9);

        //Event Handler attached
        btnZero.setOnClickListener(listener);
        btnOne.setOnClickListener(listener);
        btnTwo.setOnClickListener(listener);
        btnThree.setOnClickListener(listener);
        btnFour.setOnClickListener(listener);
        btnFive.setOnClickListener(listener);
        btnSix.setOnClickListener(listener);
        btnSeven.setOnClickListener(listener);
        btnEight.setOnClickListener(listener);
        btnNine.setOnClickListener(listener);
    }
}
