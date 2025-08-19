package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView display;
    private String currentInput="";
    private String operator="";
    private double firstOperand=0;
    private boolean isOperatorPressed=false;
    private boolean isEqualsPressed=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSubtract).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);
        findViewById(R.id.btnEquals).setOnClickListener(this);

        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);
        findViewById(R.id.btnDecimal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int id=v.getId();

        if(id==R.id.btn0) numberPressed("0");
        else if(id==R.id.btn1) numberPressed("1");
        else if(id==R.id.btn2) numberPressed("2");
        else if(id==R.id.btn3) numberPressed("3");
        else if(id==R.id.btn4) numberPressed("4");
        else if(id==R.id.btn5) numberPressed("5");
        else if(id==R.id.btn6) numberPressed("6");
        else if(id==R.id.btn7) numberPressed("7");
        else if(id==R.id.btn8) numberPressed("8");
        else if(id==R.id.btn9) numberPressed("9");


        else if(id==R.id.btnAdd) operatorPressed("+");
        else if(id==R.id.btnSubtract) operatorPressed("-");
        else if(id==R.id.btnMultiply) operatorPressed("×");
        else if(id==R.id.btnDivide) operatorPressed("÷");

        else if(id==R.id.btnEquals) equalsPressed();
        else if(id==R.id.btnClear) clearPressed();
        else if(id==R.id.btnDelete) deletePressed();
        else if(id==R.id.btnDecimal) decimalPressed();
    }

    private void numberPressed(String number){
        if(isEqualsPressed){
            currentInput="";
            isEqualsPressed=false;
        }

        if(isOperatorPressed){
            currentInput="";
            isOperatorPressed=false;
        }

        currentInput+=number;
        display.setText(currentInput);
    }

    private void operatorPressed(String op){
        if(!currentInput.isEmpty()){
            if(!isOperatorPressed && !operator.isEmpty()){
                equalsPressed();
            }
            firstOperand=Double.parseDouble(currentInput);
            operator=op;
            isOperatorPressed=true;
            isEqualsPressed=false;
        }
    }

    private void equalsPressed(){
        if(!currentInput.isEmpty() && !operator.isEmpty()){
            double secondOperand=Double.parseDouble(currentInput);
            double result=0;

            switch(operator){
                case "+":
                    result=firstOperand+secondOperand;
                    break;
                case "-":
                    result=firstOperand-secondOperand;
                    break;
                case "×":
                    result=firstOperand*secondOperand;
                    break;
                case "÷":
                    if(secondOperand!=0){
                        result=firstOperand/secondOperand;
                    }else{
                        display.setText("Error");
                        clearAll();
                        return;
                    }
                    break;
            }

            if(result==(long)result) {
                currentInput=String.valueOf((long) result);
            }else{
                currentInput=String.valueOf(result);
            }

            display.setText(currentInput);
            operator="";
            isEqualsPressed=true;
        }
    }

    private void clearPressed(){
        clearAll();
        display.setText("0");
    }

    private void deletePressed(){
        if (!currentInput.isEmpty()){
            currentInput=currentInput.substring(0,currentInput.length()-1);
            if (currentInput.isEmpty()) {
                display.setText("0");
            }else{
                display.setText(currentInput);
            }
        }
    }

    private void decimalPressed(){
        if(isEqualsPressed){
            currentInput="0";
            isEqualsPressed=false;
        }

        if(isOperatorPressed){
            currentInput="0";
            isOperatorPressed=false;
        }

        if(!currentInput.contains(".")){
            if(currentInput.isEmpty()){
                currentInput="0.";
            }else{
                currentInput+=".";
            }
            display.setText(currentInput);
        }
    }
    private void clearAll(){
        currentInput="";
        operator="";
        firstOperand=0;
        isOperatorPressed=false;
        isEqualsPressed=false;
    }
}
