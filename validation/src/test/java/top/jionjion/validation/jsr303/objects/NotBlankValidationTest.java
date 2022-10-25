package top.jionjion.validation.jsr303.objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import top.jionjion.validation.ValidationBaseTest;

class NotBlankValidationTest extends ValidationBaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void mustNotBlank1(String parameter) {
        NotBlankValidation obj = new NotBlankValidation();
        obj.mustNotBlank = parameter;
        // 非空串 fail
        super.validate(obj);
    }

    @Test
    void mustNotBlank2() {
        NotBlankValidation obj = new NotBlankValidation();
        obj.mustNotBlank = null;
        // 空 fail
        super.validate(obj);
    }
}