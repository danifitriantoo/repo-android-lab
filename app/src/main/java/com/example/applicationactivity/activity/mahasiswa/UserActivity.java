package com.example.applicationactivity.activity.mahasiswa;

import static com.example.applicationactivity.room.AppApplication.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.applicationactivity.R;
import com.example.applicationactivity.activity.RecyclerviewUserAdapter;
import com.example.applicationactivity.room.AppDatabase;
import com.example.applicationactivity.room.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerviewUserAdapter adapter;
    List<Mahasiswa> listMahasiswa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView = findViewById(R.id.recyclerView);
        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }


    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();

        listMahasiswa = db.userDao().getAll();

        for(int i= 0; i < listMahasiswa.size();i++) {
            Log.e("Aplikasi",listMahasiswa.get(i).getAlamat() + i);
            Log.e("Aplikasi",listMahasiswa.get(i).getKejuruan() + i);
            Log.e("Aplikasi",listMahasiswa.get(i).getNama() + i);
            Log.e("Aplikasi",listMahasiswa.get(i).getNim() + i);
        }
        Log.e("cek list", "" + listMahasiswa.size());
    }

    private void setAdapter() {
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerviewUserAdapter(this,listMahasiswa);
    }

}