package hello.hello_spring.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeEach
    public void BeforeEach(){
        memberRepository = new  MemoryMemberRepository(); 
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void AfterEach(){
        memberRepository.clearstore();  
    }
    
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
         
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

        IllegalStateException e =assertThrows(IllegalStateException.class, ()->memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // try{
        //     memberService.join(member2);
        //     fail();
        // } catch(IllegalStateException e){
        //     assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // }
        //then
    }


    @Test
    void testFindOne() {

    }

    @Test
    void testJoin() {

    }
}
