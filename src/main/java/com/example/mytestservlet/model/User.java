package com.example.mytestservlet.model;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String company;


}
