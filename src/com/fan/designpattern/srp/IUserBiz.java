package com.fan.designpattern.srp;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2021/11/21 22:15.
 */

public interface IUserBiz {
    boolean changePassword(String oldPassword, String newPassword);
    boolean deleteUser(IUserBO userBO);
    void mapUser(IUserBO userBO);
    boolean addOrg(IUserBO userBO, int orgID);
    boolean addRole(IUserBO userBO, int roleID);
}