package com.mytests.spring.springprogrammaticbeansinjections;


import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class MyDataRepo {

    private final EntityManager entityManager;

    public MyDataRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<String> getData(){
        List<String> result = new ArrayList<>();
        List<MyData> resultList = entityManager.createNativeQuery("select * from foo", MyData.class).getResultList();
        resultList.forEach(data -> result.add(data.toString()));
        return result;
    };

    @Transactional
    public void initDB() {
        entityManager.persist(new MyData("aaa", "bbb", 20));
        entityManager.persist(new MyData("ccc", "ddd", 30));
        entityManager.persist(new MyData("eee", "fff", 40));
    }
}
