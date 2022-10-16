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
import top.jionjion.web.bean.User;
import top.jionjion.web.controller.UserController;

import java.util.Date;

/**
 * 测试 Controller 增强
 *
 * @author Jion
 */
@SpringBootTest
class UserControllerRequestAdviceTest {


    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserController userController;

    @Autowired
    UserExceptionHandler userExceptionHandler;

    @Autowired
    UserControllerRequestAdvice userControllerRequestAdvice;


    @Test
    void requestHandler() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(userExceptionHandler).setControllerAdvice(userControllerRequestAdvice).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/user/users/{id}", "1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 仅对含有 Request Body 的请求进行拦截
     *
     * @throws Exception 抛出异常
     */
    @Test
    void userSave() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("username");
        user.setPassword("password");
        user.setAddress("ShangHai");
        user.setBirthday(new Date());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(userExceptionHandler).setControllerAdvice(userControllerRequestAdvice).build();
        // json 请求体
        mockMvc.perform(MockMvcRequestBuilders.post("/user/user").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}