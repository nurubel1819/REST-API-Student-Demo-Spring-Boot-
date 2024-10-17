package net.rubel.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.rubel.student.entity.studentEntity;

public interface studentRepository extends JpaRepository<studentEntity,Long> {
}
