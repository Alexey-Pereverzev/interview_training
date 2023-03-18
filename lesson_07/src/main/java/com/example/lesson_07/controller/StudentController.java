package com.example.lesson_07.controller;

import com.example.lesson_07.converter.StudentConverter;
import com.example.lesson_07.service.StudentDto;
import com.example.lesson_07.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;
    private final StudentConverter converter;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return service.findAll().stream().map(converter::entityToDto).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewStudent(@RequestBody StudentDto studentDto) {
        service.createStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        service.changeById(id, studentDto.getFullName(), studentDto.getAge());
    }


}
