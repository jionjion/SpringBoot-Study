package top.jionjion.redisom.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository repository;


    @Test
    public void test(){
        Assertions.assertNotNull(repository);
    }

}