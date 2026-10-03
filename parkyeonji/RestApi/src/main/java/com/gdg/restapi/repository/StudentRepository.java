package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentRepository {
    private final Map<Long, Student> students = new HashMap<>();
    private long sequence = 0L;

    public StudentRepository() {
        save(new Student(null, "김석환", "202214139", "소프트웨어공학과"));
        save(new Student(null, "박연지", "202314044", "소프트웨어공학과"));
        save(new Student(null, "이우빈", "202014056", "소프트웨어공학과"));
    }

    public Student save(Student newStudent) {
        Student student = new Student(++sequence, newStudent.getName(),
                newStudent.getNumber(), newStudent.getMajor());
        students.put(student.getId(), student);
        return student;
    }

    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    public boolean delete(Long id) {
        return students.remove(id) != null;
    }
}
