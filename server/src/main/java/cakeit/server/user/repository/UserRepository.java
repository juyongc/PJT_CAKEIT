package cakeit.server.user.repository;

import cakeit.server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByNickname(String nickname);

    UserEntity findByNickname(String nickname);

    Optional<UserEntity> findByLoginId(String loginId);

}
