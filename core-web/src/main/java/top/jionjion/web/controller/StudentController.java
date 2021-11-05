package top.jionjion.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jionjion.web.bean.Student;
import top.jionjion.web.service.StudentService;

/**
 * @author Jion
 */
@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/")
    @ResponseBody
    public String findStudentById(){
        return "Hello Spring Boot";
    }

    /**
     *  http://localhost:8080/student/1/
     * @param id 学生ID
     * @return 结果
     */
    @RequestMapping("/student/{id}/")
    @ResponseBody
    public Student findStudentById(@PathVariable("id") Integer id){
        return service.findStudentById(id);
    }
}
