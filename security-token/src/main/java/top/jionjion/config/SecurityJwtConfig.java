package top.jionjion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import top.jionjion.security.JwtAccessDeniedHandler;
import top.jionjion.security.JwtAuthenticationEntryPoint;
import top.jionjion.security.JwtAuthenticationFilter;

/**
 * Spring Security 配置文件
 *
 * @author Jion
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityJwtConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 跨域配置
        http.cors()
                .and()
                // csrf 禁用
                .csrf().disable()
                // 请求认证
                .authorizeRequests()
                // 匹配认证
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/").permitAll()
                // login 不拦截
                .antMatchers("/login").permitAll().anyRequest().authenticated()
                // 授权
                .and()
                // 禁用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 自定义过滤器, 过滤请求Token
        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                // 授权错误...处理
                .exceptionHandling()
                // 用户访问资源没有携带正确的token
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                // 用户访问没有授权资源
                .accessDeniedHandler(jwtAccessDeniedHandler);
    }

    /**
     * 自定义对密码的加解密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

