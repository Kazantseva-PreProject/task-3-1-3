package com.example.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itmentor.spring.boot_security.demo.dao.UserDAO;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.RoleEnum;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.repository.RoleRepository;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class UserDataInit {
    private final UserDAO userDao;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataInit(UserDAO userDao, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        Role adminRole = new Role(RoleEnum.ROLE_ADMIN);
        Role userRole = new Role(RoleEnum.ROLE_USER);

        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        User admin = new User("admin", passwordEncoder.encode("admin"));
        User user = new User("user", passwordEncoder.encode("user"));

        admin.setRoles(Set.of(adminRole));
        user.setRoles(Set.of(userRole));

        userDao.addUser(admin);
        userDao.addUser(user);
    }
}
