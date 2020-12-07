package com.example.lab10room.Repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

import com.example.lab10room.Room.Dao.ContactDao;
import com.example.lab10room.Room.DatabaseRoom.ContactDataBaseRoom;
import com.example.lab10room.Room.Entity.Contact;

import java.util.List;

public class ContactRepository {
    LiveData<List<Contact>> listLiveContact;
    ContactDataBaseRoom dataBaseRoom;
    ContactDao contactDao;

    public ContactRepository(Context context){
        dataBaseRoom = ContactDataBaseRoom.getDb(context);
        contactDao = dataBaseRoom.getContactDao();
        listLiveContact = contactDao.getAllContacts();
    }

    public LiveData<List<Contact>> getAllLiveListData(){return listLiveContact;}

    public void insertContact(Contact contact){new InsertAsyncTask(contactDao).execute(contact);}
    public void updateContact(Contact contact){new UpdateAsyncTask(contactDao).execute(contact);}
    public void deleteContact(Contact contact){new DeleteAsyncTask(contactDao).execute(contact);}

    private static class InsertAsyncTask extends AsyncTask<Contact,Void,Void>{

        ContactDao contactDao;

        InsertAsyncTask(ContactDao contactDao){
            this.contactDao = contactDao;
        }

        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDao.insert(contacts[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Contact,Void,Void>{

        ContactDao contactDao;

        UpdateAsyncTask(ContactDao contactDao){
            this.contactDao = contactDao;
        }

        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDao.insert(contacts[0]);
            return null;
        }
    }


    private static class DeleteAsyncTask extends AsyncTask<Contact,Void,Void>{

        ContactDao contactDao;

        DeleteAsyncTask(ContactDao contactDao){
            this.contactDao = contactDao;
        }

        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDao.insert(contacts[0]);
            return null;
        }
    }

}
