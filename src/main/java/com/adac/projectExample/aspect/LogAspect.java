package com.adac.projectExample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut("execution(* com.adac.projectExample.service.*.getAll*(..))")
	public void getAllPointCut() {}
	
	@Pointcut("execution(* com.adac.projectExample.service.*.delete*(String))")
	public void deleteByIdPointCut() {}
	
	@Pointcut("execution(* com.adac.projectExample.service.*.save*(..))")
	public void savePointCut() {}
    
    @Around("getAllPointCut()")
    public Object logGetAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
    	String methodName = joinPoint.getSignature().getName();
    	String modelsTypesName = methodName.replace("getAll", "");
    	LOGGER.info("** SEARCHING ALL {} **", modelsTypesName.toUpperCase());
        Object result = joinPoint.proceed();
        return result;
    }
    
    @Around("deleteByIdPointCut()")
    public Object logDeleteBydIdMethods(ProceedingJoinPoint joinPoint) throws Throwable {
    	String methodName = joinPoint.getSignature().getName();
    	String argId = (String)joinPoint.getArgs()[0];
    	String modelsTypesName = methodName.replace("delete", "");
    	LOGGER.info("** DELETE {} BY ID {} **", modelsTypesName.toUpperCase(), argId);
    	Object result = joinPoint.proceed();
    	return result;
    }
    
    @Around("savePointCut()")
    public Object logSaveModelsMethods(ProceedingJoinPoint joinPoint) throws Throwable {
    	String methodName = joinPoint.getSignature().getName();
    	String modelsTypesName = methodName.replace("save", "");
    	LOGGER.info("** SAVE NEW {} **", modelsTypesName.toUpperCase());
    	Object result = joinPoint.proceed();
    	return result;
    }
}