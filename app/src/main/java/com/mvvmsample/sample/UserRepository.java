package com.mvvmsample.sample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.mvvmsample.sample.dao.User;
import com.mvvmsample.sample.dao.UserDao;
import com.mvvmsample.sample.dao.UserDatabase;

import java.util.List;

/**
 * @author Praveen on 30/05/18.
 */
public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        userDao = db.userDao();
        allUsers = userDao.getUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(@NonNull User user) {
        new InsertAsyncTask(userDao).execute(user);
    }

    public void deleteAllUsers() {
        new DeleteAsyncTask(userDao).execute();
    }

    public static class InsertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        public InsertAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insertAllUsers(users[0]);
            return null;
        }
    }

    public static class DeleteAsyncTask extends AsyncTask<Void, Void, Void> {

        private UserDao userDao;

        public DeleteAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteAll();
            return null;
        }
    }
}
