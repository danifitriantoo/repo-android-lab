package com.example.applicationactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eUsername, eKeypass;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btnSUBMIT);
        eUsername = findViewById(R.id.eUSER);
        eKeypass = findViewById(R.id.eKEY);

        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Navigation(HomeActivity.class);
                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        eUsername.setText("");
        eKeypass.setText("");
    }

    void Navigation(Class target) {
        if(Validation(eUsername.getText().toString(),eKeypass.getText().toString()) == false) {
            Intent i = new Intent(MainActivity.this,target);startActivity(i);
            i.putExtra("nama","Dani");
            startActivity(i);
        } else {
            extracted();
//            Toast.makeText(MainActivity.this,"Field must be filled", Toast.LENGTH_LONG).show();
        }
    }

    private void extracted() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Peringatan");
        builder.setMessage("Field Harus Diisi!");
        builder.setPositiveButton(
                "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }
        );
        AlertDialog builderFinish = builder.create();
        builderFinish.show();
    }

    Boolean Validation(String a, String b) {
        Boolean x = a.isEmpty() || b.isEmpty() ? true : false;
        return x;
    }

}