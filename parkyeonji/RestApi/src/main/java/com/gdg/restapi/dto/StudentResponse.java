package com.gdg.restapi.dto;

import com.gdg.restapi.domain.Student;
import lombok.Getter;

@Getter
public class StudentResponse {
    private final Long id;
    private final String name;
    private final String number;
    private final String major;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.number = student.getNumber();
        this.major = student.getMajor();
    }
}
