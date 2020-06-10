package top.jionjion.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.jionjion.bean.User;

import java.util.*;

/**
 * @author Jion
 */
@Service
public class UserService {

    /** 模拟数据 */
    private List<User> usersList = new ArrayList<>();

    public UserService(){
        super();
        usersList.add(new User(1, "Jion", "123456", "HeNan",
                        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));
        usersList.add(new User(2, "Ber", "123456", "ShangHai",
                        new GregorianCalendar(2018, Calendar.FEBRUARY, 2).getTime()));
        usersList.add(new User(3, "Cher", "123456", "BeiJing",
                        new GregorianCalendar(2019, Calendar.MARCH,3).getTime()));
        usersList.add(new User(4, "Eor", "123456", "HeNan",
                        new GregorianCalendar(2019, Calendar.APRIL, 4).getTime()));
    }


    /** 查询全部 */
    public List<User> findAll() {

        return usersList;
    }

    /** 保存一个 */
    public User save(User user) {
        usersList.add(user);
        return user;
    }

    /** 查询一个 */
    public User findOne(Integer id) {
        for (User user : usersList){
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    /** 通过姓名查询 */
    public List<User> findByUsername(String username) {
        List<User> list = new ArrayList<>();
        for (User user : usersList){
            if(user.getUsername().equals(username)){
                list.add(user);
            }
        }
        return list;
    }

    /** 删除一个 */
    public void delete(Integer id) {
        for (User user : usersList){
            if (user.getId().equals(id)){
                usersList.remove(user);
            }
        }
    }
}
