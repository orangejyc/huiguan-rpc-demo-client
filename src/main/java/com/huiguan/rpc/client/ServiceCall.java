package com.huiguan.rpc.client;

import com.huiguan.rpc.api.entity.User;
import com.huiguan.rpc.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ansoya on 2017/4/27.
 */
@Service
public class ServiceCall {

    @Autowired(required=false)
    private UserService userService;
    public User getUser(User user){
        return userService.getUser(user);
    }
}
