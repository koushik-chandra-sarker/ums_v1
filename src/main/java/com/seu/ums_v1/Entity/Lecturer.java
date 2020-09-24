package com.seu.ums_v1.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonPropertyOrder({"id", "firstName", "middleName", "lastName", "email", "title", "birthday",
        "gender", "joiningDate", "officeRoom", "phone", "school", "supervisor", "lecturer", "lecturer_courses"})
public class Lecturer{
    @Id
    @GeneratedValue
    private long Id;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    @Column(unique = true,nullable = false)
    private String initial;
    private String Email;
    private String Title;
    private LocalDate Birthday;
    private String Gender;
    private LocalDate joiningDate;
    private String officeRoom;
    private String maritalStatus;
    private String religion;
    private String nationality;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    private List<Phone> phone;


    @ManyToOne
    private School school;

    @ManyToOne
    @JoinColumn
    private Lecturer supervisor;

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lecturer> lecturer = new ArrayList<>();

    @OneToMany(mappedBy = "lecturer",cascade = CascadeType.ALL)
    private List<Lecturer_Course> lecturer_courses = new ArrayList<>();


    @OneToOne(mappedBy = "lecturer", cascade = CascadeType.ALL)
    private User user;

}
