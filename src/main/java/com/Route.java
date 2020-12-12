package com;

import java.util.List;

public class Route {


    private Long id;
    private List<Step> steps;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", steps=" + steps +
                '}';
    }
}
