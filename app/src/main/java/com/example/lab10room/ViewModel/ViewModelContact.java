package com.example.lab10room.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lab10room.Repository.ContactRepository;
import com.example.lab10room.Room.Entity.Contact;

import java.util.List;

public class ViewModelContact extends AndroidViewModel {
    ContactRepository contactRepository;
    public LiveData<List<Contact>> listLiveData;

    public ViewModelContact(@NonNull Application application) {
        super(application);
        contactRepository = new ContactRepository(application.getApplicationContext());
        listLiveData = contactRepository.getAllLiveListData();
    }

    public LiveData<List<Contact>> getAllData(){
        return listLiveData;
    }

    public void insert(Contact contact){contactRepository.insertContact(contact);}
    public void update(Contact contact){contactRepository.updateContact(contact);}
    public void delete(Contact contact){contactRepository.deleteContact(contact);}


}
