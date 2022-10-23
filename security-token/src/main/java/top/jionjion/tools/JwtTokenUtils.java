package top.jionjion.tools;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 工具类,通过 jsonwebtoken 类库 生成对应的 Token 字符
 *
 * @author Jion
 */
public class JwtTokenUtils {

    static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtils.class);

    /**
     * 工具类, 私有构造
     */
    private JwtTokenUtils() {

    }

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

    /**
     * 角色
     */
    private static final String ROLE = "role";

    /**
     * 创建token
     */
    public static String createToken(String username, String role) {
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
     * 通过 Token String 反序列化生成 Claims 对象
     *
     * @param token 字符串
     * @return 反序列化结果
     */
    private static Optional<Claims> getTokenBody(String token) {

        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            return Optional.of(claims);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return Optional.empty();
    }

    /**
     * 从token中获取用户名(此处的token是指去掉前缀之后的)
     */
    public static String getUserName(String token) {
        return getTokenBody(token).map(Claims::getSubject).orElse(null);
    }

    public static String getUserRole(String token) {
        Optional<Claims> optionalClaims = getTokenBody(token);
        return optionalClaims.map(claims -> (String) claims.get(ROLE)).orElse(null);
    }

    /**
     * 是否已过期
     */
    public static boolean isExpiration(String token) {
        Optional<Claims> tokenBody = getTokenBody(token);
        return tokenBody.map(claims -> claims.getExpiration().before(new Date())).orElse(true);
    }
}