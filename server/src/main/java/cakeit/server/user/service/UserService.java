package cakeit.server.user.service;

import cakeit.server.entity.UserEntity;
import cakeit.server.user.dto.UserDto;

import java.util.Optional;

public interface UserService {
    Long join(UserDto userDto);

    Optional<UserEntity> findByLoginId(String loginId);

}
