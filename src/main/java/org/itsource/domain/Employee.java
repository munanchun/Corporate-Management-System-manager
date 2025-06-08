package org.itsource.domain;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String salt;
    private String age;
    private String state;
}
