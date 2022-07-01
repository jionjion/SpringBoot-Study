package top.jionjion.caching.vo;

/**
 * 图片缓存对象
 *
 * @author Jion
 */
public class Photo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片数据
     */
    private String base64Date;

    public Photo() {
    }

    public Photo(Long id, String title, String base64Date) {
        this.id = id;
        this.title = title;
        this.base64Date = base64Date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBase64Date() {
        return base64Date;
    }

    public void setBase64Date(String base64Date) {
        this.base64Date = base64Date;
    }

    @Override
    public String toString() {
        return "Photo{" + "id=" + id + ", title='" + title + '\'' + ", base64Date='" + base64Date + '\'' + '}';
    }
}
