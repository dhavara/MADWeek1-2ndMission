package com.example.week1_2ndmission;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import model.User;

public class TambahUser extends AppCompatActivity {

    private TextInputLayout inputnama, inputumur, inputkota;
    private Button inputuser_addbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        getSupportActionBar().hide();
        initView();
        setListener();


    }

    private void initView() {
        inputnama = findViewById(R.id.inputnama);
        inputumur = findViewById(R.id.inputumur);
        inputkota = findViewById(R.id.inputkota);
        inputuser_addbutton = findViewById(R.id.inputuser_addbutton);
    }

    private void setListener() {
        inputuser_addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = inputnama.getEditText().getText().toString().trim();
                String kota = inputkota.getEditText().getText().toString().trim();
                int umur = Integer.parseInt(inputumur.getEditText().getText().toString().trim());
                User temp = new User(nama, umur, kota);

                Intent intent = new Intent();
                intent.putExtra("userBaru", temp);
                setResult(200, intent);
                finish();
            }
        });
    }
}
