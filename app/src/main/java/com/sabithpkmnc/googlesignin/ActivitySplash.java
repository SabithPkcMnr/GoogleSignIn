package com.sabithpkmnc.googlesignin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ActivitySplash extends AppCompatActivity {

    boolean pageIsActive;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        firebaseAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pageIsActive) {
                    if (firebaseAuth.getCurrentUser() != null) {
                        startActivity(new Intent(ActivitySplash.this, ActivityHome.class));
                        finishAffinity();

                    } else {
                        startActivity(new Intent(ActivitySplash.this, ActivityLogin.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        finishAffinity();
                    }
                }
            }
        }, 2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pageIsActive = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        pageIsActive = false;
    }
}