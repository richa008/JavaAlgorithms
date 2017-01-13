package com.java.ctci.design.CallCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richa on 1/12/17.
 *
 */
public class CallCenter {

    /**
     *  employees[0] = respondents
     *  employees[1] = managers
     *  employees[2] = directors
     */
    private List<List<Employee>> employees;

    private ArrayList<Call> callQueues;

    public Employee getAvailableEmployee(Rank rank){
        return null;
    }

    public void dispatchCall(Call call){
        Employee emp = getAvailableEmployee(Rank.RESPONDENT);
        if(emp == null || !emp.canHandleCall){
            emp = getAvailableEmployee(Rank.MANAGER);
            if(emp == null || !emp.canHandleCall){
                emp = getAvailableEmployee(Rank.DIRECTOR);
            }
        }
        if(emp == null){
            return;
        }

        emp.receiveCall();
        call.setHandler(emp);
    }

}
