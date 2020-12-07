package com.example.lab10room.Room.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab10room.Room.Entity.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM Contact")
    LiveData<List<Contact>> getAllContacts();

    @Query("SELECT * FROM Contact WHERE name =:name")
    Contact getContactById(String name);

    @Insert
    void insert(Contact contact);

    @Delete
    void delete(Contact contact);

    @Update
    void update(Contact contact);

 }
