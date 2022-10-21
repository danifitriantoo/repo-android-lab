package com.example.applicationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.applicationactivity.util.PreferencesHelper;

public class FirstActivity extends AppCompatActivity {

    private static final String KEY_INTENT = "PUT_EXTRA";
    private PreferencesHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        helper = PreferencesHelper.getInstance(getApplicationContext());

        TextView txtFirst = findViewById(R.id.txtFirst);

//        Intent i = getIntent();
//        String value = i.getStringExtra(KEY_INTENT);
        txtFirst.setText(helper.getNama());
    }
}