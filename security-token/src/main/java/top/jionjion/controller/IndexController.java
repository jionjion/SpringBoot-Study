package top.jionjion.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Jion
 */
@RestController
public class IndexController {

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    /**
     * 请求,放行
     * GET http://localhost:8080
     */
    @GetMapping("/")
    public String index() {
        return "security jwt";
    }

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
