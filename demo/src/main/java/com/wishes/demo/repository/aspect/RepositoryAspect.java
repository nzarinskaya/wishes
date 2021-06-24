package com.wishes.demo.repository.aspect;

import com.wishes.demo.repository.exception.RepositoryException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryAspect {

    private Logger logger;

    @Pointcut("execution(* com.wishes.demo.repository.BaseRepository.*(..))")
    public void allRepositoryMethod(){}

    @Around("allRepositoryMethod()")
    public Object processTime(ProceedingJoinPoint jp) throws Throwable {
        final long start = System.currentTimeMillis();
         Object result = null;
        try{
            result = jp.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        final long end = System.currentTimeMillis();
        final long timeMethod = end - start;
        logger.info("Time process method " + timeMethod+ " ms");
        return result;
    }

    @AfterThrowing(value = "allRepositoryMethod()", throwing = "ex")
    public void exception(JoinPoint joinPoint, Throwable ex){
        logger.error("Error in repository{}: {}",joinPoint.getTarget().getClass(),ex.getMessage(),ex);
        throw new RepositoryException(ex.getMessage(),ex);
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
