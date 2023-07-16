package cakeit.server.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table (name = "RESERVATIONS")
public class ReservationEntity extends AbstractEntity {

   	/** FK setting */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESERVATION_ID")
	private Long reservationId;

	/** FK setting */
	@ManyToOne(fetch = FetchType.LAZY)
	// @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "USER_ID", name = "USER_ID")
	private UserEntity userId;

	/** FK setting */
	@ManyToOne(fetch = FetchType.LAZY)
	// @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "STORE_ID", name = "STORE_ID")
	private CakeStoreEntity storeId;

	@Column(name = "RESERVATION_DATE")
	private LocalDateTime reservationDate;

   	@Column(name = "RESERVATION_IMAGE")
	private String reservationImage;

   	@Column(name = "RESERVATION_DETAIL")
	private String reservationDetail;

	/** 예약 케이크점 & 일시 확인을 위한 대리키 */
   	@Column(name = "RESERVATION_CHECK")
	private String reservationCheck;

}
