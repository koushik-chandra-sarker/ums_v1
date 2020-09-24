package com.seu.ums_v1.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "lecturer_course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ssn")
public class Lecturer_Course{

    @Id
    private String Ssn;

    @ManyToOne
    @JoinColumn
    private Lecturer lecturer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Course course;

    @OneToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private List<Course_Student> course_students = new ArrayList<>();


}
