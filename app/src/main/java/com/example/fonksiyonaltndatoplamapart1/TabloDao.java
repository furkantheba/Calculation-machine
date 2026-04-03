package com.example.fonksiyonaltndatoplamapart1;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fonksiyonaltndatoplamapart1.TabloTemel;

import java.util.List;

@Dao
public interface TabloDao {

    @Insert
    void ekle(TabloTemel yeniKayit);

    @Query("SELECT * FROM gecmis_tablosu")
    List<TabloTemel> getir();

    @Query("DELETE FROM gecmis_tablosu")
    void sil();
    @Delete
    void silSatır(TabloTemel tablo);
}