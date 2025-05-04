package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.domain.Review;
import umc.spring.service.MemberMissionService.MemberMissionService;
import umc.spring.service.MemberService.MemberService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.web.dto.MyPageInfoDto;

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

			MemberMissionService memberMissionService = context.getBean(MemberMissionService.class);
			Long memberId = 1L;
			Long cursorId = null;
			int limit = 10;
			System.out.println("\nExecuting getMemberMissions with parameters:");
			System.out.println("memberId: " + memberId + ", cursorId: " + cursorId + ", limit: " + limit);

			memberMissionService.getMemberMissions(memberId, cursorId, limit)
					.forEach(System.out::println);

			ReviewService reviewService = context.getBean(ReviewService.class);
			Long storeId = 1L;
			String body = "맛있어요!";
			Float reviewScore = 4.5f;

			System.out.println("\nCreating dummy review...");
			Review newReview = reviewService.createReview(memberId, storeId, body, reviewScore);
			System.out.println("New Review created:");
			System.out.println(newReview);

			MemberService memberService = context.getBean(MemberService.class);
			MyPageInfoDto myPageInfo = memberService.getMyPageInfo(memberId);
			System.out.println("\nExecuting MyPageInfo:");
			System.out.println(myPageInfo);
		};
	}
}
