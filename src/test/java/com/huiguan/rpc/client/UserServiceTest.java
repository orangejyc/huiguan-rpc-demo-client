package com.huiguan.rpc.client;

import com.huiguan.rpc.api.entity.User;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ansoya on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
public class UserServiceTest {

    @Autowired
    private ServiceCall serviceCall;

    public void test(){

        User user=new User();
        user.setName("name");
        User result=serviceCall.getUser(user);
        Assert.assertNotNull(user);
    }
}
