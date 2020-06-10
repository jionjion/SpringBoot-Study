package top.jionjion.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *  @author Jion
 *      持久化类
 */
@Repository
public class AppRepository {


    private AppConfig appConfig;

    public AppRepository() {
    }

    @Autowired
    public AppRepository(AppConfig appConfig) {
        this.appConfig = appConfig;
    }


    public void save(){
        System.out.println("Repository 被调用 ...");
        appConfig.save();
    }
}
