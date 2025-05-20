package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
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

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			Float score = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);

			storeService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);

			// MemberMissionService 콘솔 로그 출력용
			MemberMissionService memberMissionService = context.getBean(MemberMissionService.class);
			Long userId = 1L;
			Long cursorId = null;
			int pageSize = 5;
			System.out.println("\nExecuting getUserMissions with parameters:");
			System.out.println("userId: " + userId + ", cursorId: " + cursorId + ", pageSize: " + pageSize);

			memberMissionService.getUserMissions(userId, cursorId, pageSize)
					.forEach(System.out::println);

			// ReviewService 콘솔 로그 출력용
//			ReviewService reviewService = context.getBean(ReviewService.class);
//			reviewService.addReview(1L, 1L, 5, "분위기가 좋았어요!", "https://img.url/sample.jpg");

			// MissionService 콘솔 로그 출력용
//			MissionQueryService missionQueryService = context.getBean(MissionQueryService.class);
//			missionQueryService.getMissionList("서울", null, 5);

			// MemberQueryService 테스트 추가
//			MemberQueryService memberQueryService = context.getBean(MemberQueryService.class);
//			Long userIdForTest = 1L;

//			System.out.println("\nExecuting findUserInfoById with parameter:");
//			System.out.println("userId: " + userIdForTest);
//
//			MemberInfoDto memberInfo = memberQueryService.getUserInfo(userIdForTest);
//			System.out.println("MemberInfoDto: " + memberInfo);

		};

}}
