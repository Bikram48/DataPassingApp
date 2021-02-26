package com.example.mcneese.datapassing2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "ThirdActivity";
    private EditText statusInputEditText;
    private Button submitBtn;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        statusInputEditText=findViewById(R.id.textInputEditText);
        submitBtn=findViewById(R.id.submit);
        submitBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        checkStatus();
    }

    private void checkStatus() {
        String[] statusList={"junior","senior"};
        String inputText=statusInputEditText.getText().toString().trim().toLowerCase();
        if(!Arrays.asList(statusList).contains(inputText)){
            Toast.makeText(this, "Invalid status! Only junior and senior are valid.", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent();
            intent.setData(Uri.parse(inputText));
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}