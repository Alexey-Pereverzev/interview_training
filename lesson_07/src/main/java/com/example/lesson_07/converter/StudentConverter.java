package com.example.lesson_07.converter;

import com.example.lesson_07.entity.Student;
import com.example.lesson_07.service.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    public StudentDto entityToDto(Student s) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(s.getId());
        studentDto.setFullName(s.getFullName());
        studentDto.setAge(s.getAge());
        return studentDto;
    }
}
