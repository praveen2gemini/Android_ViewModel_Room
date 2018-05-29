package com.mvvmsample.sample.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * @author Praveen on 29/05/18.
 */
@Entity(tableName = "UserTable")
public class User {


    @ColumnInfo(name = "uid")
    private int uid;
    @ColumnInfo(name = "first_name")
    private String userName;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "last_name")
    private String lastName;

    public static User createUser(int uid, String firstName, String lastName) {
        User user = new User();
        user.uid = uid;
        user.userName = firstName;
        user.lastName = lastName;
        return user;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return uid + "_" + userName + "_" + lastName;
    }
}
