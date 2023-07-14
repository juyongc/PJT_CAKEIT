package cakeit.server.user.repository;

import cakeit.server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByNickname(String nickname);

}
