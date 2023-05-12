package hello.core.member;

public class MemberServiceImpl implements MemberService {

	private MemberRepository memberReository;

	public MemberServiceImpl(MemberRepository memberReository) {
		 this.memberReository = memberReository;
	}

	@Override
	public void join(Member member) {
		memberReository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberReository.findById(memberId);
	}
}
