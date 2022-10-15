package top.jionjion.web.handle;

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
class UserExceptionHandleTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserExceptionHandle userExceptionHandler;


    @Test
    void errorCodeHandler() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(userExceptionHandler).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/user/error/{code}", "1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}