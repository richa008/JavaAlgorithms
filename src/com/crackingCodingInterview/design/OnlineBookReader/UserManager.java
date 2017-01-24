package com.crackingCodingInterview.design.OnlineBookReader;

import java.util.HashMap;

/**
 * Created by richa on 1/13/17.
 *
 */
public class UserManager {

    private HashMap<Integer, User> users;

    public void addUser(User user){

    }

    public User removeUser(Integer userId){
        return null;
    }

    public User searchUser(Integer userId){
        return users.get(userId);
    }
}
