package ir.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class ExceptionHandler {

    @Around("execution(* ir..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object result = joinPoint.proceed();
            log.info(joinPoint.getSignature().getName() + "Try/Catch -------> ok");
            return result;
        } catch (Exception e){
            log.error(e.getMessage() + "Try/Catch -------> error");
            return null;
        }
    }
}
