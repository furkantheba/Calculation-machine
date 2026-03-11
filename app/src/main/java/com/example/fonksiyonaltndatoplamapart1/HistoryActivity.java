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
import androidx.room.Room;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    Veritabani vt;
    String metin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Button anaButon=findViewById(R.id.anaButon);
        TextView gecmis=findViewById(R.id.gecmisGoster);
        vt = Room.databaseBuilder(getApplicationContext(), Veritabani.class, "HesapMakinesiDB").allowMainThreadQueries().build();
        List<TabloTemel> tumGecmis = vt.tabloDao().getir();
        StringBuilder sb=new StringBuilder();
        sb.append("Gecmis: \n");
        for (TabloTemel satir : tumGecmis) {
            sb.append(satir.islemMetni).append("\n");
        }
        gecmis.setText(sb.toString());
        anaButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}