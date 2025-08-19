package com.example.userinfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale,radioFemale;
    private CheckBox checkBoxInterest1,checkBoxInterest2,checkBoxInterest3;
    private Button buttonSubmit,buttonReset;
    private TextView textViewUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName=findViewById(R.id.edit_text_name);
        radioGroupGender=findViewById(R.id.radio_group_gender);
        radioMale=findViewById(R.id.radio_male);
        radioFemale=findViewById(R.id.radio_female);
        checkBoxInterest1=findViewById(R.id.reader);
        checkBoxInterest2=findViewById(R.id.writer);
        checkBoxInterest3=findViewById(R.id.swimmer);
        buttonSubmit=findViewById(R.id.display_button);
        textViewUserInfo=findViewById(R.id.text_view_display_info);
        buttonReset=findViewById(R.id.reset_button);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayUserInfo();
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                editTextName.setText("");
                radioGroupGender.clearCheck();
                checkBoxInterest1.setChecked(false);
                checkBoxInterest2.setChecked(false);
                checkBoxInterest3.setChecked(false);
                textViewUserInfo.setText("");


            }
        });
    }

    private void displayUserInfo(){
        StringBuilder userInfo=new StringBuilder();
        String name=editTextName.getText().toString().trim();
        if(!name.isEmpty()){
            textViewUserInfo.setText("Hello "+name);
        }

        int selectedGenderId=radioGroupGender.getCheckedRadioButtonId();
        if(selectedGenderId!=-1){
            RadioButton selectedGenderButton=findViewById(selectedGenderId);
            userInfo.append("Gender: ").append(selectedGenderButton.getText().toString()).append("\n");
        }

        StringBuilder interests = new StringBuilder();
        if(checkBoxInterest1.isChecked()){
            interests.append(checkBoxInterest1.getText().toString()).append(", ");
        }
        if(checkBoxInterest2.isChecked()){
            interests.append(checkBoxInterest2.getText().toString()).append(", ");
        }
        if(checkBoxInterest3.isChecked()){
            interests.append(checkBoxInterest3.getText().toString()).append(", ");
        }
        if(interests.length()>0){
            userInfo.append("Interests: ").append(interests.toString()).append("\n");
        }
        if(userInfo.length()>0) {
            Toast.makeText(this,userInfo,Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Please enter some information.",Toast.LENGTH_SHORT).show();
        }
    }
}
