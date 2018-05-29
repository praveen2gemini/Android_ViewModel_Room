package com.mvvmsample.sample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * @author Praveen on 29/05/18.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM UserTable")
    LiveData<List<User>> getUsers();

    @Query("SELECT * FROM UserTable WHERE uid IN (:userIds)")
    LiveData<List<User>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM UserTable WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllUsers(User... users);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM UserTable")
    void deleteAll();


}
