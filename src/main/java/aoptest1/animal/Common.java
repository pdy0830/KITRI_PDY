package aoptest1.animal;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
	public void printAround(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("점심 뭐 먹었어요?");
			Object val = joinpoint.proceed();//핵심관심메소드=pointcut 실행하라.//System.out.println("xxx 먹었습니다."); 
			
			//마지막 클래스 이름만 분리하기
			String fullName=joinpoint.getTarget().getClass().getName(); //aoptest1.animal.Cat
			String[] splitNames = fullName.split("\\.");
			String className = splitNames[splitNames.length-1];
			
			System.out.println(className+" 님은 "+val+" 먹었군요.");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
