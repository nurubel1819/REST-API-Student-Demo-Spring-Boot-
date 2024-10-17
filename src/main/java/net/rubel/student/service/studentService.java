package net.rubel.student.service;
import net.rubel.student.dto.studentDto;

import java.util.List;


public interface studentService {
    public studentDto addStudent(studentDto student_dto);
    public studentDto seeStudentById(Long id);
    public List<studentDto> seeAllStudent();
    public studentDto updateStudent(Long id,studentDto student_dto);
    public String deleteOneStudentInformation(Long id);
}
