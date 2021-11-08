package top.jionjion.core.service;

import org.springframework.stereotype.Service;
import top.jionjion.core.bean.Student;
import top.jionjion.core.mapper.StudentMapper;

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
