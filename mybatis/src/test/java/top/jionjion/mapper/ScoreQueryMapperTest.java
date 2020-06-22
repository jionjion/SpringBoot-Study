package top.jionjion.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.jionjion.bean.Score;
import top.jionjion.bean.Student;

import java.util.List;

/**
 * @author Jion
 */
@Slf4j
@SpringBootTest
class ScoreQueryMapperTest {

    @Autowired
    ScoreQueryMapper mapper;

    @Test
    void findScoreByStudentId(){
        List<Score> scoreList = mapper.findScoreByStudentId(1);
        log.info("查询成功" + scoreList.toString());
        Assert.notNull(scoreList, "失败");
    }

    @Test
    void findScoreAndStudentByScoreId(){
        List<Score> scoreList = mapper.findScoreAndStudentByScoreId(1);
        log.info("查询成功" + scoreList.toString());
        Assert.notNull(scoreList, "失败");
    }


    @Test
    void findStudentAndScoreByStudentId(){
        List<Student> studentList = mapper.findStudentAndScoreByStudentId(1);
        log.info("查询成功" + studentList.toString());
        Assert.notNull(studentList, "失败");
    }

    @Test
    void findStudentAndScoreByStudentIdForObject(){
        List<Student> studentList = mapper.findStudentAndScoreByStudentIdForObject(1);
        log.info("查询成功" + studentList.toString());
        Assert.notNull(studentList, "失败");
    }
}