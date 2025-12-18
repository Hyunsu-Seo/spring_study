package hello.core.member;

public class MemberServiceImple implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository; // 추상화에만 의존

    public MemberServiceImple(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); // override한 save가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
