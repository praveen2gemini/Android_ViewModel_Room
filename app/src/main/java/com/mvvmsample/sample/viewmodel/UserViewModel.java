package com.mvvmsample.sample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.mvvmsample.sample.UserRepository;
import com.mvvmsample.sample.dao.User;

import java.util.List;

/**
 * @author Praveen on 30/05/18.
 */
public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    private LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(User user) {
        userRepository.insert(user);
    }

    public void deleteAllUsers() {
        userRepository.deleteAllUsers();
    }
}
