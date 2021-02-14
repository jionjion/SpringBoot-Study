package top.jionjion.ioc.annotation.factory;

import org.springframework.stereotype.Component;

/**
 * 交给容器, 在Bean实例化时,拦截代理
 *
 * @author Jion
 * @see PigInstantiationAwareBeanPostProcessor
 */
@Component
public class Pig extends Animal {

    @Override
    String getName() {
        return "我是猪... ";
    }
}
