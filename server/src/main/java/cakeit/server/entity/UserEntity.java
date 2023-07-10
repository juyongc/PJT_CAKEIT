package cakeit.server.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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


}
