package com.mytests.spring.springprogrammaticbeansinjections;

import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.servlet.function.RequestPredicates.*;
import static org.springframework.web.servlet.function.RouterFunctions.route;

public class MyController {

    private final Bean0 bean0;
    private final Bean3 bean3;
    private final MyDataRepo myDataRepo;
    public MyController(
            Bean0 bean0,
            Bean3 bean3,
            MyDataRepo myDataRepo) {
        this.bean0 = bean0;
        this.bean3 = bean3;
        this.myDataRepo = myDataRepo;
    }

    public RouterFunction<ServerResponse> routes() {
        return route(GET("/beans"), this::getBeans)
              .andRoute(GET("/data").and(accept(APPLICATION_JSON)), this::getData)
        ;
    }

    private ServerResponse getData(ServerRequest serverRequest) {

        myDataRepo.initDB();
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(myDataRepo.getData());
    }

    private ServerResponse getBeans(ServerRequest serverRequest) {
        String beans = "beans: " + bean0.usedBeans() + ", Bean3: " + bean3.getBean();
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(beans);
    }
}
