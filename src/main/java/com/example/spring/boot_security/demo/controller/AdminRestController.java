package com.example.spring.boot_security.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.dto.UserDTO;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;
import ru.itmentor.spring.boot_security.demo.util.UserExcHandler;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminRestController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    private final UserExcHandler userHandler;

    public AdminRestController(UserService userService,
                               ModelMapper modelMapper,
                               UserExcHandler userHandler) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userHandler = userHandler;
    }

    @GetMapping()
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.showUser(id);
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> createUser(@RequestBody @Valid UserDTO userDTO,
                                                 BindingResult bindingResult) {
        userHandler.checkUserNotFoundExc(bindingResult);
        userService.saveUser(convertToUser(userDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody @Valid UserDTO userDTO,
                                                 @PathVariable("id") Long id,
                                                 BindingResult bindingResult) {
        userHandler.checkUserNotFoundExc(bindingResult);
        userService.updateUser(id, convertToUser(userDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> removeUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
