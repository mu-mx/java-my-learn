package com.xwcom.crud;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2024/11/2
 * @description 必须加上@Component注解，否则无法被Spring容器扫描到
 */


/**
 * 多个类的时候，Spring容器会自动扫描到所有的类，但是如果没有@Component注解
 * 可以找到该类，但是无法注入到容器中
 *
 * @Primary() 如果有多个实现类，可以使用@Primary注解，表示优先注入该实现类
 * @Qualifier("") 小写的类名 用于指定注入的实现类
 * @Resource(name = "dev") 用于指定注入的实现类
 * @Autowired 用于指定注入的实现类
 * @Autowired(required = false) 用于指定注入的实现类
 */
@Component

public class Dev {

    public void test() {
        System.out.println("test");
    }
}
