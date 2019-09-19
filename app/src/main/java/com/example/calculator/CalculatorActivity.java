package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorActivity extends AppCompatActivity {

    //Variables for the calculator

    @BindView(R.id.screen) TextView screen;





    Double firstNumber = null, secondNumber = null;
    String operation;


    public final static String DEFAULT_SCREEN_VALUE = "0";
    public final static String ADDITION = "+";
    public final static String SUBTRACTION = "-";
    public final static String MULTIPLICATION = "x";
    public final static String DIVISION = "/";
    public final static String CLEAR = "C";
    public final static String EQUALS = "=";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn_0,R.id.btn_1,R.id.btn_2,R.id.btn_3,R.id.btn_4,R.id.btn_5,R.id.btn_6,R.id.btn_7,R.id.btn_8,R.id.btn_9,R.id.btn_Point})
    public void numberWasClicked(Button button)
    {
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
        String screenText = screen.getText().toString();

        Log.i("Adding", "ADDING NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

        String newText = screenText + ADDITION;
        screen.setText(newText);
//                        Add(screenText); Function to ensure one can use multiple operations
        /*String newScreenText;
        int operatorIndex;

        if (currentScreenText.contains("+")) {
            operatorIndex = currentScreenText.indexOf("+");

            firstNumber = Double.parseDouble(currentScreenText.substring(0, operatorIndex));  //Because we do not want the operator in this

        } else {
            firstNumber = Double.parseDouble(currentScreenText);
        }

        newScreenText = firstNumber + " + ";
*/
    }
    @OnClick(R.id.btn_minus)
    public void Subtract() {
        String screenText = screen.getText().toString();
        Log.i("Adding", "ADDING NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

        String newText =  screenText + SUBTRACTION;
        screen.setText(newText);
//                        Subtract(screenText); Function to ensure one can use multiple operations
       /* String newScreenText;
        int operatorIndex;

        if (currentScreenText.contains("-")) {
            operatorIndex = currentScreenText.indexOf("-");

            firstNumber = Double.parseDouble(currentScreenText.substring(0, operatorIndex));

        } else {
            firstNumber = Double.parseDouble(currentScreenText);
        }
        newScreenText = firstNumber + " - ";
*/
    }
    @OnClick(R.id.btn_multiply)
    public void Multiply() {
        String screenText = screen.getText().toString();

        Log.i("Adding", "ADDING NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

        String newText = screenText + MULTIPLICATION;
        screen.setText(newText);
//                        Multiply(screenText); Function to ensure one can use multiple operations


       /* String newScreenText;
        int operatorIndex;

        if (currentScreenText.contains("x")) {
            operatorIndex = currentScreenText.indexOf("x");

            firstNumber = Double.parseDouble(currentScreenText.substring(0, operatorIndex));

        } else {
            firstNumber = Double.parseDouble(currentScreenText);
        }
        newScreenText = firstNumber + " x ";
*/
    }
    @OnClick(R.id.btn_divide)
    public void Divide() {
        String screenText = screen.getText().toString();

        Log.i("Adding", "ADDING NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

        String newText =  screenText + DIVISION;
        screen.setText(newText);

//                        Divide(screenText); Function to ensure one can use multiple operations


     /*   String newScreenText;
        int operatorIndex;

        if (currentScreenText.contains("/")) {
            operatorIndex = currentScreenText.indexOf("/");

            firstNumber = Double.parseDouble(currentScreenText.substring(0, operatorIndex));

        } else {
            firstNumber = Double.parseDouble(currentScreenText);
        }
        newScreenText = firstNumber + " / ";
*/
    }
    @OnClick(R.id.btn_clear)
    public void Clear()
    {
        screen.setText(DEFAULT_SCREEN_VALUE);
        firstNumber = null;
        secondNumber = null;
        operation = null;
    }

    @OnClick(R.id.btn_equals)
    public void Equals() {

        String equation = screen.getText().toString();
        int operationIndex;


        if (equation.contains(ADDITION)) {
            Log.i("full text", "the full equation: " + equation);


            operationIndex = equation.indexOf(ADDITION) + 1;
            String firstNumberString = equation.substring(0,operationIndex - 1),secondNumberString = equation.substring(operationIndex);



            Log.i("*****first NumberString", "firstNumberString was: " + firstNumberString);
            Log.i("***second NumberString", "secondNumberString was: " + secondNumberString);

            firstNumber = Double.parseDouble(firstNumberString);
            secondNumber = Double.parseDouble(secondNumberString);

            Log.i("first Number ", "firstNumber was: " + firstNumber);
            Log.i("second Number ", "secondNumber was: " + secondNumber);

            double result =firstNumber + secondNumber;
            Log.i("***********EndResult ", "The end result was: " + result);

            screen.setText(String.valueOf(result));

        }
        if (equation.contains(SUBTRACTION)) {
            Log.i("full text", "the full equation: " + equation);


            operationIndex = equation.indexOf(SUBTRACTION) + 1;
            String firstNumberString = equation.substring(0,operationIndex - 1);
            String secondNumberString = equation.substring(operationIndex);



            Log.i("*****first NumberString", "firstNumberString was: " + firstNumberString);
            Log.i("***second NumberString", "secondNumberString was: " + secondNumberString);

            firstNumber = Double.parseDouble(firstNumberString);
            secondNumber = Double.parseDouble(secondNumberString);

            Log.i("first Number ", "firstNumber was: " + firstNumber);
            Log.i("second Number ", "secondNumber was: " + secondNumber);

            double result =firstNumber - secondNumber;
            Log.i("***********EndResult ", "The end result was: " + result);

            screen.setText(String.valueOf(result));

        }
        if (equation.contains(DIVISION)) {
            Log.i("full text", "the full equation: " + equation);


            operationIndex = equation.indexOf(DIVISION) + 1;
            String firstNumberString = equation.substring(0,operationIndex - 1),secondNumberString = equation.substring(operationIndex);



            Log.i("*****first NumberString", "firstNumberString was: " + firstNumberString);
            Log.i("***second NumberString", "secondNumberString was: " + secondNumberString);

            firstNumber = Double.parseDouble(firstNumberString);
            secondNumber = Double.parseDouble(secondNumberString);

            Log.i("first Number ", "firstNumber was: " + firstNumber);
            Log.i("second Number ", "secondNumber was: " + secondNumber);

            double result =firstNumber / secondNumber;
            Log.i("***********EndResult ", "The end result was: " + result);

            screen.setText(String.valueOf(result));

        }
        if (equation.contains(MULTIPLICATION)) {
            Log.i("full text", "the full equation: " + equation);


            operationIndex = equation.indexOf(MULTIPLICATION) + 1;
            String firstNumberString = equation.substring(0,operationIndex - 1),secondNumberString = equation.substring(operationIndex);



            Log.i("*****first NumberString", "firstNumberString was: " + firstNumberString);
            Log.i("***second NumberString", "secondNumberString was: " + secondNumberString);

            firstNumber = Double.parseDouble(firstNumberString);
            secondNumber = Double.parseDouble(secondNumberString);

            Log.i("first Number ", "firstNumber was: " + firstNumber);
            Log.i("second Number ", "secondNumber was: " + secondNumber);

            double result =firstNumber * secondNumber;
            Log.i("***********EndResult ", "The end result was: " + result);

            screen.setText(String.valueOf(result));

        }
    }

}
