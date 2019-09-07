package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类定义
 * @Aspect
 *  告诉Spring当前类是切面类
 */

@Aspect
public class LogAspects {

    //抽取公共的切入点表达式，使用@PointCut注解
    //1.如果是本类中使用，直接在具体切入点指定方法名，如 @After("pointCut()")
    //2.在其他类中使用，在切入点指定全名，如 @AfterReturning("aop.LogAspects.pointCut()")
    @Pointcut("execution(public int MathCalculator.*(..))")
    public void pointCut(){}

    //5.给切面类的方法标注 何时何地执行，即通知注释
    //@Before 表示在目标方法执行前切入，参数=切入点表达式（MathCalculator.div(int i, int j)）
    //切入点表达式：所有方法，所有参数（MathCalculator.*(..)）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        //获取执行的方法名：joinPoint.getSignature().getName()
        //获取执行的方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+ "开始。。。@Before参数列表是：{"+ Arrays.asList()+ "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+ "结束。。。@After");
    }

    //参数JoinPoint joinPoint，一定在参数列表的第一位，否则会报错
    @AfterReturning(value = "aop.LogAspects.pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){
        System.out.println(joinPoint.getSignature().getName() + "返回。。。@AfterReturning返回结果是：{"+ result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception){
        System.out.println(joinPoint.getSignature().getName() + "异常。。。@AfterThrowing异常信息是：{"+ exception + "}");
    }
}
