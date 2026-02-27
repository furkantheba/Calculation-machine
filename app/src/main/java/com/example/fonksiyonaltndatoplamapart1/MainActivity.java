package com.example.fonksiyonaltndatoplamapart1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText input1 = findViewById(R.id.numaraInput1);
        EditText input2 = findViewById(R.id.numaraInput2);
        Button butonArti=findViewById(R.id.hesaplaButonArti);
        Button butonEksi=findViewById(R.id.hesaplaButonEksi);
        Button butonBolu=findViewById(R.id.hesaplaButonBolu);
        Button butonCarpi=findViewById(R.id.hesaplaButonCarpi);
        Button clear1=findViewById(R.id.clearButon);
        TextView res = findViewById(R.id.sonucYazisi);
        butonBolu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deger1=input1.getText().toString();
                String deger2=input2.getText().toString();
                if(!(deger1.isEmpty()||deger2.isEmpty())) {

                }
                else{
                    return;
                }
                double sayi1=Double.parseDouble(deger1);
                double sayi2=Double.parseDouble(deger2);
                double sonuc=sayi1/sayi2;
                res.setText("Sonuç: " + sonuc);

            }
        });
        butonArti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deger1=input1.getText().toString();
                String deger2=input2.getText().toString();
                if(!(deger1.isEmpty()||deger2.isEmpty())) {

                }
                else{
                    return;
                }
                double sayi1=Double.parseDouble(deger1);
                double sayi2=Double.parseDouble(deger2);
                double sonuc=sayi1+sayi2;
                res.setText("Sonuç: " + sonuc);

            }
        });
        butonEksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deger1=input1.getText().toString();
                String deger2=input2.getText().toString();
                if(!(deger1.isEmpty()||deger2.isEmpty())) {

                }
                else{
                    return;
                }
                double sayi1=Double.parseDouble(deger1);
                double sayi2=Double.parseDouble(deger2);
                double sonuc=sayi1-sayi2;
                if(sonuc <0){
                    res.setTextColor(Color.parseColor("#000000"));
                }
                else{
                    res.setTextColor(Color.parseColor("#ffffff"));
                }
                res.setText("Sonuç: " + sonuc);

            }
        });
        butonCarpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deger1=input1.getText().toString();
                String deger2=input2.getText().toString();
                if(!(deger1.isEmpty()||deger2.isEmpty())) {

                }
                else{
                    return;
                }
                double sayi1=Double.parseDouble(deger1);
                double sayi2=Double.parseDouble(deger2);
                double sonuc=sayi1*sayi2;
                res.setText("Sonuç: " + sonuc);

            }
        });
        clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setHint("1. sayıyı girin");
                input2.setHint("2. sayıyı girin");
                input1.setText("");
                input2.setText("");
                res.setTextColor(Color.parseColor("#000000"));
                res.setText("Sonuç:");
            }
        });


    }
}