package top.jionjion.web.service;

import org.springframework.stereotype.Service;
import top.jionjion.web.bean.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Jion
 */
@Service
public class UserService {

    /**
     * 模拟数据
     */
    private final List<User> usersList = new ArrayList<>();

    public UserService() {
        super();
        usersList.add(new User(1, "Jion", "123456", "HeNan",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));
        usersList.add(new User(2, "Ber", "123457", "ShangHai",
                new GregorianCalendar(2018, Calendar.FEBRUARY, 2).getTime()));
        usersList.add(new User(3, "Cher", "123458", "BeiJin",
                new GregorianCalendar(2019, Calendar.MARCH, 3).getTime()));
        usersList.add(new User(4, "Eor", "123459", "HeNan",
                new GregorianCalendar(2019, Calendar.APRIL, 4).getTime()));
    }


    /**
     * 查询全部
     */
    public List<User> findAll() {

        return usersList;
    }

    /**
     * 保存一个
     */
    public User save(User user) {
        usersList.add(user);
        return user;
    }

    /**
     * 查询一个
     */
    public User findOne(Integer id) {
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * 通过姓名查询
     */
    public List<User> findByUsername(String username) {
        List<User> list = new ArrayList<>();
        for (User user : usersList) {
            if (user.getUsername().equals(username)) {
                list.add(user);
            }
        }
        return list;
    }

    /**
     * 删除一个
     */
    public void delete(Integer id) {
        usersList.removeIf(user -> user.getId().equals(id));
    }
}
