package com.fan.designpattern.srp;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2021/11/21 22:18.
 */

public class Main {
    public static void main(String[] args) {
        IUserInfo userInfo = new UserInfo();
        // 我要赋值了，就认为它是一个纯粹的BO
        IUserBO userBO = (IUserBO) userInfo;
        userBO.setPassword("abc");
        // 我要执行动作了，我就认为是一个业务逻辑类
        IUserBiz userBiz = (IUserBiz) userInfo;
        userBiz.deleteUser(userBO);
    }
}

