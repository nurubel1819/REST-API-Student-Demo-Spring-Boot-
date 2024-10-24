package net.rubel.student.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.rubel.student.service.studentService;
import net.rubel.student.dto.studentDto;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {

    //create object service
    studentService student_service;

    //dependency injection


    public studentController(studentService student_service) {
        this.student_service = student_service;
    }

    //add student information
    @PostMapping
    private ResponseEntity<studentDto> addStudentInformation(@RequestBody studentDto student_dto)
    {
        return new ResponseEntity<>(student_service.addStudent(student_dto), HttpStatus.CREATED);
    }

    //get or see a student
    @GetMapping("/{id}")
    private ResponseEntity<studentDto> getStudent(@PathVariable Long id)
    {
        return ResponseEntity.ok(student_service.seeStudentById(id));
    }

    //get all student
    @GetMapping("/all")
    private ResponseEntity<List<studentDto>> seeAllStudent()
    {
        return ResponseEntity.ok(student_service.seeAllStudent());
    }

    //update student information
    @PutMapping("/update/{id}")
    private ResponseEntity<studentDto> updateStudentInformation(@PathVariable Long id,@RequestBody studentDto student_dto)
    {
        return ResponseEntity.ok(student_service.updateStudent(id,student_dto));
    }

    //delete a student account using student ID
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteOneStudentInformation(@PathVariable Long id)
    {
        return ResponseEntity.ok(student_service.deleteOneStudentInformation(id));
    }

}
