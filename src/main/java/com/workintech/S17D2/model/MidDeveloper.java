package com.workintech.S17D2.model;

import com.workintech.S17D2.Experience;

public class MidDeveloper extends Developer{
    public MidDeveloper(Integer id, String name, Double salary) {
        super(id, name, salary, Experience.MID);
    }
}
