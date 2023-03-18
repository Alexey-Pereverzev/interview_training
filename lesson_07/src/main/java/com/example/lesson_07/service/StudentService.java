package com.example.lesson_07.service;

import com.example.lesson_07.repository.StudentRepository;
import com.example.lesson_07.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public void createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFullName(studentDto.getFullName());
        student.setAge(studentDto.getAge());
        repository.save(student);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void changeById(Long id, String fullName, int age) {
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            createStudent(new StudentDto(id, fullName, age));
        } else {
            Student updated = student.get();
            updated.setAge(age);
            updated.setFullName(fullName);
            repository.save(updated);
        }
    }





}
