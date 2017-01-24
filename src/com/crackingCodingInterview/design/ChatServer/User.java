package com.crackingCodingInterview.design.ChatServer;

import java.util.HashMap;

/**
 * Created by richa on 1/14/17.
 *
 */
public class User {

    private UserStatus status = null;

    private HashMap<Integer, PrivateChat> privateChats;

    private HashMap<Integer, GroupChat> groupChats;

    private HashMap<Integer, AddRequest> receivedAddRequests;

    private HashMap<Integer, AddRequest> sentAddRequests;

    private HashMap<Integer, User> contacts;

    private String fullName;

    public void sendMessageToUser(User user, Message m){

    }

    public void sendMessageToGroupChat(GroupChat chat, Message m){

    }

    public void sendMessageToPrivateChat(PrivateChat chat, Message m){

    }

    public void addContact(User user){

    }

    public void removeContact(User user){

    }

    public void acceptRequest(AddRequest request){

    }

    public void rejectAddRequest(AddRequest request){

    }

    public void sentAddRequest(AddRequest request){

    }
}
