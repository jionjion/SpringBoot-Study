package top.jionjion.caching.service;

import java.util.Random;

/**
 * 照片缓存
 *
 * @author Jion
 */
public abstract class AbstractPhotoService {

    /**
     * 字符串数组
     */
    private final static String STR_ARRAY = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    /**
     * 模拟缓慢的业务逻辑
     */
    protected void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 生成随机字符串
     */
    public String getRandomString() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < STR_ARRAY.length(); i++) {
            int number = random.nextInt(STR_ARRAY.length());
            stringBuilder.append(STR_ARRAY.charAt(number));
        }
        return stringBuilder.toString();
    }
}
