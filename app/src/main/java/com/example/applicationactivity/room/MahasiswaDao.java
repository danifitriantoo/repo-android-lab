package com.example.applicationactivity.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MahasiswaDao {

    String queryGetAll = "SELECT * FROM mahasiswa";

    @Query(queryGetAll)
    List<Mahasiswa> getAll();

    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama ")
    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa mahasiswa);

    @Delete
    public void deleteUsers(Mahasiswa users);

    @Update
    public void updateAll(Mahasiswa mahasiswa);

    @Delete
    public void deteleAll(Mahasiswa user1, Mahasiswa user2);

}
