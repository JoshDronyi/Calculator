package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorActivity extends AppCompatActivity {

    //Variables for the calculator

    @BindView(R.id.screen)
    TextView screen;


    Double firstNumber = null, secondNumber = null;
    Operations operationType;

    public enum Operations {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

    public final static String DEFAULT_SCREEN_VALUE = "0";
    public final static String ADDITION_SIGN = "+";
    public final static String SUBTRACTION_SIGN = "-";
    public final static String MULTIPLICATION_SIGN = "x";
    public final static String DIVISION_SIGN = "/";
    public final static String CLEAR = "C";
    public final static String EQUALS = "=";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_Point})
    public void numberWasClicked(Button button) {
        Button buttonInstance = button;
        String newText = null;

        screen = findViewById(R.id.screen);

        String screenText = screen.getText().toString();
        String buttonText = buttonInstance.getText().toString();

        if (screenText.startsWith(DEFAULT_SCREEN_VALUE)) {
            newText = buttonInstance.getText().toString();
            screen.setText(newText);
        } else {
            Log.i("Adding", "ADDING NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);
            newText = screenText + buttonInstance.getText();
            screen.setText(newText);
        }


    }

    @OnClick(R.id.btn_plus)
    public void Add() {
        operationType = Operations.ADDITION;

        String screenText = screen.getText().toString();

        Log.i("Adding", "ADDING NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

        String newText = screenText + ADDITION_SIGN;
        screen.setText(newText);
//                        Add(screenText); Function to ensure one can use multiple operations

    }

    @OnClick(R.id.btn_minus)
    public void Subtract() {
        operationType = Operations.SUBTRACTION;
        String screenText = screen.getText().toString();
        Log.i("Adding", "Subtacting NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

        String newText = screenText + SUBTRACTION_SIGN;
        screen.setText(newText);
//                        Subtract(screenText); Function to ensure one can use multiple operations

    }

    @OnClick(R.id.btn_multiply)
    public void Multiply() {
        operationType = Operations.MULTIPLICATION;

        String screenText = screen.getText().toString();

        Log.i("Adding", "Multiplying NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

        String newText = screenText + MULTIPLICATION_SIGN;
        screen.setText(newText);
//                        Multiply(screenText); Function to ensure one can use multiple operations
    }

    @OnClick(R.id.btn_divide)
    public void Divide() {
        operationType = Operations.DIVISION;

        String screenText = screen.getText().toString();

        Log.i("Adding", "Dividing NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

        String newText = screenText + DIVISION_SIGN;
        screen.setText(newText);

//                        Divide(screenText); Function to ensure one can use multiple operations
    }

    @OnClick(R.id.btn_clear)
    public void Clear() {
        screen.setText(DEFAULT_SCREEN_VALUE);
        firstNumber = null;
        secondNumber = null;
    }

    @OnClick(R.id.btn_equals)
    public void Equals() {

        String equation = screen.getText().toString();

        Log.i("We doin MATH!!", "The Value of the equation variable is " + equation);

        int operationIndex;

        switch (operationType) {
            case ADDITION:

                operationIndex = equation.indexOf(ADDITION_SIGN);
                String firstNumberString = equation.substring(0, operationIndex ), secondNumberString = equation.substring(operationIndex);

                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n FIRST NUMBER STRING: " + firstNumberString + "\nSECOND NUMBER STRING: " + secondNumberString);


                firstNumber = Double.parseDouble(firstNumberString);
                secondNumber = Double.parseDouble(secondNumberString);

                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n FIRST NUMBER: " + firstNumber + "\nSECOND NUMBER : " + secondNumber );


                double result = firstNumber + secondNumber;
                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n RESULTS OF THE CARNAGE: : " + result);
                screen.setText(String.valueOf(result));

                break;
            case SUBTRACTION:


                operationIndex = equation.indexOf(SUBTRACTION_SIGN);
                firstNumberString = equation.substring(0, operationIndex);
                secondNumberString = equation.substring(operationIndex + 1);

                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n FIRST NUMBER STRING: " + firstNumberString + "\nSECOND NUMBER STRING: " + secondNumberString);


                firstNumber = Double.parseDouble(firstNumberString);
                secondNumber = Double.parseDouble(secondNumberString);

                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n FIRST NUMBER: " + firstNumber + "\nSECOND NUMBER : " + secondNumber );


                result = firstNumber + secondNumber;
                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n RESULTS OF THE CARNAGE: : " + result);
                screen.setText(String.valueOf(result));

                break;
            case MULTIPLICATION:

                operationIndex = equation.indexOf(MULTIPLICATION_SIGN);
                firstNumberString = equation.substring(0, operationIndex );
                secondNumberString = equation.substring(operationIndex + 1);

                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n FIRST NUMBER STRING: " + firstNumberString + "\nSECOND NUMBER STRING: " + secondNumberString);


                firstNumber = Double.parseDouble(firstNumberString);
                secondNumber = Double.parseDouble(secondNumberString);

                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n FIRST NUMBER: " + firstNumber + "\nSECOND NUMBER : " + secondNumber );


                result = firstNumber * secondNumber;
                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n RESULTS OF THE CARNAGE: : " + result);
                screen.setText(String.valueOf(result));
                break;
            case DIVISION:


                operationIndex = equation.indexOf(DIVISION_SIGN);
                firstNumberString = equation.substring(0, operationIndex );
                secondNumberString = equation.substring(operationIndex + 1);

                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n FIRST NUMBER STRING: " + firstNumberString + "\nSECOND NUMBER STRING: " + secondNumberString);


                firstNumber = Double.parseDouble(firstNumberString);
                secondNumber = Double.parseDouble(secondNumberString);

                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n FIRST NUMBER: " + firstNumber + "\nSECOND NUMBER : " + secondNumber );


                result = firstNumber / secondNumber;
                Log.i("We doin MATH!!", "TIME TO START ADDING!!! \n RESULTS OF THE CARNAGE: : " + result);
                screen.setText(String.valueOf(result));
                break;
        }

    }

}
