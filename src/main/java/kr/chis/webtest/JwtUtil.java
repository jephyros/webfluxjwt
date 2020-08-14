package kr.chis.webtest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author InSeok
 * Date : 2020/08/15
 * Remark :
 */
@Component
public class JwtUtil {
    @Value("${security.oauth2.resource.jwt.key-value}")
    private String SECRET_KEY;

    public DecodedJWT verifyToken(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build();

        return verifier.verify(token);

    }
    public String decodeTokenGetHeader(String token){
        return JWT.decode(token).getHeader();

    }
    public String decodeTokenGetPayload(String token){
        return JWT.decode(token).getPayload();

    }
}
