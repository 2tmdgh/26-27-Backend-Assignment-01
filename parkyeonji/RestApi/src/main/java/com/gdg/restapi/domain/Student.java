package com.gdg.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String number;
    private String major;

    public void update(String name, String number, String major) {
        if (name != null) {
            this.name = name;
        }
        if (number != null) {
            this.number = number;
        }
        if (major != null) {
            this.major = major;
        }
    }
}
