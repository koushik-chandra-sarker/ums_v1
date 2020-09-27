package com.seu.ums_v1.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@ToString
@JsonPropertyOrder({"id","firstName","middleName","lastName","email", "birthday",
        "gender", "yearEnrolled", "phone", "programme", "Reg_courses","user"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Email;
    private LocalDate Birthday;
    private String Gender;
    private int YearEnrolled;
    private String bloodGroup;
    private String maritalStatus;
    private String religion;
    private String nationality;
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<Phone> phone = new ArrayList<>();

    @ManyToOne
    private Programme programme;

    @JsonBackReference
    public Programme getProgramme() {
        return programme;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Course_Student> Reg_courses = new ArrayList<>();

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private User user;

}
