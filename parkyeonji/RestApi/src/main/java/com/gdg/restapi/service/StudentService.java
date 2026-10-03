package com.gdg.restapi.service;

import com.gdg.restapi.domain.Student;
import com.gdg.restapi.dto.StudentRequest;
import com.gdg.restapi.dto.StudentResponse;
import com.gdg.restapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentResponse create(StudentRequest request) {
        Student student = new Student(null, request.getName(), request.getNumber(), request.getMajor());
        return new StudentResponse(studentRepository.save(student));
    }

    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(StudentResponse::new)
                .toList();
    }

    public StudentResponse findById(Long id) {
        return new StudentResponse(studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다.")));
    }

    public StudentResponse update(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        student.update(request.getName(), request.getNumber(), request.getMajor());
        return new StudentResponse(student);
    }

    public void delete(Long id) {
        if (!studentRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 학생입니다.");
        }
    }
}
