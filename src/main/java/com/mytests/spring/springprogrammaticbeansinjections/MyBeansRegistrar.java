package com.mytests.spring.springprogrammaticbeansinjections;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.function.RouterFunction;

public class MyBeansRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment environment) {
        registry.registerBean("bean0", Bean0.class);
        registry.registerBean("bean1", Bean1.class, customizer -> customizer.supplier(
                ctx -> new Bean1("b1") {
                }
        ));
        registry.registerBean("bean2", Bean2.class, customizer -> customizer.supplier(
                ctx -> new Bean2("b2") {
                }
        ));
        registry.registerBean("bean4", Bean4.class);
        registry.registerBean("bean3", Bean3.class,
                customizer -> {
                    customizer.supplier(
                            context -> new Bean3(
                                    context.bean(Bean4.class)));
                });
        registry.registerBean("myDataRepo", MyDataRepo.class);
        registry.registerBean("myController", MyController.class);
        registry.registerBean(
                RouterFunction.class,
                ( spec -> spec
                        .supplier(ctx -> ctx.bean(MyController.class).routes())
                ));
    }
}