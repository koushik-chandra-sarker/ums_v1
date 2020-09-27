package com.seu.ums_v1.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonPropertyOrder({"id","name","address","school"})
public class Campus{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Name;
    private String Address;

    @OneToMany(mappedBy ="Campus",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.DETACH},
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<School> school;






}
