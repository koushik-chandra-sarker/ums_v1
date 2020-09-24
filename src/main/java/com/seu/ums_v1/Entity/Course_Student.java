package com.seu.ums_v1.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "course_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ssn")
@JsonPropertyOrder({ "ssn", "yearTaken", "semesterTaken", "gradeAward", "student", "courses" })
public class Course_Student{

    @Id
    private String Ssn;

    @ManyToOne
    @JoinColumn
    private Student student;


    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Lecturer_Course courses;

    private String courseTitle;

    private String yearTaken;
    private String semesterTaken;
    private String gradeAward;

}
