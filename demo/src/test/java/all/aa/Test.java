package all.aa;

import all.circle.Z;
import all.daili.aop.Calculator;
import all.daili.config.Appconfig;
import all.circle.X;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= Appconfig.class)
//@SpringBootTest
public class Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

       /// ac.register(Cap10MainConfig.class);
        ac.register(Appconfig.class);
        ac.refresh();
        //此处的Z是一个cglib动态代理对象
       Z zz = ac.getBean(Z.class);
        zz.ad();

/*    Calculator c = ac.getBean(Calculator.class);
        int result = c.div(4, 3);
        System.out.println(result+"wangyong");
        ac.close();*/


    }}
