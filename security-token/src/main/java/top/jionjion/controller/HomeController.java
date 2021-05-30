package top.jionjion.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jionjion.tools.JwtTokenUtils;

/**
 * 资源请求,判定是否有权限
 *
 * @author Jion
 */
@RestController
public class HomeController {

    final AuthenticationManagerBuilder authenticationManagerBuilder;

    public HomeController(AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    /**
     * 请求,放行.不做验证
     * curl http://localhost:8080/
     */
    @GetMapping("/")
    public String index() {
        return "不进行安全认证...的资源..";
    }

    /**
     * 登录请求, 并获得认证Token
     * curl -X POST -d "username=admin&password=123456" http://localhost:8080/login
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 登陆验证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //创建jwt信息, 分配权限, 但是没有角色
        return JwtTokenUtils.createToken(username, "admin_role", true);
    }

    /**
     * curl -X GET --header "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJlY2hpc2FuIiwic3ViIjoiYWRtaW4iLCJyb2xlIjoiYWRtaW5fcm9sZSIsImV4cCI6MTYyMjM3MzQ5MCwiaWF0IjoxNjIyMzYyNjkwfQ.vdY4hkAPaajZsaPujJN_n23kc3_gcnp88flzs-rSuyX9zrp05pQ2jkxdyWSBFmFJ37A0MOWjx-qImjQOstT-Lg" http://localhost:8080/authority
     */
    @GetMapping("/authority")
    @PreAuthorize("hasAnyAuthority('admin_role')")
    public String roleInfo() {
        return "当有获得 admin_role 权限，可以看到...";
    }

    /**
     * eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJlY2hpc2FuIiwic3ViIjoiYWRtaW4iLCJyb2xlIjoiYWRtaW5fcm9sZSIsImV4cCI6MTYyMjM3MzQ5MCwiaWF0IjoxNjIyMzYyNjkwfQ.vdY4hkAPaajZsaPujJN_n23kc3_gcnp88flzs-rSuyX9zrp05pQ2jkxdyWSBFmFJ37A0MOWjx-qImjQOstT-Lg
     */
    @GetMapping("/role")
    @PreAuthorize("hasAnyRole('admin_role')")
    public String rolekdream() {
        return "当有获得 admin_role 角色，可以看到...";
    }
}
