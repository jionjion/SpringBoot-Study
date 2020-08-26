package top.jionjion.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.jionjion.bean.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 框架参数
 *
 * @author Jion
 */
@Slf4j
@RestController
public class ParameterController {


    /**
     * 直接在URL后跟参数,或通过Params进行查询
     *
     * @param name 用户名
     * @return 响应字符串
     */
    @GetMapping("/parameter/a")
    public String addParameterA(String name) {
        log.info("name is: " + name);
        return "Success";
    }

    /**
     * 通过HttpServletRequest接收
     * 通过在URL中追加参数, 或 Form表单中增加参数属性
     *
     * @param request 请求
     * @return 响应字符串
     */
    @PostMapping("/parameter/b")
    public String addParameterB(HttpServletRequest request) {
        // 获得表单或者查询参数
        String name = request.getParameter("name");
        log.info("name is: " + name);
        return "Success";
    }

    /**
     * 封装一个bean来接收
     * 通过在URL中追加参数, 或 Form表单中增加封装属性
     *
     * @param student 传入Bean参数对象
     * @return 响应字符串
     */
    @PostMapping("/parameter/c")
    public String addParameterC(Student student) {
        log.info("student is: " + student);
        return "Success";
    }

    /**
     * 通过@PathVariable获取路径中的参数
     *
     * @return 响应字符串
     */
    @RequestMapping(value = "/parameter/d/{id}")
    public String addParameterD(@PathVariable String id) {
        log.info("id is: " + id);
        return "Success";
    }


    /**
     * 使用@ModelAttribute注解获取POST请求的FORM表单数据, 其实不使用注解也可
     *
     * @param student 封装Form表单
     * @return 响应字符串
     */
    @RequestMapping(value = "/parameter/e", method = RequestMethod.POST)
    public String addParameterE(@ModelAttribute("student") Student student) {
        log.info("student is: " + student);
        return "Success";
    }

    /**
     * 用注解@RequestParam绑定请求URL中的参数,Form表单中的参数
     *
     * @param name 请求参数
     * @return 响应字符串
     */
    @RequestMapping(value = "/parameter/f")
    public String addParameterF(@RequestParam("name") String name) {
        log.info("name is: " + name);
        return "Success";
    }

    /**
     * 用注解@Requestbody绑定请求参数到方法入参
     *
     * @param student 请求体
     * @return 响应字符串
     */
    @RequestMapping(value = "/parameter/g", method = RequestMethod.POST)
    public String addParameterG(@RequestBody Student student) {
        log.info("student is: " + student);
        return "Success";
    }

    /**
     * 用注解@Requestbody绑定请求参数到方法入参
     * 通过在请求体中,增加数组,完成绑定
     *
     * @param names 请求体,数组对象
     * @return 响应字符串
     */
    @RequestMapping(value = "/parameter/h", method = RequestMethod.POST)
    public String addParameterH(@RequestBody String[] names) {
        log.info("names is: " + Arrays.toString(names));
        return "Success";
    }
}
