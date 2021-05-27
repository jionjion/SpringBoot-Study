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
        return "security jwt";
    }

    /**
     *
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 登陆验证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //创建jwt信息
        return JwtTokenUtils.createToken(username, "admin_role", true);
    }

    @GetMapping("/authority")
    @PreAuthorize("hasAnyAuthority('admin_role')")
    public String roleInfo() {
        return "需要获得 admin_role 角色，才可以访问";
    }

    @GetMapping("/role")
    @PreAuthorize("hasAnyRole('admin_role')")
    public String rolekdream() {
        return "需要获得 admin_role 角色，才可以访问";
    }
}
