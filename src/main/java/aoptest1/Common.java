package aoptest1;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
//board, member 클래스에 공통적으로
	public void print() {
		System.out.println("<====메소드를 시작합니다.====>");
	}
	public void printresult(Object val) {
		//printcut선택대상메소드 수행 종료 - 리턴값 활용
		System.out.println("<====메소드 수행 후 리턴값="+val+"====>");                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	}
	public void printAround(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("<====메소드를 시작합니다.====>");
			Object val = joinpoint.proceed();//핵심관심메소드=pointcut 실행하라.
			System.out.println("객체이름="+joinpoint.getTarget());
			System.out.println("메소드이름="+joinpoint.toShortString());
			System.out.println("실행결과="+val);
			System.out.println("<====메소드를 종료합니다.====>");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
