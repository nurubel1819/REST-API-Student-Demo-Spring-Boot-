package net.rubel.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student_Information")
public class studentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_id")
    private Long id;
    @Column(name = "Student_name")
    private String name;
    @Column(name = "Student_address")
    private String address;
}
