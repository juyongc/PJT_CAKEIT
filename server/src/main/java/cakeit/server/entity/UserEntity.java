package cakeit.server.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
//@Table (name = "USERS", indexes = {@Index(name="nickname_index", columnList = "NICKNAME")})
@Table (name = "USERS")
public class UserEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "LOGIN_ID")
	private String loginId;

   	@Column(name = "PASSWORD")
	private String password;

   	@Column(name = "NICKNAME")
	private String nickname;

   	@Column(name = "AGE")
	private Long age;

   	@Column(name = "GENDER")
	private String gender;

   	@Column(name = "PROFILE_IMAGE")
	private String profileImage;

	@Column(name = "IS_DELETED")
	private boolean isDeleted;

	@Column(name = "DELETED_AT")
	private LocalDateTime deletedAt;

}
