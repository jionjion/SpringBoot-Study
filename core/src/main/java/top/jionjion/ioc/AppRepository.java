package top.jionjion.ioc;

import org.springframework.stereotype.Repository;

/**
 *  @author Jion
 *      持久化类
 */
@Repository
public class AppRepository {

    public void save(){
        System.out.println("Repository 保存了...");
    }
}
