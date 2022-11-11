package com.example.applicationactivity.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationactivity.R;
import com.example.applicationactivity.room.Mahasiswa;

import java.util.List;

public class RecyclerviewUserAdapter extends RecyclerView.Adapter<RecyclerviewUserAdapter.MyViewHolder> {
    private Context context;
    private List<Mahasiswa> myList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNama;
        public TextView tvNim;
        public TextView tvKejuruan;
        public TextView tvAlamat;

        public MyViewHolder(@Nullable View itemView) {
            super(itemView);
            this.tvNama = itemView.findViewById(R.id.tvNama);
            this.tvNim = itemView.findViewById(R.id.tvNim);
            this.tvKejuruan = itemView.findViewById(R.id.tvKejuruan);
            this.tvAlamat = itemView.findViewById(R.id.tvAlamat);
        }
    }

    public RecyclerviewUserAdapter(Context context, List<Mahasiswa> myList) {
        this.context = context;
        this.myList = myList;
    }

    @NonNull
    @Override
    public RecyclerviewUserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewUserAdapter.MyViewHolder holder, int position) {
        final Mahasiswa album = myList.get(position);
        holder.tvNama.setText(album.getNama());
        holder.tvNim.setText(album.getNim());
        holder.tvKejuruan.setText(album.getKejuruan());
        holder.tvAlamat.setText(album.getAlamat());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


}
