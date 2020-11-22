package top.jionjion.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoggingApplicationTests {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        logger.error("日志级别: {}, {}", "错误", "error");
        logger.warn("日志级别: {}, {}", "警告", "warn");
        logger.info("日志级别: {}, {}", "信息", "info");
        logger.debug("日志级别: {}, {}", "调试", "debug");
        logger.trace("日志级别: {}, {}", "堆栈", "trace");
    }
}

/*
日志配置
日志配置
<conf iguration scan="true" scanPeriod="60 seconds" debug="false'l />
<conf字形扫描=“真”扫描周期=“60秒”调试=“false‘l/>
◆scan:当设置为true时配置文件若发生改变 将会重新加载
扫描：当设置为真时配置文件若发生改变将会重新加载
◆scanPeriod:扫描时间间隔, 若没给出时间单位默认为毫秒
扫描周期：扫描时间间隔，若没给出时间单位默认为毫秒
◆debug:若设置 为true,将打印出logback内部日志信息
调试：若设置为true，将打印出Logback内部日志信息

configuration子节点
◆contextName: 上下文名称
◆property:属性配置
◆appender:格式化日志输出
◆root:全局 日志输出设置
◆logger:具体包或子类输出设置


configuration_上下文及属性配置
kcontex tName>demo</ contextName>
◆contextName:用来区分不同应用程序的记录默认为default
<property name="L0G_ PATH" value="logs"/>
◆name:变量名称value:变量值
<property resource=' app Lication. properties”/>
<property name="L0G_ PATH" va lue=" ${ logging. path:-${user。home}/ $
{spr ing. application. name}/ logs}"/>


常用pattern介绍
◆logger {length}:输出日志的logger名,可有一个整形参数 ,功
能是缩短logger名
◆contextName|cn:上下文名称
◆date {pattern}:输出日志的打印时间,模式语法与
java.text.SimpleDateFormat 兼容
◆p/le/level:日志级别

◆M/method:输出 日志的方法名
◆r/relative:从程序启动到创建日志记录的时间
◆m/msg/message:程序提供的信息
◆n:换行符

root&logger
< logger name= " com. examp le. demo. controtler" Leve l="erro r
additivity="false'">
<appender-ref ref="APPL ICATION"/>
</ logger>
kroot leve l="wa rn'">
<appender-ref ref="APPLICATION"/>
<appender-ref ref="STDOUT"/>
</ root>
177580411

 */