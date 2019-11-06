package com.HuJuHomePage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.HuJuHomePage")
@MapperScan("com.HuJuHomePage.mappers")
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}
