package com.example.lab3_4mt19cs044;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText eusername,epassword;
    Button Loginbtn;
    int counter=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eusername=findViewById(R.id.editTextUserName2);
        epassword=findViewById(R.id.editTextPassword2);
        Loginbtn=findViewById(R.id.Login);
        String musername=getIntent().getStringExtra("username");
        String mpassword=getIntent().getStringExtra("password");
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=eusername.getText().toString();
                String  password=epassword.getText().toString();
                if(musername.equals(username) && mpassword.equals(password))
                {
                    Intent IN=new Intent(Login.this,LoginSuccess.class);
                    startActivity(IN);
                }
                else
                {
                    Toast.makeText(Login.this,"Inavlid credentials",Toast.LENGTH_LONG).show();
                }
                counter--;
                if(counter==0)
                {
                    Toast.makeText(Login.this,"Too many failure attempts",Toast.LENGTH_LONG).show();
                    Loginbtn.setEnabled(false);

                }
            }
        });
    }
}