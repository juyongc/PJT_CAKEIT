package cakeit.server.reservation.service;

import cakeit.server.cakeStore.repository.CakeStoreRepository;
import cakeit.server.entity.CakeStoreEntity;
import cakeit.server.entity.ReservationEntity;
import cakeit.server.entity.UserEntity;
import cakeit.server.reservation.dto.PostReservationDetailDto;
import cakeit.server.reservation.repository.ReservationRepository;
import cakeit.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final UserRepository userRepository;
    private final CakeStoreRepository cakeStoreRepository;
    private final ReservationRepository reservationRepository;

//    @Transactional
    @Override
    public synchronized boolean saveReservationDetail(PostReservationDetailDto detailDto) throws NoSuchElementException{

        UserEntity userId = userRepository.findById(detailDto.getUserId()).orElseThrow(() -> new NoSuchElementException("존재하지 않는 유저ID입니다."));
        CakeStoreEntity cakeStoreId = cakeStoreRepository.findById(detailDto.getCakeStoreId()).orElseThrow(() -> new NoSuchElementException("존재하지 않는 케이크점ID입니다."));
        LocalDateTime reservationDate = detailDto.getReservationDate();
        String reservationCheck = detailDto.getCakeStoreId().toString() + " || " + reservationDate.toString();

        if (reservationRepository.existsByReservationCheck(reservationCheck)) {
            return false;
        }

        ReservationEntity reservationEntity = ReservationEntity.builder()
                .storeId(cakeStoreId)
                .userId(userId)
                .reservationDate(reservationDate)
                .reservationDetail(detailDto.getDetail())
                .reservationCheck(reservationCheck)
                .reservationImage(detailDto.getReservationImage()).build();

        reservationRepository.save(reservationEntity);
        return true;
    }
}
