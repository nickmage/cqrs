package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_single_table_view")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserView {
    @Id
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String city;
    private Integer age;
}
