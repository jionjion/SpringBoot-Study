package top.jionjion.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 代码生成器
 *
 * @author Jion
 */
public class CodeGenerator {

    /**
     * 读取控制台内容
     *
     * @param tip 提示内容
     * @return 键入的文本
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 生成代码主函数
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();


        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/springboot_study?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
        // dataSourceConfig.setSchemaName("public");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        mpg.setDataSource(dataSourceConfig);


        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取项目目录
        String projectPath = System.getProperty("user.dir");
        // 设置生成目录, 取代 /src/main/java 目录
        gc.setOutputDir(projectPath + "/src/main/auto");
        // 设置
        gc.setAuthor("Jion");
        // 生成完成后是否自动打开文件夹窗口
        gc.setOpen(true);
        // 生成 service 层的文件名.
        gc.setServiceName("I%sService");
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        // 设置主键生成策略
        gc.setIdType(IdType.AUTO);
        // 设置日期类型 java.util.date
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);


        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        // 模块名 test
        packageConfig.setModuleName(scanner("模块名"));
        // 包名
        packageConfig.setParent("top.jionjion.ant");
        // 数据库表对象所在包名
        packageConfig.setEntity("dto");
        // mapper 接口所在包名
        packageConfig.setMapper("mapper");
        // service 层所在包名
        packageConfig.setService("service");
        // service 实现类所在包名
        packageConfig.setServiceImpl("service.impl");
        // controller 层所在包名
        packageConfig.setController("controller");
        // xml 文件命名
        packageConfig.setXml("mapper.xml");
        mpg.setPackageInfo(packageConfig);


        // 生成策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名映射到类名 => 下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 字段名映射到属性名 => 下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 设置所有实体类的公共父类
        strategy.setSuperEntityClass(Object.class);
        // 是否支持 Lombok
        strategy.setEntityLombokModel(true);
        // 控制器是否为添加 @RestController
        strategy.setRestControllerStyle(true);
        // 控制器中 @RequestMapping 路径属性 => 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 设置所有控制器类的公共父类
        strategy.setSuperControllerClass("java.lang.Object");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        // 设置逻辑删除字段 @TableLogic
        strategy.setLogicDeleteFieldName("deleted");
        // 设置乐观锁字段 @Version
        strategy.setVersionFieldName("version");
        // 自动填充设置, 添加 @TableField 注解
        TableFill createDate = new TableFill("create_date", FieldFill.INSERT);
        TableFill modifyDate = new TableFill("create_date", FieldFill.INSERT_UPDATE);
        strategy.setTableFillList(Arrays.asList(createDate, modifyDate));
        // 设置扫描生成代码的表名
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 设置表的前缀
        strategy.setTablePrefix("");
        mpg.setStrategy(strategy);


        // 模板引擎选择,默认
        mpg.setTemplateEngine(new VelocityTemplateEngine());


        // 自动生成代码执行..
        mpg.execute();
    }

}