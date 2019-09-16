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
    Button btnPoint, btnClear, btnPlus, btnMinus, btnMultiply, btnDivide, btnEquals;

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

        btnPoint = findViewById(R.id.btn_Point);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnClear = findViewById(R.id.btn_clear);
        btnEquals = findViewById(R.id.btn_Equals);

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

        btnPoint.setOnClickListener(listener);
        btnPlus.setOnClickListener(listener);
        btnMinus.setOnClickListener(listener);
        btnMultiply.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);
        btnClear.setOnClickListener(listener);
        btnEquals.setOnClickListener(listener);

    }
}
