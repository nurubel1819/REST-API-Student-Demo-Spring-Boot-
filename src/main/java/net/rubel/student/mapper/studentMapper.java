package net.rubel.student.mapper;
import net.rubel.student.entity.studentEntity;
import net.rubel.student.dto.studentDto;

public class studentMapper {
    public static studentEntity mapToEntity(studentDto student_dto)
    {
        return new studentEntity(student_dto.getId(),student_dto.getName(),student_dto.getAddress());
    }
    public static studentDto mapToDto(studentEntity student_entity)
    {
        return new studentDto(student_entity.getId(),student_entity.getName(),student_entity.getAddress());
    }
}
