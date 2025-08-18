
package com.example.numbersumapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnSum, btnReset;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnSum = findViewById(R.id.btnSum);
        btnReset = findViewById(R.id.btnReset);
        txtResult = findViewById(R.id.txtResult);

        // Sum Button
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = num1.getText().toString();
                String s2 = num2.getText().toString();

                if (s1.isEmpty() || s2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both numbers!", Toast.LENGTH_SHORT).show();
                } else {
                    int n1 = Integer.parseInt(s1);
                    int n2 = Integer.parseInt(s2);
                    int sum = n1 + n2;

                    txtResult.setText("Result: " + sum);
                    Toast.makeText(MainActivity.this, "Sum is: " + sum, Toast.LENGTH_LONG).show();
                }
            }
        });

        // Reset Button
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                txtResult.setText("Result: ");
            }
        });
    }
}
