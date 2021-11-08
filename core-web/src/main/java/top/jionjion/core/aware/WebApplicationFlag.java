package top.jionjion.core.aware;

import org.springframework.stereotype.Component;

/**
 *  自定义类, 使用 aware 获取
 * @author Jion
 */
@Component
public class WebApplicationFlag {

    /** 是否Web应用 */
    private Boolean isWebApplicationFlag = Boolean.FALSE;

    public Boolean getWebApplicationFlag() {
        return isWebApplicationFlag;
    }

    public void setWebApplicationFlag(Boolean webApplicationFlag) {
        isWebApplicationFlag = webApplicationFlag;
    }
}
