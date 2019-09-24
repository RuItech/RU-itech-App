package com.example.ru_itech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    private Button SignUpButton;
    private EditText EmailStudent;
    private EditText PasswordStudent;
    private DatabaseReference StudentDatabaseRef;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mAuth=FirebaseAuth.getInstance();

        SignUpButton = (Button) findViewById(R.id.signup_button);
        EmailStudent = (EditText) findViewById(R.id.email_student);
        PasswordStudent = (EditText) findViewById(R.id.password_student);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String email = EmailStudent.getText().toString();
                String password = PasswordStudent.getText().toString();

                RegisterStudent(email, password);
            }
        });
    }

    private void RegisterStudent(String email, String password)
    {
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(SignUp.this, "Please enter your email", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(SignUp.this, "Please enter your password", Toast.LENGTH_SHORT).show();
        }

        else
        {


            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        StudentDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Students");
                        StudentDatabaseRef.setValue(true);

                        Intent studentIntent = new Intent(SignUp.this, Login.class);
                        startActivity(studentIntent);
                        Toast.makeText(SignUp.this, "Student registered successfully..", Toast.LENGTH_SHORT).show();

                    }




                    else
                    {
                        Toast.makeText(SignUp.this, "Registration Failed!, Please try again...", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }


    public void sign_in_link(View View)
    {
        startActivity(new Intent(SignUp.this, Login.class));



    }
}
