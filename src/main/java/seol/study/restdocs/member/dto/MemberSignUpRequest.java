package seol.study.restdocs.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import seol.study.restdocs.member.entity.Member;
import seol.study.restdocs.member.entity.MemberStatus;

@Getter
public class MemberSignUpRequest {

	@Email
	@Size(max = 30)
	private String email;

	@NotBlank
	@Size(max = 10)
	private String name;

	private MemberStatus status;

	public Member toEntity() {
		return new Member(email, name, status);
	}

}
