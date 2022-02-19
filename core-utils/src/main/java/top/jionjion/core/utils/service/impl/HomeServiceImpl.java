package top.jionjion.core.utils.service.impl;

import org.springframework.stereotype.Service;
import top.jionjion.core.utils.service.HomeService;

/**
 * 接口实现类
 *
 * @author Jion
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public void hello(String name){
        System.out.println("Hello ..." + name);
    }
}
