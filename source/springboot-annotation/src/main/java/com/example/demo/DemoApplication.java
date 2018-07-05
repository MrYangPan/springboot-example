package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动方式：
 * <p>
 * 1.@EnableAutoConfiguration 注解：自动装配，默认扫包范围是当前类，缺点：不通用，每个类都要加注解
 * <p>
 * 2.@ComponentScan 注解：扫包范围，扫包范围要精确，范围大影响性能,缺点：如果扫包很多的话，写起来麻烦
 * <p>
 * 3.@SpringBootApplication 注解：等同于  @EnableAutoConfiguration  +  @ComponentScan 同级包和当前包
 */

@SpringBootApplication
//@EnableAutoConfiguration
@MapperScan({"com.example.demo.mapper",""})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
