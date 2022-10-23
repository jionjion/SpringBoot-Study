package top.jionjion.controller;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Collections;

/**
 * @author Jion
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HomeControllerTest {

    @Autowired
    private HomeController homeController;

    MockMvc mockMvc;

    String token;

    final Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);

    @BeforeEach
    void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    /**
     * 访问主页, 没有认证限制
     *
     * @throws Exception IOException
     */
    @Test
    @Order(100)
    void index() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 登录请求, 并获得认证.. 返回 Token 信息
     *
     * @throws Exception IOException
     */
    @Test
    @Order(200)
    void login() throws Exception {
        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("username", Collections.singletonList("admin"));
        params.put("password", Collections.singletonList("123456"));

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/login").params(params).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String token = response.getContentAsString();
        logger.info("获得 Token:  {}", token);
        this.token = token;
    }

    /**
     * 携带Token请求是否含有某权限
     *
     * @throws Exception IOException
     */
    @Test
    @Order(300)
    void authorityInfo() throws Exception {
        // 构建请求
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/authority")
                .header("Authorization", Collections.singletonList(String.format("Bearer %s", this.token)))
                .accept(MediaType.APPLICATION_JSON);

        // 请求
        MvcResult mvcResult = this.mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        logger.info("获得 admin_role 权限才能访问的资源: {}", response.getContentAsString());
    }

    /**
     * 携带Token请求是否含有某角色
     *
     * @throws Exception IOException
     */
    @Test
    @Order(400)
    void roleInfo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/role")
                        .header("Authorization", Collections.singletonList(String.format("Bearer %s", this.token)))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}