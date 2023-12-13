package com.example.spring.boot_security.demo.util.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itmentor.spring.boot_security.demo.dto.RoleDTO;
import ru.itmentor.spring.boot_security.demo.dto.UserDTO;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.RoleEnum;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;

import java.util.HashSet;
import java.util.Set;

@Component
public class DTOConverter {
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    @Autowired
    public DTOConverter(ModelMapper modelMapper, RoleService roleService) {
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }


    public UserDTO convertFromUserToUserDTOResponse(User user) {
        UserDTO userDTO = new ModelMapper().map(user, UserDTO.class);
        Set<RoleDTO> roleDTOList = new HashSet<>();
        for (Role role : user.getRoles()) {
            roleDTOList.add(modelMapper.map(role, RoleDTO.class));
        }
        userDTO.setRoles(roleDTOList);
        return userDTO;
    }

    public User convertFromUserRequestToUser(UserDTO userDTO) {
        User newUser = modelMapper.map(userDTO, User.class);
        newUser.setRoles(new HashSet<>());

        for (RoleEnum roleEnum : roleService.getRoles()) {
            if (userDTO.getRoles().toString().contains(roleEnum.getAuthority())) {
                newUser.getRoles().add(new Role(roleEnum));
            }
        }

        return newUser;
    }
}
