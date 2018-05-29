package com.mvvmsample.sample.dao;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * @author Praveen on 29/05/18.
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase INSTANCE;
    private static UserDatabase.Callback sRoomDatabaseCallback =
            new UserDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
//                    new PopulateDbAsync(INSTANCE).execute(); //It will add dummy data for first time.
                }
            };

    public static UserDatabase getDatabase(@NonNull final Context context) {
        if (INSTANCE == null) {
            synchronized (UserDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.
                            databaseBuilder(context.getApplicationContext(), UserDatabase.class, "UserDatabase")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract UserDao userDao();

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDao mDao;

        PopulateDbAsync(UserDatabase db) {
            mDao = db.userDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            for (int i = 0; i <= 10; i++) {
                User user = User.createUser((100 + i), "PraveenKumar".concat("_" + i), "Sugumaran".concat("_" + i));
                mDao.insertAllUsers(user);
            }
            return null;
        }
    }
}
