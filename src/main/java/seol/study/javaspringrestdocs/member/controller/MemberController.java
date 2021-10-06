package seol.study.javaspringrestdocs.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seol.study.javaspringrestdocs.member.dto.MemberModificationRequest;
import seol.study.javaspringrestdocs.member.dto.MemberResponse;
import seol.study.javaspringrestdocs.member.dto.MemberSignUpRequest;
import seol.study.javaspringrestdocs.member.entity.Member;
import seol.study.javaspringrestdocs.member.repository.MemberRepository;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberRepository memberRepository;

	@GetMapping("/{id}")
	public MemberResponse getMember(@PathVariable Long id) {
		Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));

		return new MemberResponse(member);
	}

	@PostMapping
	public void createMember(@RequestBody MemberSignUpRequest dto) {
		memberRepository.save(dto.toEntity());
	}

	@PutMapping("/{id}")
	public void modify(@PathVariable Long id, @RequestBody MemberModificationRequest dto) {
		Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
		member.modify(dto.getName());
		memberRepository.save(member);
	}

	@GetMapping
	public Page<MemberResponse> getMembers(@PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable) {
		return memberRepository.findAll(pageable)
				.map(MemberResponse::new);
	}

}
