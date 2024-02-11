package com.workintech.S17D2.model;

import com.workintech.S17D2.Experience;

public class SeniorDeveloper extends Developer{
    public SeniorDeveloper(Integer id, String name, Double salary) {
        super(id, name, salary, Experience.SENIOR);
    }
}
