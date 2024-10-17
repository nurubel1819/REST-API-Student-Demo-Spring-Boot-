package net.rubel.student.service.impl;
import net.rubel.student.dto.studentDto;
import net.rubel.student.service.studentService;
import org.springframework.stereotype.Service;
import net.rubel.student.repository.studentRepository;
import net.rubel.student.entity.studentEntity;
import net.rubel.student.mapper.studentMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class studentServiceImpl implements studentService{

    //create object for data access in database
    studentRepository student_repository;

    //dependency injection
    public studentServiceImpl(studentRepository student_repository) {
        this.student_repository = student_repository;
    }

    @Override
    public studentDto addStudent(studentDto student_dto) {
        studentEntity student = studentMapper.mapToEntity(student_dto);
        studentEntity save_student = student_repository.save(student);
        return studentMapper.mapToDto(save_student);
    }

    @Override
    public studentDto seeStudentById(Long id) {
        studentEntity student = student_repository.findById(id).orElseThrow(()->new RuntimeException("This id not found"));
        return studentMapper.mapToDto(student);
    }

    @Override
    public List<studentDto> seeAllStudent() {
        List<studentEntity> all_student = student_repository.findAll();

        // convert student_entity_list to student_dto_list
        return all_student.stream().map(studentMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public studentDto updateStudent(Long id, studentDto student_dto) {
        studentEntity student = new studentEntity(id,student_dto.getName(),student_dto.getAddress());
        studentEntity update_student = student_repository.save(student);
        return studentMapper.mapToDto(update_student);
    }

    @Override
    public String deleteOneStudentInformation(Long id) {
        studentEntity student = student_repository.findById(id).orElseThrow(()-> new RuntimeException("This student is not found in database"));
        student_repository.deleteById(id);
        return "Delete student account successfully";
    }

}
