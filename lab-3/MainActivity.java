package com.example.lab3_4mt19cs044;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
     EditText eusername,epassword;
     Button signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eusername=findViewById(R.id.editTextUserName1);
        epassword=findViewById(R.id.editTextPassword1);
        signupbtn=findViewById(R.id.SignUp);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=eusername.getText().toString();
                String  password=epassword.getText().toString();
                if (!validpwd(password))
                {
                    Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent in=new Intent(MainActivity.this,Login.class);
                in.putExtra("username",username);
                in.putExtra("password",password);
                startActivity(in);
            }
        });
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern splcharacter=Pattern.compile("^.*[^a-zA-Z0-9].*$");

    private boolean validpwd(String pwd)
    {
           if(pwd.length()<8) return false;
           if(!lowercase.matcher(pwd).matches()) return false;
           if(!uppercase.matcher(pwd).matches()) return false;
           if(!number.matcher(pwd).matches()) return false;
           if(!splcharacter.matcher(pwd).matches()) return false;
           return true;


    }
}