package net.rubel.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class studentDto {
    private Long id;
    private String name;
    private String address;
}
