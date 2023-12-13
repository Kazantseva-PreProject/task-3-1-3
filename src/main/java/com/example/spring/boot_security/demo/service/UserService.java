package com.example.spring.boot_security.demo.service;


import ru.itmentor.spring.boot_security.demo.model.RoleEnum;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User showUser(long id);

    void saveUser(User user);

    void updateUser(long id, User user);

    void removeUserById(long id);

    List<RoleEnum> getAllRoles();

    User getUserByUsername(String username);

    List<RoleEnum> getRoleByUsername(String username);
}
