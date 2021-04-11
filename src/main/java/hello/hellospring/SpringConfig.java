package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

//    생성자가 한개면 @Autowired 필요 X
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    @Autowired
//    private EntityManager em;
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    AOP 이런식으로 Spring Config에 등록해도 되지만, 이번에는 컴포넌트 스캔 사용
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
}
