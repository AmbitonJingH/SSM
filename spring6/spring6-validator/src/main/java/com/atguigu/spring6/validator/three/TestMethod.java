package com.atguigu.spring6.validator.three;
/*
 * @author  AmbitionJingH
 * @date  2023/8/21 10:16
 * @version 1.0
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMethod {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = context.getBean(MyService.class);
        User user = new User();
        user.setName("lucy");
        user.setPhone("13333333333");
        user.setAddress("山东菏泽 曹县");
        String tested = service.testMethod(user);

    }
}
