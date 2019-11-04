package com.example.ru_itech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;
import java.util.List;

public class Profile extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;

    Button btn_sign_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()

        );
        signout();
    }

    private void signout()
    {
        btn_sign_out = (Button)findViewById(R.id.btn_sign_out);
        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                AuthUI.getInstance().signOut(Profile.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        btn_sign_out.setEnabled(false);
                        showSignInOptions();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(Profile.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }

    private void showSignInOptions()
    {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).setTheme(R.style.MyTheme).build(),MY_REQUEST_CODE
        );

    }


}
