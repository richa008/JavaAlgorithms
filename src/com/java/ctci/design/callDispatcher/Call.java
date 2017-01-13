package com.java.ctci.design.callDispatcher;

/**
 * Created by richa on 1/12/17.
 *
 */
public class Call {

    Employee handler;

    boolean callSatisfied;

    public void setHandler(Employee employee){
        handler = employee;
    }

    public void disconnect(){

    }
}
