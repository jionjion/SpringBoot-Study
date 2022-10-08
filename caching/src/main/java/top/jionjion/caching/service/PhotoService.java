package top.jionjion.caching.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import top.jionjion.caching.repository.PhotoRepository;
import top.jionjion.caching.vo.Photo;

/**
 * 缓存服务
 *
 * @author Jion
 */
@Service
@CacheConfig(cacheNames = "photos")
public class PhotoService extends AbstractPhotoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoService.class);

    @Autowired
    PhotoRepository photoRepository;


    /**
     * 配置多个缓存策略
     * Cacheable[] cacheable() default {}; //声明多个@Cacheable
     * CachePut[] put() default {};        //声明多个@CachePut
     * CacheEvict[] evict() default {};    //声明多个@CacheEvict
     * <p>
     * 新增照片
     *
     * @param id    主键
     * @param title 标题
     * @return 返回值.放入缓存中
     */
    @Caching(put = {@CachePut(cacheNames = "photos", key = "'photo:' + #id")})
    public Photo insert(Long id, String title) {
        Photo photo = new Photo();
        photo.setId(id);
        photo.setTitle(title);
        photo.setBase64Date("JPEG:data//" + super.getRandomString());
        LOGGER.info("保存...{}..{}", photo.getTitle(), photo.getBase64Date());
        photoRepository.insert(photo);
        return photo;
    }

    /**
     * CacheEvict 的作用 主要针对方法配置，能够根据一定的条件对缓存进行清空
     * 触发缓存清除
     * 默认先执行数据库删除再执行缓存删除
     */
    @CacheEvict(cacheNames = "photos", key = "'photo:' + #id")
    public void delete(Long id) {
        LOGGER.info("删除...{}", id);
        photoRepository.delete(id);
    }

    /**
     * 删除全部以及缓存
     */
    @CacheEvict(cacheNames = "photos", allEntries = true)
    public void deleteAll() {
        System.out.println("删除全部...");
        photoRepository.deleteAll();
    }

    /**
     * CachePut注解的作用 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，
     * 和 @Cacheable 不同的是，它每次都会触发真实方法的调用
     * 简单来说就是用户更新缓存数据。但需要注意的是该注解的value 和 key 必须与要更新的缓存相同，也就是与@Cacheable 相同
     * 默认先执行数据库更新再执行缓存更新
     * 注意返回值必须是要修改后的数据
     *
     * @param photo 修改数据
     * @return 返回值.放入缓存中
     */
    @CachePut(cacheNames = "photos", key = "'photo:' + #photo.id")
    public Photo update(Photo photo) {
        LOGGER.info("更新...{}", photo.getTitle());
        photoRepository.update(photo);
        return photo;
    }

    /**
     * Cacheable注解会先查询是否已经有缓存，有会使用缓存，没有则会执行方法并缓存
     * 命名空间: @Cacheable 的 value 会替换 @CacheConfig 的 cacheNames(两者必须有一个)
     * key的构成: [命名空间]::[@Cacheable的key或者KeyGenerator生成的key](@Cacheable的key优先级高,KeyGenerator不配置走默认KeyGenerator SimpleKey [])
     * <p>
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回值.放入缓存中
     */
    @Cacheable(value = "photos", key = "'photo:' + #id", unless = "#result == null")
    public Photo findById(Long id) {
        super.simulateSlowService();
        return photoRepository.find(id);
    }

}
