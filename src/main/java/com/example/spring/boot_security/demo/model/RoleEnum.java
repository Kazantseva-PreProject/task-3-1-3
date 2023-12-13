package com.example.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {

    ROLE_ADMIN ("ROLE_ADMIN"),

    ROLE_USER ("ROLE_USER");

    private final String authority;

    RoleEnum(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

}
