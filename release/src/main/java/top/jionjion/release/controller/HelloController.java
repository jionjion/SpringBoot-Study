package top.jionjion.release.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例
 *
 * @author Jion
 */
@RestController
public class HelloController {

    @RequestMapping("/home")
    String home() {
        return "Hello World!";
    }
}
