package top.jionjion.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  @author Jion
 *      业务逻辑类
 */
@Service
public class AppService {

    private AppRepository appRepository;

    public AppService() {
    }

    @Autowired
    public AppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public void setAppRepository(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public void save(){
        System.out.println("Service 被调用 ...");
        appRepository.save();
    }
}
