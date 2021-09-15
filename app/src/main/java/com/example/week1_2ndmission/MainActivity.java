package com.example.week1_2ndmission;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.User;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView_recyclerview;
    private ArrayList<User> dataUser;
    private UserRVAdapter adapter;
    private FloatingActionButton recyclerView_FAB_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();
        setupRecyclerView();
        setListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 200) {
                User userBaru = data.getParcelableExtra("userBaru");
                dataUser.add(userBaru);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void initView(){
        recyclerView_recyclerview = findViewById(R.id.recyclerView_recyclerview);
        dataUser = new ArrayList<User>();
        adapter = new UserRVAdapter(dataUser);
        recyclerView_FAB_add = findViewById(R.id.recyclerView_FAB_add);
    }

    private void setupRecyclerView(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerView_recyclerview.setLayoutManager(manager);
        recyclerView_recyclerview.setAdapter(adapter);
    }

    private void setListener(){
        recyclerView_FAB_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TambahUser.class);
                startActivityForResult(intent, 1);
            }
        });
    }
}