package com.zyl.pigv1.common.async;

import com.zyl.pigv1.common.async.check.GetChecks;
import com.zyl.pigv1.common.async.check.SaveCheck;
import com.zyl.pigv1.common.async.pig.GetPigByCheck;
import com.zyl.pigv1.common.async.user.GetUsers;
import com.zyl.pigv1.common.async.user.SaveUser;
import com.zyl.pigv1.service.pojo.Check;
import com.zyl.pigv1.service.pojo.User;

import java.util.concurrent.Executor;

public class Async {

    public static GetUsers getUsers(User user) {
        return new GetUsers(user);
    }

    public static SaveUser saveUser(User user) {
        return new SaveUser(user);
    }

    public static GetChecks getChecks() {
        return new GetChecks();
    }

    public static SaveCheck saveCheck(Check check) {
        return new SaveCheck(check);
    }

    public static GetPigByCheck getPigByCheck() {
        return new GetPigByCheck();
    }
}
