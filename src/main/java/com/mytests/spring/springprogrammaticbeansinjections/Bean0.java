package com.mytests.spring.springprogrammaticbeansinjections;


import org.springframework.beans.factory.annotation.Autowired;

public class Bean0 {

    @Autowired Bean1 b1;
    @Autowired Bean2 b2;

    public String usedBeans() {

        return "Bean0: bean1 " + b1.getId() + ", bean2 " + b2.getId();
    }
}
