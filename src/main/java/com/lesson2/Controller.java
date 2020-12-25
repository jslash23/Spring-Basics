package com.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller

public class Controller {
/*
    @Autowired
    private Route route;

    @Autowired
    private Service service;

    @Autowired
    private Step step;



    @RequestMapping(method = RequestMethod.GET, value = "/get", produces = "text/plain")
    public @ResponseBody String callByBean() {
        route.setId(1L);
        route.setSteps(null);

        service.setId(2L);
        service.setName("Slugba");
        service.setPeramsToCall(null);

        step.setId(3L);
        step.setServiceFrom(service);
        step.setServiceTo(service);


        route.getId();
        route.getSteps();

        service.getId();
        service.getName();
        service.getPeramsToCall();

        step.getId();
        step.getParamsServiceFrom();
        step.getParamsServiceTo();
        step.getServiceFrom();
        step.getServiceTo();
        return "All getters was called";
    }*/
}
