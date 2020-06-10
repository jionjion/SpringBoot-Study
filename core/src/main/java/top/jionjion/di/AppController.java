package top.jionjion.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *  @author Jion
 *      前端控制器
 */
@Controller
public class AppController {

    private AppService appService;

    public AppController() {
    }

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    public void save() {
        System.out.println("Controller 被调用 ...");
        appService.save();
    }
}
