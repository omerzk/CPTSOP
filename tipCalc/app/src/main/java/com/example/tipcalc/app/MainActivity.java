package com.example.tipcalc.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.round;

public class MainActivity extends Activity {
    private static final String INPUT_ERROR = "Please input a real number";
    private final static Double TIP_FACTOR = 0.12;
    private EditText input;
    private TextView tipField;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.inputBill);
        tipField = (TextView)findViewById(R.id.tipField);
        checkBox = (CheckBox)findViewById(R.id.checkBox);

    }

    public void calculate(View v){
        String output = INPUT_ERROR;
        String billStr = input.getText().toString();
        if (isNumeric(billStr)){
            double tip = Double.parseDouble(billStr) * TIP_FACTOR;
            tip = checkBox.isChecked() ? round(tip) : tip;
            output = tip != round(tip) ? String.valueOf(tip) : String.valueOf((int)tip);
        }
        tipField.setText(output);
    }

    /*checks that the string is a number in R*/
    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
