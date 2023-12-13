package com.example.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.model.RoleEnum;

import java.util.Set;

public interface RoleService {

    Set<RoleEnum> getRoles();

}
