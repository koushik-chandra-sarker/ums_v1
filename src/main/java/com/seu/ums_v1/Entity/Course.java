package com.seu.ums_v1.Entity;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "code")
@JsonPropertyOrder({ "code", "title", "credit", "programme", "pre_course", "courses","lecturer_courses" })
public class Course implements Serializable {
    @Id
    private String Code;
    private String title;
    private int credit;

    @ManyToOne
    private Programme programme;

    @JsonBackReference
    public Programme getProgramme() {
        return programme;
    }

    /*@ManyToMany
    @JoinTable(
            name = "pre_course",
            joinColumns = @JoinColumn(name = "course_code"),
            inverseJoinColumns = @JoinColumn(name = "pre_course_code")
    )
    private List<Course> pre_course;*/


 /*   @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "pre_course",
            joinColumns = @JoinColumn(name = "pre_course_code"),
            inverseJoinColumns = @JoinColumn(name = "course_code")
    )
    @JsonIgnore
    private List<Course> courses;*/

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lecturer_Course> lecturer_courses = new ArrayList<>();


}
