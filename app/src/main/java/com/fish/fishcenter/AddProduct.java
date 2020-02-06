package com.fish.fishcenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddProduct extends AppCompatActivity {

    RelativeLayout change_product,next,rl_next1;
    EditText edt_try_no,edt_peice,edt_weight;
    LinearLayout plus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
        change_product=findViewById(R.id.rl_change_product);
        edt_try_no=findViewById(R.id.edt_try_no);
        edt_peice=findViewById(R.id.edt_peice);
        edt_weight=findViewById(R.id.edt_weight);
        plus=findViewById(R.id.add);
        rl_next1=findViewById(R.id.rl_next1);

        next=findViewById(R.id.rl_next1);
        change_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edt_try_no.setText("");
                edt_peice.setText("");
                edt_weight.setText("");
            }
        });
        rl_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent listProduct=new Intent(getApplicationContext(),ListProduct.class);
               startActivity(listProduct);

            }
        });

    }
}
