package com.example.mcneese.datapassing2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int TEXT_REQUEST = 2;
    private Button secondBtn;
    private Button button;
    private static final int request_Code = 1;
    TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.firstBtn);
        button.setOnClickListener(this);
        secondBtn=(Button) findViewById(R.id.secondBtn);
        secondBtn.setOnClickListener(this);
        textView5=findViewById(R.id.textView5);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.firstBtn:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("str1", "Age of Alice is: ");
                intent.putExtra("age1", 25);

                Bundle extras = new Bundle();
                extras.putString("str2", "Age of Bob is: ");
                extras.putInt("age2", 35);
                intent.putExtras(extras);

                startActivityForResult(intent, MainActivity.request_Code);
                break;
            case R.id.secondBtn:
                Intent intent1=new Intent(MainActivity.this,ThirdActivity.class);
                startActivityForResult(intent1,MainActivity.TEXT_REQUEST);
                break;
            default:
                break;
        }
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode) {
            case request_Code:
                if (resultCode == RESULT_OK) {
                    String username = data.getData().toString();
                    if(data.getData().toString().equals("senior")||data.getData().toString().equals("junior")){
                        textView5.setText(data.getData().toString());
                    }
                    else {
                        TextView textView = findViewById(R.id.textView2);
                        textView.setText(username);
                    }
                }
                break;
            case TEXT_REQUEST:
                if (resultCode == RESULT_OK) {
                    //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                    String userStatus = data.getData().toString();
                    textView5.setText(userStatus);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);

        }
    }
}