package top.jionjion.ioc;

import org.springframework.stereotype.Controller;

/**
 *  @author Jion
 *      前端控制器
 */
@Controller
public class AppController {

    public void save(){
        System.out.println("Controller 保存了...");
    }
}
