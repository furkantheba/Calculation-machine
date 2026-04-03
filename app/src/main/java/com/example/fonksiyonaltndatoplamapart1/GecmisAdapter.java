package com.example.fonksiyonaltndatoplamapart1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;



public class GecmisAdapter extends RecyclerView.Adapter<GecmisAdapter.GecmisViewHolder> {

    private List<TabloTemel> veriListesi;

    public GecmisAdapter(List<TabloTemel> liste) {
        this.veriListesi = liste;
    }

    @NonNull
    @Override
    public GecmisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gecmis_item, parent, false);
        return new GecmisViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GecmisViewHolder holder, int position) {
        TabloTemel suankiVeri = veriListesi.get(position);
        holder.txtIslem.setText(suankiVeri.islemMetni);
        holder.btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veritabani db = Room.databaseBuilder(v.getContext(), Veritabani.class, "HesapMakinesiDB").allowMainThreadQueries().build();
                db.tabloDao().silSatır(suankiVeri);
                veriListesi.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, veriListesi.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (veriListesi != null) ? veriListesi.size() : 0;
    }


    public static class GecmisViewHolder extends RecyclerView.ViewHolder {
        TextView txtIslem;
        ImageView btnSil;

        public GecmisViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIslem = itemView.findViewById(R.id.txtIslemSatir);
            btnSil = itemView.findViewById(R.id.imgSil);
        }
    }
}