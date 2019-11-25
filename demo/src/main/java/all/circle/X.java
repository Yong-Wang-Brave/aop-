package all.circle;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class X {


    @Autowired
    Y y;

    public X() {

        System.out.println("创建x");
    }

    @Pointcut("execution(public int all.circle.Z.*(..))")
    public void pointCut() {
    }


    //@before代表在目标方法执行前切入, 并指定在哪个方法前切入
    @Before("pointCut()")
    public void logStart() {
        System.out.println("除法运行....参数列表是:{}");
    }
}



