package top.jionjion.tools;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 工具类,通过 jsonwebtoken 类库 生成对应的 Token 字符
 *
 * @author Jion
 */
public class JwtTokenUtils {
    /**
     * 放入请求头的token的key
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * Token的值,前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 加密随机字符
     */
    public static final String SECRET = "jwtSecret";

    /**
     * 签发人
     */
    public static final String ISS = "jion";

    /**
     * 过期时间3小时
     */
    private static final Long EXPIRATION = 60 * 60 * 3L;

    private static final String ROLE = "role";

    /**
     * 创建token
     */
    public static String createToken(String username, String role, boolean isRememberMe) {
        Map<String, Object> map = new HashMap<>(4);
        map.put(ROLE, role);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                // 一些权限信息
                .setClaims(map)
                // 主题
                .setSubject(username)
                // 签发人
                .setIssuer(ISS)
                // 签发日期
                .setIssuedAt(new Date())
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();
    }

    /**
     * 从token中获取用户名(此处的token是指去掉前缀之后的)
     */
    public static String getUserName(String token) {
        String username;
        try {
            username = getTokenBody(token).getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public static String getUserRole(String token) {
        return (String) getTokenBody(token).get(ROLE);
    }

    /**
     * 通过 Token String 反序列化生成 Claims 对象
     *
     * @param token 字符串
     * @return 反序列化结果
     */
    private static Claims getTokenBody(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 是否已过期
     */
    public static boolean isExpiration(String token) {
        try {
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}