package com.example.week1_2ndmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.DataUser;
import model.User;

public class DetailActivity extends AppCompatActivity {

    public ArrayList<User> listUser = DataUser.saveList;
    public User user;
    public int index;
    private ImageView back_button, edit_button, delete_button;
    private TextView detail_nama, detail_umur, detail_kota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        user = getIntent().getParcelableExtra("profile");
        index = getIntent().getIntExtra("index", 0);
        initView();

        detail_nama.setText(user.getNama());
        detail_umur.setText(String.valueOf(user.getUmur()));
        detail_kota.setText(user.getKota());

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {
        detail_nama = findViewById(R.id.detail_nama);
        detail_umur = findViewById(R.id.detail_umur);
        detail_kota = findViewById(R.id.detail_kota);
        edit_button = findViewById(R.id.edit_button);
        delete_button = findViewById(R.id.delete_button);

    }
}