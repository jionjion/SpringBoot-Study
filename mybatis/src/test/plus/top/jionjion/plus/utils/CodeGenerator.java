package top.jionjion.plus.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;

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
        // 连接信息
        String url = "jdbc:mysql://127.0.0.1:3306/springboot_study?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(url, username, password)
                .schema("public").dbQuery(new MySqlQuery()).typeConvert(MySqlTypeConvert.INSTANCE).build();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                //设置生成目录, 获取项目目录文件夹 + /src/main/java 目录
                .outputDir(System.getProperty("user.dir") + "/src/main/auto")
                // 设置
                .author("Jion")
                // 生成完成后是否自动打开文件夹窗口
                .disableOpenDir()
                // 实体属性 Swagger2 注解
                .enableSwagger()
                // 设置日期类型 java.util.date
                .dateType(DateType.ONLY_DATE)
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                // 模块名 test
                .moduleName(scanner("test"))
                // 包名
                .parent("top.jionjion.ant")
                // 数据库表对象所在包名
                .entity("dto")
                // mapper 接口所在包名
                .mapper("mapper")
                // service 层所在包名
                .service("service")
                // service 实现类所在包名
                .serviceImpl("service.impl")
                // controller 层所在包名
                .controller("controller")
                // xml 文件命名
                .xml("mapper.xml")
                .build();

        // 生成策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                // 设置扫描生成代码的表名
                .addInclude(scanner("表名，多个英文逗号分割").split(","))
                // 设置表的前缀
                .addTablePrefix("")
                // 实体类配置
                .entityBuilder()
                // 表名映射到类名 => 下划线转驼峰
                .naming(NamingStrategy.underline_to_camel)
                // 字段名映射到属性名 => 下划线转驼峰
                .columnNaming(NamingStrategy.underline_to_camel)
                // 设置主键生成策略
                .idType(IdType.AUTO)
                // 是否支持 Lombok
                .enableLombok()
                // 设置所有实体类的公共父类
                .superClass(Object.class)
                // 写于父类中的公共字段
                .addSuperEntityColumns("id")
                // 自动填充设置, 添加 @TableField 注解
                .addTableFills(new Column("create_date", FieldFill.INSERT),
                        new Column("create_date", FieldFill.INSERT_UPDATE))
                // 设置逻辑删除字段 @TableLogic
                .logicDeletePropertyName("deleted")
                .logicDeleteColumnName("deleted")
                // 设置乐观锁字段 @Version
                .versionPropertyName("version")
                .versionColumnName("version")
                // 前端控制器
                .controllerBuilder()
                // 设置所有控制器类的公共父类
                .superClass("java.lang.Object")
                // 控制器是否为添加 @RestController
                .enableRestStyle()
                // 控制器中 @RequestMapping 路径属性 => 驼峰转连字符
                .enableHyphenStyle()
                .build();

        // 代码生成器配置
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig)
                .global(globalConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig);

        // 自动生成代码执行..
        autoGenerator.execute();
    }

}