package cakeit.server.user.service;

import cakeit.server.entity.UserEntity;
import cakeit.server.user.dto.UserDto;
import cakeit.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Transactional
    public void join(UserDto userDto) {
        log.info("회원가입 서비스 시작");

//        //password 암호화
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        log.info("암호화 패스워드 >>>" + userDto.getPassword());


        //생년월일로 나이, 성별 변환
        //성별 판단
        String juminNo = String.valueOf(userDto.getAge());
        log.info("juminNo >>>" + juminNo);

        String gender= String.valueOf(juminNo.charAt(6));
        log.info("gender >>>" + gender);

        //if 문
        if (gender.equals("1") || gender.equals("3")) {
            gender = "남";
        } else if (gender.equals("2") || gender.equals("4")) {
            gender = "여";
        } else {
            gender = "에러";
        }
        log.info("성별 알려줘 >>>>"+gender);

        //만 나이 계산
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        String birthYear = juminNo.substring(0,2);

        char ch = juminNo.charAt(7);
        Long age;

        if(ch < '3'){
           age = Long.valueOf(year - (1900 + Integer.parseInt(birthYear)) + 1);
        }else {
            age = Long.valueOf(year - (2000 + Integer.parseInt(birthYear)) + 1);
        }
        log.info("계산한 만 나이 >>>>>"+age);



        UserEntity userEntity = UserEntity.builder()
                .loginId(userDto.getLoginId())
                .password(userDto.getPassword())
                .nickname(userDto.getNickname())
                    .age(age)
                //.age(userDto.getAge())
                .profileImage(userDto.getProfileImage())//
//                .gender(userDto.getGender())
                .gender(gender)
                .build();

        userRepository.save(userEntity);
        //return "조인 성공";
    }


    @Override
    public UserDetails login(String loginId) {
        return null;
    }

    @Override
    public UserDetails loadUserByLoginId(String loginId) throws UsernameNotFoundException {
        // 로그인을 하기 위해 가입된 user정보를 조회하는 메서드
        Optional<UserEntity> memberWrapper = userRepository.findByLoginId(loginId);
        UserEntity userEntity = memberWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if("admin".equals(loginId)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        // 아이디, 비밀번호, 권한리스트를 매개변수로 User를 만들어 반환해준다.
        return new User(userEntity.getLoginId(), userEntity.getPassword(), authorities);
    }

    @Override
    public Optional<UserEntity> findByLoginId(String loginId){
        return userRepository.findByLoginId(loginId);
    }




//    public boolean login(UserDto userDto) {
//        UserDto findUser = userRepository.findByLoginId(userDto.getLoginId());
//        log.info("로그인 서비스 >>" + userDto.getLoginId());
//        log.info("로그인 서비스 findUser>>" + findUser);
//
//        if (findUser == null) {
//            return false;
//        }
//
//        if (!findUser.getPassword().equals(userDto.getPassword())) {
//            return false;
//        }
//        return true;
//    }

//    public Long login(UserDto userDto) {
//        UserDto userDto = userRepository.save(userDto);
//        return userDto.getUserId();
//}
}
