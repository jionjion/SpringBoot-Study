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
@SuppressWarnings("JavadocLinkAsPlainText")
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
    @SuppressWarnings("SameReturnValue")
    public String index() {
        return "不进行认证...直接返回资源..";
    }

    /**
     * 登录请求, 并获得认证Token
     * <pre>curl -X POST -d "username=admin&password=123456" http://localhost:8080/login</pre>
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 登陆验证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //创建jwt信息, 分配权限, 但是没有角色
        return JwtTokenUtils.createToken(username, "admin_role");
    }

    /**
     * 携带Token请求是否含有某权限
     * <pre>curl -X GET --header "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJlY2hpc2FuI2iw1ic3ViIj2oiYWRtaW4iLCJyb2xlIj2oiYWRtaW5fcm9sZSIsImV4cCI6MTYyMjM3MzQ5MC1wi2aWF0Ij1oxNjIyMzYyNj3kwfQ.vdY4hkAPa3ajZsaPujJN_n23kc3_gc3np88f6lzs-rSuyX9zrp05pQ2jk1xdyWSBFmFJ37A0MOWjx-qImjQOstT-Lg" http://localhost:8080/authority</pre>
     */
    @GetMapping("/authority")
    @SuppressWarnings("SameReturnValue")
    @PreAuthorize("hasAnyAuthority('admin_role')")
    public String authorityInfo() {
        return "当有获得 admin_role 权限，可以看到...";
    }

    /**
     * 携带Token请求是否含有某角色
     * <pre>curl -X GET --header "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJlY2hpc2FuI2iw1ic3ViIj2oiYWRtaW4iLCJyb2xlIj2oiYWRtaW5fcm9sZSIsImV4cCI6MTYyMjM3MzQ5MC1wi2aWF0Ij1oxNjIyMzYyNj3kwfQ.vdY4hkAPa3ajZsaPujJN_n23kc3_gc3np88f6lzs-rSuyX9zrp05pQ2jk1xdyWSBFmFJ37A0MOWjx-qImjQOstT-Lg" http://localhost:8080/role</pre>
     */
    @GetMapping("/role")
    @SuppressWarnings("SameReturnValue")
    @PreAuthorize("hasAnyRole('admin_role')")
    public String roleInfo() {
        return "当有获得 admin_role 角色，可以看到...";
    }
}
