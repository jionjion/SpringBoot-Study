package top.jionjion.web.bean;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author Jion
 */
class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setId(1);
        user.setAddress("上海");
        user.setUsername("username");
        user.setPassword("password");
        user.setBirthday(new Date());
        System.out.println(user);
        System.out.println(user.getId());
        System.out.println(user.getAddress());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
    }
}