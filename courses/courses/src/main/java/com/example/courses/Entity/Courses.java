package com.example.courses.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String language;
    String instructorName;
    Date UpdatedDate;
    Date createDate;
    Boolean isActive;

    @OneToOne(mappedBy = "courses", cascade = CascadeType.ALL)
    Instructor instructor;

}
