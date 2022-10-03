package top.jionjion.h2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jion
 */
@SpringBootTest
class ConnectionTest {

    // JDBC 文件方式连接 单独
    private final static String FILE_URL ="jdbc:h2:W:/SpringBoot-Study/data-h2/src/main/resources/h2_datafile";


    @Test
    void getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(FILE_URL, "root", "123456");
        conn.close();
    }
}
