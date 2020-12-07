package com.example.lab10room.Room.DatabaseRoom;

import android.app.Application;
import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lab10room.Room.Dao.ContactDao;
import com.example.lab10room.Room.Entity.Contact;

@Database(entities = Contact.class,
        version = 1,exportSchema = false)
public abstract class ContactDataBaseRoom extends RoomDatabase {
    public abstract ContactDao getContactDao();
    private static ContactDataBaseRoom INSTANCE;
    public static ContactDataBaseRoom getDb(Context context){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    ContactDataBaseRoom.class,"database")
                    .build();
            return INSTANCE;
    }
}
