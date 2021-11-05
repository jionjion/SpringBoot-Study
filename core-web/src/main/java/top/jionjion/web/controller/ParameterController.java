package top.jionjion.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import top.jionjion.web.bean.Student;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

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
     * 使用@ModelAttribute标注在方法上,会在每个controller方法前均执行.
     * 执行对指定属性或者
     *
     * @param 封装Form表单,并将 student 对象存入上下文中
     */
    @ModelAttribute("student")
    public void addParameterF1(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        Student student = new Student();
        student.setName(name);
        student.setId(Integer.parseInt(id));
        model.addAttribute("student", student);
    }

    @RequestMapping(value = "/parameter/f", method = RequestMethod.POST)
    public String addParameterF2(Model model) {
        Student student = (Student) model.getAttribute("student");
        log.info("student is: " + student);
        return "Success";
    }

    /**
     * 用注解@RequestParam绑定请求URL中的参数,Form表单中的参数
     *
     * @param name 请求参数
     * @return 响应字符串
     */
    @RequestMapping(value = "/parameter/j")
    public String addParameterJ(@RequestParam("name") String name) {
        log.info("name is: " + name);
        return "Success";
    }

    /**
     * 用注解@Requestbody绑定请求参数到方法入参
     *
     * @param student 请求体
     * @return 响应字符串
     */
    @RequestMapping(value = "/parameter/h", method = RequestMethod.POST)
    public String addParameterH(@RequestBody Student student) {
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
    @RequestMapping(value = "/parameter/i", method = RequestMethod.POST)
    public String addParameterI(@RequestBody String[] names) {
        log.info("names is: " + Arrays.toString(names));
        return "Success";
    }

    /**
     * 通过 form-data 表单的形式同时提交参数和文件
     *
     * @param request 处理表单请求.包含文件(支持多文件传输)及Form数据
     * @return 响应字符串
     * @throws IOException 查看IO附件
     */
    @RequestMapping(value = "/parameter/j", method = RequestMethod.POST)
    public String addParameterJ(MultipartHttpServletRequest request) throws IOException {
        // 获取数据
        String requestData = request.getParameter("_request_data");
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(requestData, Student.class);
        System.out.println(student.toString());
        // 附件
        List<MultipartFile> files = request.getFiles("file");
        for (MultipartFile file : files) {
            System.out.println("文本框文件属性" + file.getName());
            System.out.println("文件原始名称" + file.getOriginalFilename());
            System.out.println("文件长度" + file.getSize());
            System.out.println("文件类型" + file.getContentType());
            // 文件读写
            try (InputStream inputStream = file.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream("S:\\" + file.getOriginalFilename())) {
                int len;
                byte[] buffer = new byte[4096];
                while ((len = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }
            }
        }
        return "Success";
    }
}
