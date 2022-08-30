package hello.hello_spring.service;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.JdbcTemplateMemberRepository;
import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConpig {
    private final MemberRepository memberRepository;

    
    @Autowired
    public SpringConpig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


   
    // @Bean
    // public MemberRepository memberRepository(){
    //     //return new MemoryMemberRepository();
    //     //return new JdbcMemberRepository(dataSource);
    //     //return new JdbcTemplateMemberRepository(dataSource);
    //     //return new JpaMemberRepository(em);
    // }
    

}
