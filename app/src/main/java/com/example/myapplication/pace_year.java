package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pace_year extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_year);

    }
    public void companyclick(View v){
        Intent i = new Intent(this,Company.class);
        String name = ((Button)v).getText().toString();
        i.putExtra("NAME",name);
        startActivity(i);


    }
}