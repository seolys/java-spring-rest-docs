package seol.study.restdocs.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seol.study.restdocs.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
