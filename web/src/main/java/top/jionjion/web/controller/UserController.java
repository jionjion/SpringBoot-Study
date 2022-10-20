package top.jionjion.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.jionjion.web.advice.UserControllerRequestAdvice;
import top.jionjion.web.bean.User;
import top.jionjion.web.dto.ResultMessage;
import top.jionjion.web.exception.UserException;
import top.jionjion.web.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author Jion
 */

@RestController
@RequestMapping("/user")
public class UserController {

    final Logger logger = Logger.getLogger(UserControllerRequestAdvice.class.getName());

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 查询全部
     * URL: <a href="http://localhost:8080/user/users">...</a>
     */
    @GetMapping(value = "/users")
    public List<User> userList() {
        List<User> users = userService.findAll();
        logger.info(() -> "userList: " + users.toString());
        return users;
    }

    /**
     * 新增一个
     * URL: <a href="http://localhost:8080/user/user">...</a>
     */
    @PostMapping(value = "/user")
    public ResultMessage<User> userSave(@RequestBody User user, BindingResult result) {
        // @Valid表示进行对象参数验证	BindingResult:为参数的验证结果

        if (result.hasErrors()) {
            //如果有错误,则返回bean中的定义
            String message = Objects.requireNonNull(result.getFieldError()).getDefaultMessage();

            return new ResultMessage<>(400, message);
        }
        //传入User对象,前台只需要传递对象的属性名即可
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        User userReturn = userService.save(user);
        // 封装的结果对象
        return new ResultMessage<>(200, "成功", userReturn);
    }

    /**
     * 查询一个
     * URL: <a href="http://localhost:8080/user/users/1">...</a>
     */
    @GetMapping(value = "/users/{id}")
    public User userGet(@PathVariable("id") Integer id) {
        User user = userService.findOne(id);
        logger.info(() -> "userGet: " + user.toString());
        return user;
    }

    /**
     * 更新一个
     * URL: <a href="http://localhost:8080/user/users/3">...</a>
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
     * 删除一个
     * URL: <a href="http://localhost:8080/user/users/3">...</a>
     */
    @DeleteMapping(value = "/users/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }


    /**
     * 自定义查询,通过姓名查询用户
     * URL: <a href="http://localhost:8080/user/users/username/Jion">...</a>
     */
    @GetMapping(value = "/users/username/{username}")
    public List<User> userGetByUsername(@PathVariable("username") String username) {
        List<User> users = userService.findByUsername(username);
        logger.info(() -> "userGetByUsername: " + users.toString());
        return users;
    }

    /**
     * 统一异常捕获.
     * 将service层抛出的异常,dao层抛出的异常进行统一向外抛出,交由ExceptionHandle类进行包装向前台传递
     * 这里模拟包含的类进行的异常抛出
     * URL:<a href="http://localhost:8080/user/error/2">...</a>			调用第二种异常,并返回
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
    }
}