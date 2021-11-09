package top.jionjion.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充策略
 *
 * @author jion
 */
@Slf4j
@Component
public class DateMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入策略
     *
     * @param metaObject 字段信息
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("执行插入逻辑...");
        this.setFieldValByName("createDate", new Date(), metaObject);
        this.setFieldValByName("modifyDate", new Date(), metaObject);
    }

    /**
     * 更新策略
     *
     * @param metaObject 字段信息
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifyDate", new Date(), metaObject);
        log.info("执行更新逻辑...");
    }
}
