package com.example.fonksiyonaltndatoplamapart1;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.fonksiyonaltndatoplamapart1.TabloDao;

import com.example.fonksiyonaltndatoplamapart1.TabloTemel;
import com.example.fonksiyonaltndatoplamapart1.TabloDao;



@Database(entities = {TabloTemel.class}, version = 1)
public abstract class Veritabani extends RoomDatabase {

    public abstract TabloDao tabloDao();
}