package com.example.spring.boot_security.demo.dto;

public class RoleDTO  {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
               "role='" + role + '\'' +
               '}';
    }
}
