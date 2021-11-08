package top.jionjion.plus.dto;

import org.junit.jupiter.api.Test;
import top.jionjion.plus.dto.Teacher;

/**
 * @author Jion
 */
class TeacherTest {

    @Test
    public void test(){
        Teacher teacher = new Teacher();
        teacher.setId(1);
        System.out.println(teacher);
    }
}