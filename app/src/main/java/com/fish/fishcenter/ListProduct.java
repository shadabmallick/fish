package com.fish.fishcenter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListProduct extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;
    RelativeLayout rl_change_product,rl_next1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_page);
        String[] data = {"12344", "25", "250", "12344", "25", "250", "12344", "25", "250", "12344", "25", "250", "12344", "25", "250", "12344","25", "250" };
        String[] data1 = {"12344", "25", "250", "12344", "25", "250", "12344", "25", "250", "12344", "25", "250", "12344", "25", "250", "12344","25", "250" };

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recylerVIew);
        rl_change_product= findViewById(R.id.rl_change_product);
        rl_next1 = findViewById(R.id.rl_next1);
        RecyclerView recyclerView1 = findViewById(R.id.recylerVIew1);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        recyclerView1.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data1);
        adapter.setClickListener(this);
        recyclerView1.setAdapter(adapter);

        rl_change_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rl_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListProduct.this, Register.class);
                // intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }
    }

