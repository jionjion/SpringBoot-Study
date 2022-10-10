package top.jionjion.swagger.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Jion
 */
class ResponseCodeTest {

    @Test
    void test() {
        ResponseCode success = ResponseCode.SUCCESS;
        ResponseCode error = ResponseCode.ERROR;
        Assertions.assertNotNull(success);
        Assertions.assertNotNull(error);
    }
}