package com.target;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {MyRetailServiceApplication.class})
@EnableAutoConfiguration
public class MyRetailServiceApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(MyRetailServiceApplication.class).run(args);

    }

}



