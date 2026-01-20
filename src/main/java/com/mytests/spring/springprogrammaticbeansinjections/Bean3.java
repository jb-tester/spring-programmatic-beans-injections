package com.mytests.spring.springprogrammaticbeansinjections;


public class Bean3 {
    private final Bean4 bean;

    public Bean3(Bean4 bean) {
        this.bean = bean;
    }

    public Bean4 getBean() {
        return bean;
    }
}
