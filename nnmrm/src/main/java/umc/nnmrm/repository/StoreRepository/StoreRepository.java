package umc.nnmrm.repository.StoreRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.nnmrm.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}