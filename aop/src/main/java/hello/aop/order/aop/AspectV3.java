package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV3 {

    @Pointcut("execution(* hello.aop.order..*(..))")
    private void allOrder () {} // pointcut signature

    // 클래스 이름 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    private void allService () {}

    @Around("allOrder()")
    public Object doLog (ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());

        return joinPoint.proceed();
    }

    // hello.aop.order 패키지와 하위 패키지이면서 클래스 이름 패턴이 *Service
    @Around("allOrder() && allService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            log.info("[Transaction start] {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("[Transaction commit] {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            log.info("[Transaction rollback] {}", joinPoint.getSignature());
            throw e;
        } finally {
            log.info("[Resource release] {}", joinPoint.getSignature());
        }
    }
}
