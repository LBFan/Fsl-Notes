package com.fan.designpattern.srp;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2021/11/21 22:13.
 */

public interface IUserBO {

    void setUserID(String userID);
    String getUserID();
    void setPassword(String password);
    String getPassword();
    void setUserName(String userName);
    String getUserName();
}