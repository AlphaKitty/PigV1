package com.zyl.pigv1.common.async;

import com.zyl.pigv1.common.async.user.GetUsers;
import com.zyl.pigv1.common.async.user.SaveUser;
import com.zyl.pigv1.service.pojo.User;

public class Async {

    public static GetUsers getUsers() {
        return new GetUsers();
    }

    public static SaveUser saveUser(User user) {
        return new SaveUser(user);
    }
}
