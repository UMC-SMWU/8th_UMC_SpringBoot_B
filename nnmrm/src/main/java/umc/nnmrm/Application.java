package umc.nnmrm;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.nnmrm.web.dto.Review.ReviewQueryResponseDTO;
import umc.nnmrm.service.MemberService.MemberQueryService;
import umc.nnmrm.service.MissionService.MissionQueryService;
import umc.nnmrm.service.MemberMissionService.MemberMissionQueryService;
import umc.nnmrm.service.ReviewService.ReviewService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			// 테스트 실행 순차 제어
			testMemberMission(context);
			testReviewWrite(context);
			testAvailableMissions(context);
			testMyPageInfo(context);
		};
	}

	public void testMemberMission(ApplicationContext context) {
		var missionService = context.getBean(MemberMissionQueryService.class);

		Long memberId = 1L;
		String cursor = null;
		int limit = 15;

		System.out.println("Executing findStoresByNameAndScore with parameters:");
		System.out.println("memberId: " + memberId);
		System.out.println("cursor: " + cursor);
		System.out.println("limit: " + limit);

		missionService.getMemberMissions(memberId, cursor, limit).forEach(System.out::println);

	}

	public void testReviewWrite(ApplicationContext context) {
		var reviewService = context.getBean(ReviewService.class);

		Long memberId = 1L;
		Long storeId = 1L;
		Float score = 4.5f;
		String body = "이 가게 진짜 맛집이에요. 또 갈래요!";

		System.out.println("Executing writeReview with parameters:");
		System.out.println("memberId: " + memberId);
		System.out.println("storeId: " + storeId);
		System.out.println("score: " + score);
		System.out.println("body: " + body);

		ReviewQueryResponseDTO result = reviewService.writeReview(memberId, storeId, score, body);
		System.out.println("리뷰 저장 완료! \n" + result);
	}

	public void testAvailableMissions(ApplicationContext context) {
		var homeService = context.getBean(MissionQueryService.class);

		Long memberId = 1L;
		Long regionId = 1L;
		String cursor = null;
		int limit = 15;

		System.out.println("Executing getAvailableMissions with parameters:");
		System.out.println("memberId: " + memberId);
		System.out.println("regionId: " + regionId);
		System.out.println("cursor: " + cursor);
		System.out.println("limit: " + limit);

		homeService.getAvailableMissions(memberId, regionId, cursor, limit).forEach(System.out::println);
	}


	public void testMyPageInfo(ApplicationContext context) {
		var myPageService = context.getBean(MemberQueryService.class);

		Long memberId = 1L;

		System.out.println("Executing getMyPageInfo with memberId = " + memberId);

		var result = myPageService.getMyPageInfo(memberId);
		System.out.println("해당 멤버의 마이페이지 정보 조회 \n" + result);
	}
}
