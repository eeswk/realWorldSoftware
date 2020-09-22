package com.eeswan.software.ch05.step0;

public class Customer {
    private String name;
    private String jobTitle;

    public Customer(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
