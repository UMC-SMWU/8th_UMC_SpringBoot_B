package umc.nnmrm;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.nnmrm.service.MemberMissionService.MemberMissionQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner testMemberMission(ApplicationContext context) {
		return args -> {
			var missionService = context.getBean(MemberMissionQueryService.class);

			Long memberId = 1L;
			String cursor = null;
			int limit = 15;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("memberId: " + memberId);
			System.out.println("cursor: " + cursor);
			System.out.println("limit: " + limit);

			missionService.getMemberMissions(memberId, cursor, limit).forEach(System.out::println);;

		};
	}
}
