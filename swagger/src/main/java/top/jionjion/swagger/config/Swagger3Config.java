package top.jionjion.swagger.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  配置文件信息
 *
 * @author Jion
 */
@EnableOpenApi
@Configuration
public class Swagger3Config implements WebMvcConfigurer {

    @Bean
    public Docket createRestApi() {
        //返回文档摘要信息
        return new Docket(DocumentationType.OAS_30)
                // 文档开头描述
                .apiInfo(apiInfo())
                // 生成文档的入口
                .select()
                // 通过注解方式检索..指定方法注解, 类注解, 基础扫描包.. 最新的注解版本包 io.swagger.core.v3.*
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) // 2.0
//                .apis(RequestHandlerSelectors.withMethodAnnotation(Operation.class)) // 3.0
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("top.jionjion.swagger.controller"))
                // 文档路径
                .paths(PathSelectors.any())
                .build()
                // 配置文档的全局参数..
                .globalRequestParameters(getGlobalRequestParameters())
                .globalResponses(HttpMethod.GET, getGlobalResponseMessage())
                .globalResponses(HttpMethod.POST, getGlobalResponseMessage());
    }

    /** 接口信息，包括标题, 联系人, 版本等 */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档示例")
                .description("这是描述...嘤嘤嘤")
                .contact(new Contact("springfox", "http://springfox.github.io/springfox/", null))
                .version("1.0")
                .build();
    }

    /** 全局,通用参数..每次请求时,必须携带 */
    private List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("version")
                .description("客户端的版本号")
                .required(true)
                .in(ParameterType.QUERY)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
        return parameters;
    }

    /** 全局,通用响应信息 */
    private List<Response> getGlobalResponseMessage() {
        return Collections.singletonList(new ResponseBuilder().code("404").description("找不到资源").build());
    }


    /** 如果被拦截,添加放行 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.
                addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

    /** 支持跳转,兼容2.0 */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( "/swagger-ui/")
                .setViewName("forward:" + "/swagger-ui/index.html");
    }
}