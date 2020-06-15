package com.example.restservice.repository;

import com.example.restservice.models.RegisterRequest;
import com.example.restservice.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    public UserRepository() {
        this.createUserList();
    }
    public User addUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setId(userList.size() + 1);
        user.setPassword(registerRequest.getPassword());
        userList.add(user);
        return user;
    }
    /*functions to mock data*/
    private List<User> createUserList() {
        for (int i = 1; i<=5; i++) {
            User u = new User();
            u.setId(i);
            u.setEmail("user"+i+"@mail.com");
            u.setPassword("pwd"+i);
            userList.add(u);
        }
        return userList;
    }

    public User getUserByEmail(String email) throws Exception {
        for (User u: userList) {
            if (u.getEmail().equals(email))
                return u;
        }
        throw new Exception("User Not Found");
    }

    public boolean checkUserForEmailExists(String email) throws Exception {
        for (User u: userList) {
            if (u.getEmail().equals(email))
                return true;
        }
        return false;
    }

    public List<User> getUserList() {
        return userList;
    }
}
