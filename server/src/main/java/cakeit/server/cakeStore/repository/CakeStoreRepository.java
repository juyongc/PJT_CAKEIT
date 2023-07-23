package cakeit.server.cakeStore.repository;

import cakeit.server.entity.CakeStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CakeStoreRepository extends JpaRepository<CakeStoreEntity, Long> {

    CakeStoreEntity findByStoreName(String storeName);

    CakeStoreEntity findByPlaceId(String placeId);

}
