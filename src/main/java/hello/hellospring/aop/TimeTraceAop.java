package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//컴포넌트 스캔을 써도 되지만 SpringConfig에 등록해서 사용하는 것을 더 선호함
@Component
public class TimeTraceAop {
//    Around로 적용 범위 설정 가능, 그때그때 검색하여 사용하면 됨
//    @Around("execution(* hello.hellospring..*(..))")
    @Around("execution(* hello.hellospring.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
