package top.jionjion.aware;

import org.springframework.stereotype.Component;

/**
 * @author Jion
 */
@Component
public class MyWebApplicationAware implements WebApplicationAware {

    private WebApplicationFlag webApplicationFlag;

    @Override
    public void setWebApplicationFlag(WebApplicationFlag webApplicationFlag) {
        this.webApplicationFlag = webApplicationFlag;
    }

    /** 通过 aware 接口获得 */
    public Boolean getFlag(){
        return webApplicationFlag.getWebApplicationFlag();
    }
}
