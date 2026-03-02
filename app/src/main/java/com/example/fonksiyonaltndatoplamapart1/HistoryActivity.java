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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ArrayList<String> islemler=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Button anaButon=findViewById(R.id.anaButon);
        TextView gecmis=findViewById(R.id.gecmisGoster);
        yukle();
        for(String islemim:islemler){
            gecmis.append("\n"+ islemim);
        }

        anaButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    void yukle(){
        SharedPreferences sp=getSharedPreferences("Hesap makinesi veri tutucu",MODE_PRIVATE);
        String veri=sp.getString("hesap-gecmisi","");
        String[] cekilenveri=veri.split(",");
        for(String k:cekilenveri){
            islemler.add(k);
        }
    }
}