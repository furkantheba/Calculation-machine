package com.example.fonksiyonaltndatoplamapart1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private Veritabani db;
    private RecyclerView recyclerView;
    private GecmisAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Button AnaButon = findViewById(R.id.anaButon);

        recyclerView = findViewById(R.id.rv_gecmis_listesi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = Room.databaseBuilder(getApplicationContext(), Veritabani.class, "HesapMakinesiDB").allowMainThreadQueries().build();

        List<TabloTemel> veriListesi = db.tabloDao().getir();

        adapter = new GecmisAdapter(veriListesi);

        recyclerView.setAdapter(adapter);
        AnaButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}