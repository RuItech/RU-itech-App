package com.example.ru_itech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void btn_sign_in(View View)
    {
        startActivity(new Intent(Login.this, MainPage.class));



    }
    public void sign_up_link(View View)
    {
        startActivity(new Intent(Login.this, SignUp.class));



    }


}
