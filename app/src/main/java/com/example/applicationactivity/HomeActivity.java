package com.example.applicationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.applicationactivity.util.PreferencesHelper;

public class HomeActivity extends AppCompatActivity {

    private Button btnActivity, btnFragment;
    private EditText etNama;
    public static final String KEY_INTENT = "PUT_EXTRA";
    private PreferencesHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        helper = PreferencesHelper.getInstance(getApplicationContext());

        btnActivity = findViewById(R.id.btnActiviy);
        btnFragment = findViewById(R.id.btnFragment);
        etNama = findViewById(R.id.etNama);

        btnActivity.setOnClickListener(
                view -> {
                    helper.setLogin(true);
                    helper.setNama(etNama.getText().toString());

                    Intent i = new Intent(HomeActivity.this,FirstActivity.class);
//                    i.putExtra(KEY_INTENT,etNama.getText().toString());
//                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }
        );

        btnFragment.setOnClickListener(
                view -> {
                    Intent i = new Intent(HomeActivity.this,SecondActivity.class);
                    startActivity(i);


                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}