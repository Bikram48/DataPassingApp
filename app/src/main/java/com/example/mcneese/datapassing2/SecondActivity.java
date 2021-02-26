package com.example.mcneese.datapassing2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String passedData = getIntent().getStringExtra("str1");
        passedData += Integer.toString(getIntent().getIntExtra("age1", 0)) + "\n";

        Bundle bundle = getIntent().getExtras();
        passedData += bundle.getString("str2");
        passedData += Integer.toString(bundle.getInt("age2"));

        TextView textView = findViewById(R.id.textView23);
        textView.setText(passedData);
    }

    public void onClick(View view){
        Intent data = new Intent();
        EditText txt_username = findViewById(R.id.editText);
        data.setData(Uri.parse(txt_username.getText().toString()));
        setResult(RESULT_OK, data);
        finish();
    }

    public void redirectSecondActivity(View view) {
        Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getData().toString();
                Intent returnIntent = new Intent();
                returnIntent.setData(Uri.parse(result));
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }
}