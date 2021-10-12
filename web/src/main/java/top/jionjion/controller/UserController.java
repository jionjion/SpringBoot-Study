package top.jionjion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.jionjion.bean.User;
import top.jionjion.dto.ResultMessage;
import top.jionjion.exception.UserException;
import top.jionjion.service.UserService;

import java.util.List;

/**
 * @author Jion
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询全部
     * URL: http://localhost:8080/MicroServices/user/users
     */
    @GetMapping(value = "/users")
    public List<User> userList() {
        return userService.findAll();
    }

    /**
     * 新增一个
     * URL: http://localhost:8080/MicroServices/user/user
     */
    @PostMapping(value = "/user")
    public ResultMessage<User> userSave(User user, BindingResult result) {
        // @Valid表示进行对象参数验证	BindingResult:为参数的验证结果

        // 封装的结果对象
        ResultMessage<User> resultMessage = new ResultMessage<>();

        if (result.hasErrors()) {
            //如果有错误,则返回bean中的定义
            String message = result.getFieldError().getDefaultMessage();

            return new ResultMessage<>(400, message);
        }
        //传入User对象,前台只需要传递对象的属性名即可
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        User userReturn = userService.save(user);
        return new ResultMessage<>(200, "成功", userReturn);
    }

    /**
     *  查询一个
     *  URL: http://localhost:8080/MicroServices/user/users/1
     */
    @GetMapping(value = "/users/{id}")
    public User userGet(@PathVariable("id") Integer id) {

        return userService.findOne(id);
    }

    /**
     *  更新一个
     *  URL: http://localhost:8080/MicroServices/user/users/3
     */
    @PutMapping(value = "/users/{id}")
    public User userUpdate(@PathVariable("id") Integer id,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password) {

        User user = new User();
        //保存主键
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        //当保存主键一致时,为更新操作
        return userService.save(user);
    }

    /**
     *  删除一个
     *  URL: http://localhost:8080/MicroServices/user/users/3
     */
    @DeleteMapping(value = "/users/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }


    /**
     *  自定义查询,通过姓名查询用户
     *  URL: http://localhost:8080/MicroServices/user/users/username/Jion
     */
    @GetMapping(value = "/users/username/{username}")
    public List<User> userGetByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    /**
     *  统一异常捕获.
     *  将service层抛出的异常,dao层抛出的异常进行统一向外抛出,交由ExceptionHandle类进行包装向前台传递
     *  这里模拟包含的类进行的异常抛出
     *  URL:http://localhost:8080/MicroServices/user/error/2			调用第二种异常,并返回
     */
    @GetMapping(value = "/error/{code}")
    public void errorCodeHandler(@PathVariable("code") String code) {
        String error1 = "1";
        String error2 = "2";

        if (error1.equals(code)) {
            //抛出自定义的异常,测试统一异常处理
            throw new UserException(500, "这是一个错误...");
        }
        if (error2.equals(code)) {
            throw new UserException(500, "这是另一个错误...");
        }
        throw new RuntimeException("其他错误...");
    }
}