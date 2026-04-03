package com.example.fonksiyonaltndatoplamapart1;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TabloTemel.class}, version = 1)
public abstract class Veritabani extends RoomDatabase {


    public abstract TabloDao tabloDao();
}