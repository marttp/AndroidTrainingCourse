package com.example.thanaphoombabparn.calculatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText firstOperand = null;
    public EditText secondOperand = null;
    public TextView operatorShow = null;
    public TextView resultShow = null;
    private int wayToSolve = 0;

    private double operand1 = 0;
    private double operand2 = 0;
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstOperand = findViewById(R.id.firstOperand);
        secondOperand = findViewById(R.id.secondOperand);
        resultShow = findViewById(R.id.result);
        operatorShow = findViewById(R.id.operatorShow);

    }

    public void findResult(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                operatorShow.setText("+");
                wayToSolve = 1;
                break;
            case R.id.btnSubtract:
                operatorShow.setText("-");
                wayToSolve = 2;
                break;
            case R.id.btnMultiply:
                operatorShow.setText("*");
                wayToSolve = 3;
                break;
            case R.id.btnDivide:
                operatorShow.setText("/");
                wayToSolve = 4;
                break;
            case R.id.btnResult:
                if(wayToSolve != 0){
                    try{
                        operand1 = Double.parseDouble(firstOperand.getText().toString());
                        operand2 = Double.parseDouble(secondOperand.getText().toString());
                        switch (wayToSolve){
                            case 1:
                                result = operand1 + operand2;
                                resultShow.setText(String.valueOf(result));
                                break;
                            case 2:
                                result = operand1 - operand2;
                                resultShow.setText(String.valueOf(result));
                                break;
                            case 3:
                                result = operand1 * operand2;
                                resultShow.setText(String.valueOf(result));
                                break;
                            case 4:
                                result = operand1 / operand2;
                                resultShow.setText(String.valueOf(result));
                                break;
                        }
                    } catch (ArithmeticException e){
                        resultShow.setText(R.string.arith_error);
                    } catch (Exception e){
                        resultShow.setText(R.string.something_error);
                    }
                }
                break;
            case R.id.btnClear:
                firstOperand.setText(null);
                secondOperand.setText(null);
                operand1 = 0;
                operand2 = 0;
                operatorShow.setText(null);
                wayToSolve = 0;
                resultShow.setText(R.string.result_here);
                break;
        }
    }
}
