package com.mytests.spring.springprogrammaticbeansinjections;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(MyBeansRegistrar.class)
class MyRegistrarConfiguration {

    public MyRegistrarConfiguration() {

    }
}
