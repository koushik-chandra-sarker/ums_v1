package com.seu.ums_v1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "superuser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Superuser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    @Column(nullable = false, unique = true)
    private String Email;

    public Superuser(String firstName, String middleName, String lastName, String email) {
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Email = email;
    }


    @OneToOne(mappedBy = "superuser",cascade = CascadeType.ALL)
    private User user;
}
