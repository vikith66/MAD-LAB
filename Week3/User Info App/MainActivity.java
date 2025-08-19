package com.example.userinfoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    CheckBox cbReading, cbTraveling, cbSports;
    Button btnSubmit, btnReset;
    TextView tvResult;
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cbReading = findViewById(R.id.cbReading);
        cbTraveling = findViewById(R.id.cbTraveling);
        cbSports = findViewById(R.id.cbSports);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);
        tvResult = findViewById(R.id.tvResult);
        imgProfile = findViewById(R.id.imgProfile);

        // Handle Radio Button Toast
        rgGender.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbMale) {
                Toast.makeText(MainActivity.this, "Male Selected", Toast.LENGTH_SHORT).show();
            } else if (checkedId == R.id.rbFemale) {
                Toast.makeText(MainActivity.this, "Female Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Checkbox Toast
        View.OnClickListener checkBoxListener = v -> {
            CheckBox cb = (CheckBox) v;
            if (cb.isChecked()) {
                Toast.makeText(MainActivity.this, cb.getText() + " Selected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, cb.getText() + " Unselected", Toast.LENGTH_SHORT).show();
            }
        };

        cbReading.setOnClickListener(checkBoxListener);
        cbTraveling.setOnClickListener(checkBoxListener);
        cbSports.setOnClickListener(checkBoxListener);

        // Submit Button Action
        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String gender = "";

            int selectedId = rgGender.getCheckedRadioButtonId();
            if (selectedId == R.id.rbMale) {
                gender = "Male";
            } else if (selectedId == R.id.rbFemale) {
                gender = "Female";
            }

            StringBuilder hobbies = new StringBuilder();
            if (cbReading.isChecked()) hobbies.append("Reading ");
            if (cbTraveling.isChecked()) hobbies.append("Traveling ");
            if (cbSports.isChecked()) hobbies.append("Sports ");

            String result = "Name: " + name +
                    "\nEmail: " + email +
                    "\nGender: " + gender +
                    "\nHobbies: " + hobbies;

            tvResult.setText(result);
        });

        // Reset Button Action
        btnReset.setOnClickListener(v -> {
            etName.setText("");
            etEmail.setText("");
            rgGender.clearCheck();
            cbReading.setChecked(false);
            cbTraveling.setChecked(false);
            cbSports.setChecked(false);
            tvResult.setText("");
        });
    }
}
