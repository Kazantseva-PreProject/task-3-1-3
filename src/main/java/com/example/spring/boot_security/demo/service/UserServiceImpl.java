package com.example.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.dao.UserDAO;
import ru.itmentor.spring.boot_security.demo.model.RoleEnum;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.util.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDao;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        Optional<List<User>> userList = Optional.ofNullable(userDao.allUser());
        return userList.orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User showUser(long id) {
        Optional<User> user = Optional.ofNullable(userDao.showUser(id));
        return user.orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);

    }

    @Override
    public void updateUser(long id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<RoleEnum> getAllRoles() {
        Optional<List<RoleEnum>> roles = Optional.ofNullable(userDao.getAllRoles());
        return roles.orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<List<RoleEnum>> roles = Optional.ofNullable(userDao.getRoleByUsername(username));
        return (User) roles.orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<RoleEnum> getRoleByUsername(String username) {
        Optional<List<RoleEnum>> roles = Optional.ofNullable(userDao.getRoleByUsername(username));
        return roles.orElseThrow(UserNotFoundException::new);
    }


}


