package fan.esports.championship.Esports.Championship.infrastructure.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import fan.esports.championship.Esports.Championship.core.enums.UserRole;
import fan.esports.championship.Esports.Championship.infrastructure.config.JWTUserData;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {

    @Value("${esports.security.secret}")
    private String secret;

    public String generateToken(UserEntity user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("id", user.getId())
                .withClaim("name", user.getName())
                .withClaim("role", user.getRole().name())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API Esports")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);
            String id = jwt.getClaim("id").toString();
            String name = jwt.getClaim("name").toString();
            String email = jwt.getClaim("email").toString();
            UserRole role = UserRole.valueOf(jwt.getClaim("role").toString().replaceAll(("^\"|\"$"), ""));
            return Optional.of( JWTUserData.builder()
                    .id(id)
                    .name(name)
                    .email(email)
                    .role(role)
                    .build());
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
    }
}
