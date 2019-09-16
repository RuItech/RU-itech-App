package com.example.ru_itech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void btn_sign_up(View View)
    {
        startActivity(new Intent(SignUp.this, Login.class));



    }
    public void sign_in_link(View View)
    {
        startActivity(new Intent(SignUp.this, Login.class));



    }
}
