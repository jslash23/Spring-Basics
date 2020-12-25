package com.lesson2;

import java.util.List;

public class Service {

    /*
    Класс Service с полями: Long id, String name, List<String> paramsToCall
     */
    private Long id;
    private String name;
    private List<String> peramsToCall;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPeramsToCall() {
        return peramsToCall;
    }

    public void setPeramsToCall(List<String> peramsToCall) {
        this.peramsToCall = peramsToCall;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", peramsToCall=" + peramsToCall +
                '}';
    }
}
