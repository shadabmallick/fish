package com.fish.fishcenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen  extends AppCompatActivity {
    ImageView img_inflow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        img_inflow=findViewById(R.id.img_inflow);
        img_inflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inflow=new Intent(getApplicationContext(),Register.class);
                startActivity(inflow);
            }
        });
    }
}
