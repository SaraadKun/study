package com.saraad.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
<<<<<<< HEAD
<<<<<<< HEAD
import org.aspectj.lang.annotation.After;
=======
>>>>>>> 791173b9be1a914c82554e2e1131c9a4fcdb5e3e
=======
import org.aspectj.lang.annotation.After;
>>>>>>> fa51c670b35efebc87aaba50e5e64f5af288b647
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: ServiceLog
 * @Package:com.saraad.common.aop
 * @Description:
 * @author: saraad
 * @date: 2018/11/8 7:11
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */

@Component
@Aspect
public class ServiceLog {

    @Pointcut("execution(* com.saraad.service..*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        Signature signature = joinPoint.getSignature();
        if(!(signature instanceof MethodSignature))
            throw new IllegalArgumentException("非实现类方法");
        MethodSignature ms = (MethodSignature) signature;
        Method method = ms.getMethod();
        System.out.println("正在执行:"+target.getClass().getName()+"_"+method.getName());
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> fa51c670b35efebc87aaba50e5e64f5af288b647
    @After("log()")
    public void  doAfter(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        Signature signature = joinPoint.getSignature();
        if(!(signature instanceof MethodSignature))
            throw new IllegalArgumentException("非实现类方法");
        MethodSignature ms = (MethodSignature) signature;
        Method method = ms.getMethod();
        System.out.println(target.getClass().getName()+"_"+method.getName()+"执行完毕");

    }

<<<<<<< HEAD
=======
>>>>>>> 791173b9be1a914c82554e2e1131c9a4fcdb5e3e
=======
>>>>>>> fa51c670b35efebc87aaba50e5e64f5af288b647
}
