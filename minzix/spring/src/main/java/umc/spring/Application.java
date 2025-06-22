package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.config.properties.JwtProperties;
import umc.spring.dto.Member.MemberInfoDto;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.service.MissionQueryService.MissionQueryService;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.service.StoreQueryService.StoreQueryService;
import umc.spring.service.MemberMissionService.MemberMissionService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
