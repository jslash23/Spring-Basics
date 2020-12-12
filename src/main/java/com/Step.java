package com;

import java.util.Map;

public class Step {
    /*
    Класс Step с полями: Long id, Service serviceFrom, Service serviceTo,
    Map<String, String> paramsServiceFrom, Map<String, String> paramsServiceTo
     */

    private Long id;
    private Service serviceFrom;
    private Service serviceTo;
    private Map<String, String> paramsServiceFrom;
    private Map<String, String> paramsServiceTo;

    public Step(Long id, Service serviceFrom, Service serviceTo, Map<String, String> paramsServiceFrom, Map<String, String> paramsServiceTo) {
        this.id = id;
        this.serviceFrom = serviceFrom;
        this.serviceTo = serviceTo;
        this.paramsServiceFrom = paramsServiceFrom;
        this.paramsServiceTo = paramsServiceTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Service getServiceFrom() {
        return serviceFrom;
    }

    public void setServiceFrom(Service serviceFrom) {
        this.serviceFrom = serviceFrom;
    }

    public Service getServiceTo() {
        return serviceTo;
    }

    public void setServiceTo(Service serviceTo) {
        this.serviceTo = serviceTo;
    }

    public Map<String, String> getParamsServiceFrom() {
        return paramsServiceFrom;
    }

    public void setParamsServiceFrom(Map<String, String> paramsServiceFrom) {
        this.paramsServiceFrom = paramsServiceFrom;
    }

    public Map<String, String> getParamsServiceTo() {
        return paramsServiceTo;
    }

    public void setParamsServiceTo(Map<String, String> paramsServiceTo) {
        this.paramsServiceTo = paramsServiceTo;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", serviceFrom=" + serviceFrom +
                ", serviceTo=" + serviceTo +
                ", paramsServiceFrom=" + paramsServiceFrom +
                ", paramsServiceTo=" + paramsServiceTo +
                '}';
    }
}
