package top.jionjion.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import top.jionjion.web.bean.User;

import java.util.Collections;
import java.util.Date;

/**
 * @author Jion
 */
@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private ObjectMapper objectMapper;

    MockMvc mockMvc;

    @BeforeEach
    void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void userList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void userSave() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("username");
        user.setPassword("password");
        user.setAddress("ShangHai");
        user.setBirthday(new Date());
        // json 请求体
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/user").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void userGet() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/users/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void userUpdate() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("username", Collections.singletonList("jion"));
        params.put("password", Collections.singletonList("123456"));

        // json 请求体
        this.mockMvc.perform(MockMvcRequestBuilders.put("/user/users/{id}", 1).contentType(MediaType.APPLICATION_JSON).params(params).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void userDelete() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/user/users/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void userGetByUsername() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/users/username/{username}", "jion").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void errorCodeHandler() throws Exception {
        //noinspection TestFailedLine
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/error/{code}", "1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError()).andDo(MockMvcResultHandlers.print());
        Assertions.fail("发生异常..");
    }
}