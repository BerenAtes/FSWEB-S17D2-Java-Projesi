package com.workintech.S17D2.dto;

import com.workintech.S17D2.Experience;

public record DeveloperResponse(String message,Integer id, String name, Double salary, Experience experience) {
}
