package top.jionjion.mybatis.dto;

import org.junit.jupiter.api.Test;

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