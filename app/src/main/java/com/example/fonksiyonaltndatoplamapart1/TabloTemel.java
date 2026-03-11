package com.example.fonksiyonaltndatoplamapart1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gecmis_tablosu")
public class TabloTemel{

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "islem_metni")
    public String islemMetni;

    public TabloTemel(String islemMetni) {
        this.islemMetni = islemMetni;
    }
}