package com.hello.hellospring;

import com.hello.hellospring.aop.TimeTraceAop;
import com.hello.hellospring.repository.JpaMemberRepository;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
        return this.memberRepository;
    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
