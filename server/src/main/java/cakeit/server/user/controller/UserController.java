package cakeit.server.user.controller;

import cakeit.server.user.dto.UserDto;
import cakeit.server.user.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Log4j2
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/join", method = RequestMethod.GET)
    public String join() {
        log.info("회원가입 API (GET) 성공");

        return "회원가입 API (GET) 성공";
    }

    @RequestMapping(value = "/user/join", method = RequestMethod.POST)
    public String join(UserDto userDto) {
        log.info("회원가입 폼 입력값 dto 알려줘>>>>>" + userDto);

//        userDto.setUserId(6L);
//        userDto.setLoginId("hayeon");
//        userDto.setPassword("1234");
//        userDto.setNickname("상큼한유자케이크");
//        userDto.setProfileImage("file.jpg");
//        userDto.setAge(94012420L);
//        userDto.setGender("F");

        userService.join(userDto);
        return "회원가입 API (POST) 성공";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login() {
        log.info("로그인 API (GET) 성공");

        return "로그인 API (GET) 성공";
    }
}



