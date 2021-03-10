package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView inputText, outputText;
    private String input, output, newoutPut;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract, btnMultiply, btnDivide, btnpoint, btnPower, btnEqual, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.input_txt);
        outputText = findViewById(R.id.output_txt);

        btn0 = findViewById(R.id.zero_btn);
        btn1 = findViewById(R.id.one_btn);
        btn2 = findViewById(R.id.two_btn);
        btn3 = findViewById(R.id.three_btn);
        btn4 = findViewById(R.id.four_btn);
        btn5 = findViewById(R.id.five_btn);
        btn6 = findViewById(R.id.six_btn);
        btn7 = findViewById(R.id.seven_btn);
        btn8 = findViewById(R.id.eight_btn);
        btn9 = findViewById(R.id.nine_btn);
        btnAdd = findViewById(R.id.add_btn);
        btnSubtract = findViewById(R.id.minus_btn);
        btnMultiply = findViewById(R.id.multiplication_btn);
        btnDivide = findViewById(R.id.division_btn);
        btnClear = findViewById(R.id.Clear_btn);
        btnEqual = findViewById(R.id.equal_btn);
        btnPower = findViewById(R.id.power_btn);
        btnpoint = findViewById(R.id.dot_btn);
    }

    public void onButtonClicked(View view){
         Button button = (Button)view;
         String inputBtn = button.getText().toString();
         switch(inputBtn) {
             case "C":
                 input = null;
                 output = null;
                 newoutPut = null;
                 outputText.setText("");
                 break;
             case "^":
                 solve();
                 input += "^";
                 break;
             case "*":
                 solve();
                 input += "*";
                 break;
             case "%":
                 input += "%";
                 double d = Double.parseDouble(inputText.getText().toString()) / 100;
                 outputText.setText(String.valueOf(d));
                 break;
             case "=":
                 solve();
                 break;
             default:
                 if (input == null){
                     input = "";
                 }
                 if (inputBtn.equals("+") || inputBtn.equals("-") || inputBtn.equals("/")){
                     solve();
                 }
                 input += inputBtn;
         }
         inputText.setText(input);
    }
    public void solve(){
        if (input.split("\\+").length == 2){
            String nums [] = input.split("\\+");
            try {
                double d = Double.parseDouble(nums[0]) + Double.parseDouble(nums[1]);
                output = Double.toString(d);
                newoutPut = cutDecimal(output);
                outputText.setText(newoutPut);
                input = d + "";
            }
            catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2){
            String nums [] = input.split("\\*");
            try {
                double d = Double.parseDouble(nums[0]) * Double.parseDouble(nums[1]);
                output = Double.toString(d);
                newoutPut = cutDecimal(output);
                outputText.setText(newoutPut);
                input = d + "";
            }
            catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length == 2){
            String nums [] = input.split("\\/");
            try {
                double d = Double.parseDouble(nums[0]) / Double.parseDouble(nums[1]);
                output = Double.toString(d);
                newoutPut = cutDecimal(output);
                outputText.setText(newoutPut);
                input = d + "";
            }
            catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\^").length == 2){
            String nums [] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
                output = Double.toString(d);
                newoutPut = cutDecimal(output);
                outputText.setText(newoutPut);
                input = d + "";
            }
            catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length == 2){
            String nums [] = input.split("\\-");
            try {
                if (Double.parseDouble(nums[0]) < Double.parseDouble(nums[1])){
                    double d = Double.parseDouble(nums[1]) - Double.parseDouble(nums[0]);
                    output = Double.toString(d);
                    newoutPut = cutDecimal(output);
                    outputText.setText("-" + newoutPut);
                    input = d + "";
                }
                else {
                    double d = Double.parseDouble(nums[0]) - Double.parseDouble(nums[1]);
                    output = Double.toString(d);
                    newoutPut = cutDecimal(output);
                    outputText.setText(newoutPut);
                    input = d + "";
                }

            }
            catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
    }
    private String cutDecimal(String number){
        String n[] = number.split("\\.");
        if (n.length > 1){
            if (n[1].equals("0")) {
                number = n[0];
            }
        }
        return number;
    }
}
