package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Entity
@Table(name = "user_account_single_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    private String username;
    private String ssn;
    private String secret;
    private String email;
    private String firstName;
    private String lastName;
    private String city;
    private Integer age;
}
