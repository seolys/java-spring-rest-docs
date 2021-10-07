package seol.study.restdocs.member.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private MemberStatus status;

	@Column(name = "createAt", nullable = false)
	private LocalDateTime createAt;

	@Column(name = "updateAt", nullable = false)
	private LocalDateTime updateAt;

	public Member(final String email, final String name, final MemberStatus status) {
		this.email = email;
		this.name = name;
		this.status = status;
		this.createAt = LocalDateTime.now();
		this.updateAt = LocalDateTime.now();
	}

	public void modify(String name) {
		this.name = name;
	}
}
