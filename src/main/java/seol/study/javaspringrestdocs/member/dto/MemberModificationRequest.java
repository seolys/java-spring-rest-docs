package seol.study.javaspringrestdocs.member.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MemberModificationRequest {

	@NotBlank
	private String name;

}
