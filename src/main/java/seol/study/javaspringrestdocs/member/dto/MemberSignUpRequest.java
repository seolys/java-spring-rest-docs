package seol.study.javaspringrestdocs.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import seol.study.javaspringrestdocs.member.entity.Member;

@Getter
public class MemberSignUpRequest {

	@Email
	private String email;
	@NotBlank
	private String name;

	public Member toEntity() {
		return new Member(email, name);
	}

}
