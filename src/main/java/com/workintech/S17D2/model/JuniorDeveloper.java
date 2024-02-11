package com.workintech.S17D2.model;

import com.workintech.S17D2.Experience;

public class JuniorDeveloper extends Developer{
    public JuniorDeveloper(Integer id, String name, Double salary) {
        super(id, name, salary, Experience.JUNIOR);
    }
}
