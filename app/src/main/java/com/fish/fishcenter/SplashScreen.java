package com.fish.fishcenter;






import android.app.ProgressDialog;
import android.content.Intent;


import android.os.Bundle;
import android.os.Handler;


import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.fish.fishcenter.util.GlobalClass;
import com.fish.fishcenter.util.Shared_Preference;





/**
 * Created by developer on 24/1/20.
 */

public class SplashScreen extends AppCompatActivity {

    GlobalClass globalClass;
    ProgressDialog pd;
    Shared_Preference prefrence;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
/*

        UpdateChecker checker = new UpdateChecker(this);
        // If you are in a Activity or a FragmentActivity

        checker.start();
*/


        globalClass = (GlobalClass) getApplicationContext();
        prefrence = new Shared_Preference(SplashScreen.this);
        prefrence.loadPrefrence();



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                if(globalClass.getLogin_status().equals(true)){
                    Intent intent = new Intent(SplashScreen.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(SplashScreen.this, Login.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 3000);
    }


}