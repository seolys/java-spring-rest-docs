package seol.study.javaspringrestdocs.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seol.study.javaspringrestdocs.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
