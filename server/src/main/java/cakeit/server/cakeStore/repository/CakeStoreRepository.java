package cakeit.server.cakeStore.repository;

import cakeit.server.entity.CakeStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CakeStoreRepository extends JpaRepository<CakeStoreEntity, Long> {

    CakeStoreEntity findByStoreName(String storeName);

//    @Query("select cse from CakeStoreEntity cse where :minLatitude <= cse.latitude <= :maxLatitude and :minLongitude <= cse.longitude <= :maxLongitude")
//    SELECT * FROM a WHERE ROUND(SQRT(POW(`x`-10)+POW(`y`-20))) < 20KM;
//    List<CakeStoreEntity> findByLatitudeAndLongitude(Double minLatitude, Double minLongitude, Double maxLatitude, Double maxLongitude);


}
