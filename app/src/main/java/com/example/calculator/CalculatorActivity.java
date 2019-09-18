package com.example.calculator;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    //Variables for the calculator

    TextView screen;
    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    Button btnPoint, btnClear, btnPlus, btnMinus, btnMultiply, btnDivide, btnEquals;

    Double firstNumber = null, secondNumber = null;
    String operation;


    public final static String DEFAULT_SCREEN_VALUE = "0";
    public final static String ADDITION = "+";
    public final static String SUBTRACTION = "-";
    public final static String MULTIPLICATION = "x";
    public final static String DIVISION = "/";
    public final static String CLEAR = "C";

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Button buttonInstance = (Button) view;
            String newText = null;

            screen = findViewById(R.id.screen);

            String screenText = screen.getText().toString();
            String buttonText = buttonInstance.getText().toString();

            if (screenText.startsWith(DEFAULT_SCREEN_VALUE)) {
                newText = buttonInstance.getText().toString();
                Toast.makeText(CalculatorActivity.this, "Default Values", Toast.LENGTH_SHORT).show();
            } else if (buttonText.equals(ADDITION)) {
                Toast.makeText(CalculatorActivity.this, "Adding new Values", Toast.LENGTH_SHORT).show();

                Log.i("Adding", "ADDING NEW VALUES: ******CURRENT VALUE FOR********** VAR SCREENTEXT = " + screenText);

                newText = Add(screenText);

            } else if (buttonText.equals((SUBTRACTION))) {
                Toast.makeText(CalculatorActivity.this, "Subtractiong Values", Toast.LENGTH_SHORT).show();

                newText = Subtract(screenText);
            } else if (buttonText.equals((MULTIPLICATION))) {
                Toast.makeText(CalculatorActivity.this, "Multiplying Values", Toast.LENGTH_SHORT).show();

                newText = Multiply(screenText);
            } else if (buttonText.equals((DIVISION))) {
                Toast.makeText(CalculatorActivity.this, "Dividing Values", Toast.LENGTH_SHORT).show();

                newText = Divide(screenText);
            } else if (buttonText.equalsIgnoreCase("C")) {
                screen.setText("");
                firstNumber = null;
                secondNumber = null;
                operation = null;
            } else {
                newText = screen.getText().toString() + buttonInstance.getText();
            }

            screen.setText(newText);

            Toast.makeText(CalculatorActivity.this, buttonInstance.getText(), Toast.LENGTH_SHORT).show();

        }
    };

    private String Divide(String currentScreenText) {
        String newScreenText;
        int operatorIndex;

        if (currentScreenText.contains("/")) {
            operatorIndex = currentScreenText.indexOf("/");

            firstNumber = Double.parseDouble(currentScreenText.substring(0, operatorIndex));
            Toast.makeText(this, "" + firstNumber, Toast.LENGTH_SHORT).show();

        }
        newScreenText = firstNumber + " / ";

        return newScreenText;
    }

    private String Multiply(String currentScreenText) {
        String newScreenText;
        int operatorIndex;

        if (currentScreenText.contains("x")) {
            operatorIndex = currentScreenText.indexOf("x");

            firstNumber = Double.parseDouble(currentScreenText.substring(0, operatorIndex));
            Toast.makeText(this, "" + firstNumber, Toast.LENGTH_SHORT).show();

        }
        newScreenText = firstNumber + " x ";

        return newScreenText;
    }

    private String Subtract(String currentScreenText) {
        String newScreenText;
        int operatorIndex;

        if (currentScreenText.contains("-")) {
            operatorIndex = currentScreenText.indexOf("-");

            firstNumber = Double.parseDouble(currentScreenText.substring(0, operatorIndex));
            Toast.makeText(this, "" + firstNumber, Toast.LENGTH_SHORT).show();

        }
        newScreenText = firstNumber + " - ";

        return newScreenText;
    }

    public String Add(String currentScreenText) {
        String newScreenText;
        int operatorIndex;

        if (currentScreenText.contains("+")) {
            operatorIndex = currentScreenText.indexOf("+");

            firstNumber = Double.parseDouble(currentScreenText.substring(0, operatorIndex));  //Because we do not want the operator in this
            Toast.makeText(this, " " + firstNumber, Toast.LENGTH_SHORT).show();
        } else {
            firstNumber = Double.parseDouble(currentScreenText);
        }

        newScreenText = firstNumber + " + ";

        return newScreenText;
    }


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
