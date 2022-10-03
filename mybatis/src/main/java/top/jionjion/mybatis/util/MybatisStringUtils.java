package top.jionjion.mybatis.util;

import java.util.Locale;

/**
 * 字符处理,在 Mybatis 中调用必须为静态方法
 *
 * @author Jion
 */
public class MybatisStringUtils {

    /**
     * 小写转大写
     *
     * @param lower 输入字符
     * @return 转为大写
     */
    public static String toUpperCase(String lower) {
        return lower.toUpperCase(Locale.ROOT);
    }

    /**
     * 返回 A
     *
     * @return A
     */
    @SuppressWarnings("SameReturnValue")
    public static String returnA() {
        return "A";
    }
}
