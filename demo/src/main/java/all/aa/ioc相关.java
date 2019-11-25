package all.aa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ioc相关 {



    public static void main(String[] args) {


        AnnotationConfigApplicationContext  aa = new AnnotationConfigApplicationContext();
        aa.getBean(Student.class);
    }





    }


