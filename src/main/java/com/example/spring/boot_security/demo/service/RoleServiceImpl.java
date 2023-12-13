package com.example.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.RoleEnum;
import ru.itmentor.spring.boot_security.demo.repository.RoleRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepositories;

    public RoleServiceImpl(RoleRepository roleRepositories) {
        this.roleRepositories = roleRepositories;
    }

    @Override
    public Set<RoleEnum> getRoles() {
        return roleRepositories.findAll().stream().map(Role::getRole).collect(Collectors.toSet());
    }
}