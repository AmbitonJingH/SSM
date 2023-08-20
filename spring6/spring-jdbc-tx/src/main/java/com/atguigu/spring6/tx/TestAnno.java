package com.atguigu.spring6.tx;
/*
 * @author  AmbitionJingH
 * @date  2023/8/20 10:41
 * @version 1.0
 */

import com.atguigu.spring6.tx.config.SpringConfig;
import com.atguigu.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnno {

    @Test
    public void testTxAllAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController accountService = applicationContext.getBean("bookController", BookController.class);
        Integer[] ids = {1,2};
        accountService.checkOut(ids,1);
    }
}
