package top.jionjion.core.ioc;

import org.springframework.stereotype.Service;

/**
 *  @author Jion
 *      业务逻辑类
 */
@Service
public class AppService {

    public void save(){
        System.out.println("Service 保存了...");
    }

}
