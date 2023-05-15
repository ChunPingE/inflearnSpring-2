package hello.core.member;


public interface MemberRepository {
	void save(Member mebmer);

	Member findById(Long memberId);
}
