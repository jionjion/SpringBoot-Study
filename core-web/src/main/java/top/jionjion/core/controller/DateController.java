package top.jionjion.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期对象格式化及序列化
 *
 * @author Jion
 */
@Slf4j
@RestController
public class DateController {

    /**
     * 直接在URL后跟参数,或在Form表单添加
     *
     * @param date 日期
     */
    @RequestMapping("/date/a")
    public void addDateA(Date date) {
        log.info("date is: {}", date);
    }

    /**
     * 支持Form表单和URL传参时, 日期转换.
     *
     * @param webDataBinder 注册数据编辑器
     * @param webRequest    请求对象
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    /**
     * 在请求体和响应体中对日期格式化
     *
     * @param date 日期对象
     */
    @RequestMapping("/date/b")
    public Date addDateB(@RequestBody Date date) {
        log.info("date is: {}", date);
        return date;
    }
}
