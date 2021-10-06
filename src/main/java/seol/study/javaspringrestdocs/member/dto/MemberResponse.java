package seol.study.javaspringrestdocs.member.dto;

import lombok.Getter;
import seol.study.javaspringrestdocs.member.entity.Member;

@Getter
public class MemberResponse {

	private final Long id;
	private final String email;
	private final String name;

	public MemberResponse(final Member member) {
		this.id = member.getId();
		this.email = member.getEmail();
		this.name = member.getName();
	}
}
