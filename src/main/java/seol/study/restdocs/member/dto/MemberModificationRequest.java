package seol.study.restdocs.member.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberModificationRequest {

	@NotBlank
	@Size(max = 10)
	private String name;

}
