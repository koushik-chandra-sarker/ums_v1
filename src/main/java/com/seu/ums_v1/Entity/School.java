package com.seu.ums_v1.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "school")
@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonPropertyOrder({"id", "name", "campus", "programme", "lecturers"})
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Name;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private Campus Campus;

    @JsonBackReference
    public Campus getCampus() {
        return Campus;
    }

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<Programme> programme = new ArrayList<>();

    @OneToMany(mappedBy = "school",fetch = FetchType.EAGER)
    private List<Lecturer> lecturers = new ArrayList<>();

}
