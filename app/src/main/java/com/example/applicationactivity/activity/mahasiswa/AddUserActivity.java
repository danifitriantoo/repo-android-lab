package com.example.applicationactivity.activity.mahasiswa;

import static com.example.applicationactivity.room.AppApplication.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applicationactivity.R;
import com.example.applicationactivity.room.Mahasiswa;

public class AddUserActivity extends AppCompatActivity {

    private Button insertData;
    private EditText etAlamat, etKejuruan, etNama, etNim;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        insertData = findViewById(R.id.btnInsert);
        etAlamat = findViewById(R.id.etAlamat);
        etKejuruan = findViewById(R.id.etKejuruan);
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);

        insertData.setOnClickListener(view -> {
            if(!etAlamat.getText().toString().isEmpty() && !etKejuruan.toString().isEmpty() &&
                    !etNama.getText().toString().isEmpty() && !etNim.getText().toString().isEmpty())
            {
                mahasiswa = new Mahasiswa();
                mahasiswa.setAlamat(etAlamat.getText().toString());
                mahasiswa.setNama(etNama.getText().toString());
                mahasiswa.setKejuruan(etKejuruan.getText().toString());
                mahasiswa.setNim(etNim.getText().toString());

                db.userDao().insertAll(mahasiswa);

                Intent i = new Intent(AddUserActivity.this,UserActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Mohon masukan dengan benar!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}