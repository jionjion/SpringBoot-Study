package top.jionjion.web.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import top.jionjion.web.controller.UserController;

/**
 * @author Jion
 */
@SpringBootTest
class UserControllerResponseAdviceTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserController userController;

    @Autowired
    UserExceptionHandler userExceptionHandler;

    @Autowired
    UserControllerResponseAdvice userControllerResponseAdvice;


    /**
     * 对所有响应拦截
     *
     * @throws Exception 抛出异常
     */
    @Test
    void responseHandler() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(userExceptionHandler).setControllerAdvice(userControllerResponseAdvice).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/user/users/1").accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}