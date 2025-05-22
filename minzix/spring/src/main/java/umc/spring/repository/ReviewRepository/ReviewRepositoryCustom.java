package umc.spring.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    void insertReview(Long storeId, Long userId, Integer score, String content, String imgUrl);
}
