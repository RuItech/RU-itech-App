package com.example.ru_itech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button SignInButton;
    private EditText EmailStudent;
    private EditText PasswordStudent;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth=FirebaseAuth.getInstance();



        SignInButton = (Button) findViewById(R.id.signin_button);
        EmailStudent = (EditText) findViewById(R.id.email_student);
        PasswordStudent = (EditText) findViewById(R.id.password_student);



        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String email = EmailStudent.getText().toString();
                String password = PasswordStudent.getText().toString();

                SignInStudent(email,password);
            }
        });
        

    }

    private void SignInStudent(String email, String password)
    {
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(Login.this, "Please enter your email", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
        }

        else
        {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        Intent studentIntent = new Intent(Login.this, MainPage.class);
                        startActivity(studentIntent);

                        Toast.makeText(Login.this, "Login successfully..", Toast.LENGTH_SHORT).show();




                    }

                    else{
                        Toast.makeText(Login.this, "login Failed!, Please try again...", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }




}
