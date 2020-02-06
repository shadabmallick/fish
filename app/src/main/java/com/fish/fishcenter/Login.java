package com.fish.fishcenter;


import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;








public class Login extends AppCompatActivity {
    RelativeLayout rl_login;
    EditText edtUsername,edtPassword;
 //   UserService userService;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);




        edtUsername =  findViewById(R.id.edt_user_id);
        edtPassword =  findViewById(R.id.edt_password);
        rl_login =  findViewById(R.id.rl_login);

      //  userService = ApiUtils.getUserService();

        rl_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //validate form
                if(validateLogin(username, password)){
                    //do login
                    Intent intent = new Intent(Login.this, HomeScreen.class);
                   // intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });



    }
    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    }

