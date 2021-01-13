package top.jionjion.bean;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

/**
 * @author Jion
 */
class StudentTest extends ValidationBaseTest {

    @Test
    public void validate(){
        Student student = new Student();
        super.validate(student);
    }

    @Test
    public void validateProperty(){
        Student student = new Student();
        super.validateProperty(student, "name");
    }

    @Test
    public void validatePropertyValues(){
        Student student = new Student();
        student.setName("Jion");
        super.validatePropertyValues(Student.class, "name", "Jion");
        super.validatePropertyValues(Student.class, "name", null);
    }
}