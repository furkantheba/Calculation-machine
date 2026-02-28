package com.example.fonksiyonaltndatoplamapart1;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    String islem;
    TextView res;
    EditText input1,input2;
    ArrayList<String> islemler = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.numaraInput1);
        input2 = findViewById(R.id.numaraInput2);
        Button butonArti=findViewById(R.id.hesaplaButonArti);
        Button butonEksi=findViewById(R.id.hesaplaButonEksi);
        Button butonBolu=findViewById(R.id.hesaplaButonBolu);
        Button butonCarpi=findViewById(R.id.hesaplaButonCarpi);
        Button clear1=findViewById(R.id.clearButon);
        Button butonGecmis=findViewById(R.id.gecmisButon);
        res = findViewById(R.id.sonucYazisi);

        butonBolu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islem="/";
                islemYap(islem);
            }
        });
        butonArti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islem="+";
                islemYap(islem);


            }
        });
        butonEksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islem="-";
                islemYap(islem);


            }
        });
        butonCarpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islem="x";
                islemYap(islem);

            }
        });
        clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setHint(getText(R.string.sayi1gir));
                input2.setHint(getText(R.string.sayi2gir));
                input1.setText("");
                input2.setText("");
                res.setTextColor(Color.parseColor("#000000"));
                res.setText(getText(R.string.sonuc_yazisi));
                islemler.clear();
            }
        });
        butonGecmis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(MainActivity.this,HistoryActivity.class);
                historyIntent.putStringArrayListExtra("liste",islemler);
                startActivity(historyIntent);
            }
        });


    }
    void islemYap(String islem){
        String deger1=input1.getText().toString();
        String deger2=input2.getText().toString();
        if(!(deger1.isEmpty()||deger2.isEmpty())) {

        }
        else{
            return;
        }
        double sayi1=Double.parseDouble(deger1);
        double sayi2=Double.parseDouble(deger2);
        double sonuc=0;
        if(islem.equals("+")){
            sonuc=sayi1+sayi2;
        }
        if(islem.equals("-")){
            sonuc=sayi1-sayi2;
        }
        if(islem.equals("x")){
            sonuc=sayi1*sayi2;
        }
        if(islem.equals("/")){
            if(sayi2==0){
                Toast.makeText(MainActivity.this,getText(R.string.hata_sifira_bolme),Toast.LENGTH_SHORT).show();
                return;
            }
            sonuc=sayi1/sayi2;
        }
        if(sonuc <0){
            res.setTextColor(Color.parseColor("#000000"));
        }
        else{
            res.setTextColor(Color.parseColor("#ffffff"));
        }
        res.setText(getString(R.string.sonuc_yazisi)+sonuc);
        String islemim=sayi1+" "+islem+" "+sayi2+" = "+sonuc;
        islemler.add(islemim);

    }
}