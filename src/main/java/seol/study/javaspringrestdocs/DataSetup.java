package seol.study.javaspringrestdocs;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import seol.study.javaspringrestdocs.member.entity.Member;
import seol.study.javaspringrestdocs.member.repository.MemberRepository;

@Component
@RequiredArgsConstructor
public class DataSetup implements ApplicationRunner {

	private final MemberRepository memberRepository;

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		final List<Member> members = new ArrayList<>();
		members.add(new Member("seol1@naver.com", "seol1"));
		members.add(new Member("seol2@naver.com", "seol2"));
		members.add(new Member("seol3@naver.com", "seol3"));
		members.add(new Member("seol4@naver.com", "seol4"));
		members.add(new Member("seol5@naver.com", "seol5"));
		memberRepository.saveAll(members);
	}

}
