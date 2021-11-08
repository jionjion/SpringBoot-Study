package top.jionjion.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.jionjion.mybatis.config.MybatisConfig;

@SpringBootTest
@Slf4j
class MybatisApplicationTest {

	@Autowired
	MybatisConfig config;

	@Test
	void contextLoads() {
		log.info("容器启动成功!");
	}

	@Test
	void getBean(){
		Assert.notNull(config, "配置类注入失败!");
		log.info("测试成功");
	}
}
