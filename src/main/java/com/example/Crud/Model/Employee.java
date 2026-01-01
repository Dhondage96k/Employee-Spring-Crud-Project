package com.example.Crud.Model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import jdk.jfr.Name;
import lombok.Data;

@Entity
@Data // it automatically creates getter setter , tostring
@Table(name ="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name",nullable = false)
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email")
    private String email;

}
