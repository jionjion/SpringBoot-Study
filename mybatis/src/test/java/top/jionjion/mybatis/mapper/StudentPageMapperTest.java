package top.jionjion.mybatis.mapper;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.jionjion.mybatis.dto.Student;
import top.jionjion.mybatis.mapper.StudentQueryMapper;

import java.util.List;

/**
 *  @author Jion
 */
@Slf4j
@SpringBootTest
class StudentPageMapperTest {


    @Autowired
    StudentQueryMapper mapper;


    @Test
    void testPage(){
        // 页码0 ,每页1
        PageHelper.startPage(0, 1);
        List<Student> students = mapper.findAllOrderByIdDesc();
        Assert.notNull(students,"失败");
        log.info(students.toString());
    }
}
