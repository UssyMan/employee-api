package com.uthmanIV.RestAPI.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j // Lombok will auto-generate the logger
public class LoggingAOP {

    // Pointcut for any method annotated with @GetMapping (for GET requests)
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMappings(){}

    // Pointcut for any method annotated with @PutMapping or @PostMapping (for PUT/POST requests)
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
               "@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void setMappings(){}

    // Logging before GET methods are called
    @Before("getMappings()")
    public void logBeforeGet(JoinPoint joinPoint) {
        log.info("Calling GET service: {}", joinPoint.getSignature().toShortString());
    }

    // Logging after GET methods successfully return
    @AfterReturning("getMappings()")
    public void afterSuccessfulGet(JoinPoint joinPoint) {
        log.info("Successfully returned from GET service: {}", joinPoint.getSignature().toShortString());
    }

    // Logging when a GET method throws an exception
    @AfterThrowing("getMappings()")
    public void afterGetFailure(JoinPoint joinPoint) {
        log.error("GET service failed: {}", joinPoint.getSignature().toShortString());
    }

    // Logging before PUT/POST methods (setter methods) are called
    @Before("setMappings()")
    public void logBeforeSet(JoinPoint joinPoint) {
        log.info("Calling PUT/POST service: {}", joinPoint.getSignature().toShortString());
    }

    // Logging after PUT/POST methods successfully return
    @AfterReturning("setMappings()")
    public void afterSuccessfulSet(JoinPoint joinPoint) {
        log.info("Successfully returned from PUT/POST service: {}", joinPoint.getSignature().toShortString());
    }

    // Logging when a PUT/POST method throws an exception
    @AfterThrowing("setMappings()")
    public void afterSetFailure(JoinPoint joinPoint) {
        log.error("PUT/POST service failed: {}", joinPoint.getSignature().toShortString());
    }
}

