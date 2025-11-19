package com.example.courses.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Courses {
    Integer id;
    String name;
    String language;
    String instructorName;
    Date UpdatedDate;
    Date createDate;
    Boolean isActive;
}
