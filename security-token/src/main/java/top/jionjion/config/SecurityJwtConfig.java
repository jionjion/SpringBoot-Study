package top.jionjion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import top.jionjion.security.JwtAccessDeniedHandler;
import top.jionjion.security.JwtAuthenticationEntryPoint;
import top.jionjion.security.JwtAuthenticationFilter;

import java.util.Collections;

/**
 * Spring Security 配置文件
 * WebSecurityConfigurerAdapter 方法已经过时了, 这里采用配置 {@see SecurityFilterChain} 方法进行自定义过滤器链条
 *
 * @author Jion
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityJwtConfig {

    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public SecurityJwtConfig(JwtAccessDeniedHandler jwtAccessDeniedHandler, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
        httpSecurity
                // 跨域配置
                .cors()
                .configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    // 跨域用户凭证
                    corsConfiguration.setAllowCredentials(true);
                    // 允许访问的资源
                    corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
                    // 允许访问的来源
                    corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
                    // 允许访问的方式
                    corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                    return corsConfiguration;
                })
                .and()
                // csrf 禁用
                .csrf().disable()
                // 请求认证
                .authorizeRequests()
                // 匹配认证,放行认证
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll().anyRequest().authenticated()
                .and()
                // Spring Security永远不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 自定义过滤器, 过滤请求Token
        httpSecurity.addFilterBefore(new JwtAuthenticationFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)
                // 授权错误...处理
                .exceptionHandling()
                // 用户访问资源没有携带正确的token,处理
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                // 用户访问没有授权资源
                .accessDeniedHandler(jwtAccessDeniedHandler);

        return httpSecurity.build();
    }

    /**
     * 自定义对密码的加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

