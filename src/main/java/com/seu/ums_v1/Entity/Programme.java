package com.seu.ums_v1.Entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "code")
@JsonPropertyOrder({ "code", "title", "label", "length", "school", "students", "courses" })
public class Programme {

    @Id
    private String Code;
    private String Title;
    private String Label;
    private int Length;

    @ManyToOne
    private School school;


    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

   /* @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Course_code", referencedColumnName = "code")
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();
*/


}
