package cakeit.server.reservation.repository;

import cakeit.server.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    boolean existsByReservationCheck(String reservationCheck);

}
