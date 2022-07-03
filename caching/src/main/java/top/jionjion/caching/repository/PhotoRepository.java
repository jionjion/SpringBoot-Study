package top.jionjion.caching.repository;

import org.springframework.stereotype.Repository;
import top.jionjion.caching.vo.Photo;

import java.util.HashMap;

/**
 * 照片
 *
 * @author Jion
 */
@Repository
public class PhotoRepository {

    public static final HashMap<Long, Photo> DB = new HashMap<>();

    /**
     * 新增
     *
     * @param photo 照片
     */
    public void insert(Photo photo) {
        DB.put(photo.getId(), photo);
    }

    /**
     * 删除
     *
     * @param id 主键
     */
    public void delete(Long id) {
        DB.remove(id);
    }

    /**
     * 修改
     *
     * @param photo 照片
     */
    public void update(Photo photo) {
        DB.put(photo.getId(), photo);
    }

    /**
     * 查询
     *
     * @param id 主键
     * @return 照片
     */
    public Photo find(Long id) {
        return DB.get(id);
    }

    /**
     * 删除全部
     */
    public void deleteAll() {
        DB.clear();
    }
}
