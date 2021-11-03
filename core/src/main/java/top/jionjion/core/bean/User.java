package top.jionjion.core.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *  @author Jion
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;

    private String address;

    public void init(){
        System.out.println("Bean 初始化...");
    }

    public void destroy(){
        System.out.println("Bean 被销毁...");
    }
}
