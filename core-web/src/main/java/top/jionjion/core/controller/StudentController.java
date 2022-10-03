package top.jionjion.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jionjion.core.bean.Student;
import top.jionjion.core.utils.service.StudentService;

/**
 * @author Jion
 */
@Controller
@SuppressWarnings("JavadocLinkAsPlainText")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping("/")
    @SuppressWarnings("SameReturnValue")
    public String findStudentById() {
        return "Hello Spring Boot";
    }

    /**
     * http://localhost:8080/student/1/
     *
     * @param id 学生ID
     * @return 结果
     */
    @ResponseBody
    @RequestMapping("/student/{id}/")
    public Student findStudentById(@PathVariable("id") Integer id) {
        return service.findStudentById(id);
    }
}
