package com.example.spring.boot_security.demo.dao;



import ru.itmentor.spring.boot_security.demo.model.RoleEnum;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {

    List<User> allUser();

    User showUser(long id);

    void addUser(User user);

    void updateUser(long id, User user);

    void removeUserById(long id);

    List<RoleEnum> getAllRoles();

    User getUserByUsername(String username);

    List<RoleEnum> getRoleByUsername(String username);

}
