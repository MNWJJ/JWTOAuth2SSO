package com.chris.sso.demo.test;

import com.chris.sso.demo.user.dao.UserRepository;
import com.chris.sso.demo.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void baseTest() throws Exception {
        User user = new User();
        user.setName("Jay");
        user.setPassword("123456");
        userRepository.save(user);
//        userRepository.delete(user);
//        userRepository.findOne(1);
    }

}
