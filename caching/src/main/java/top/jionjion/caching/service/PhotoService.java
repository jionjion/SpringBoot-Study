package top.jionjion.caching.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.jionjion.caching.vo.Photo;

/**
 * 照片缓存
 *
 * @author Jion
 */
@Service
public class PhotoService {

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 图片
     */
    @Cacheable("photos")
    public Photo findById(Long id) {
        simulateSlowService();
        return new Photo(id, "照片", "JPEG:data//123456trd3sa87s9dfg76hj43ht2g51627e8rh4duh");
    }


    /**
     * 模拟缓慢的业务逻辑
     */
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
