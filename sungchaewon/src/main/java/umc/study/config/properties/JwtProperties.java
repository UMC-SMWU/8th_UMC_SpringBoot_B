package umc.study.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("jwt.token")
public class JwtProperties {
    private String secretKey;
    private Expiration expiration = new Expiration(); // 반드시 초기화

    @Getter
    @Setter
    public static class Expiration {
        private Long access;
    }
}