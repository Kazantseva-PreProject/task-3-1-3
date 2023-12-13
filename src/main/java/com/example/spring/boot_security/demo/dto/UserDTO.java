package com.example.spring.boot_security.demo.dto;


import java.util.Set;

public class UserDTO {

    private String name;

    private String surname;

    private int age;

    private int salary;

    private Set<RoleDTO> roles;


    public UserDTO() {
    }

    public UserDTO(String name, String surname, int age, int salary, Set<RoleDTO> roles) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

}
