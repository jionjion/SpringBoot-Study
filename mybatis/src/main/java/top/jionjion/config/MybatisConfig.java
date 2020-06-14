package top.jionjion.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *  Mybatis 的配置文件
 * @author Jion
 */
@Configuration
@MapperScan(basePackages = "top.jionjion.mapper")
public class MybatisConfig {

}
