package top.jionjion.service;

import org.springframework.stereotype.Service;
import top.jionjion.bean.Student;
import top.jionjion.mapper.StudentMapper;

/**
 * @author Jion
 */
@Service
public class StudentService {

    private final StudentMapper mapper;

    public StudentService(StudentMapper mapper) {
        this.mapper = mapper;
    }


    /**
     *  通过ID查询
     * @param id 主键
     * @return 结果
     */
    public Student findStudentById(Integer id){
        return mapper.findStudentById(id);
    }
}
