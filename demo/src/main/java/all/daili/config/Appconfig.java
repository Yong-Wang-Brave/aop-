package all.daili.config;


import all.circle.X;
import all.circle.Z;
import all.daili.aop.Calculator;
import all.daili.aop.LogAspects;
import org.springframework.context.annotation.*;


@ComponentScan(value="all.circle")

@Configuration
@EnableAspectJAutoProxy
public class Appconfig {

    //烧苗出来  与下面直接定义是等价的
/*    @Bean
    public Z z() {
        return new Z();
    }

    @Bean
    public X x() {
        return new X();
    }*/
}
