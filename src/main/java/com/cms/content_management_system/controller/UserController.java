package com.cms.content_management_system.controller;

import com.cms.content_management_system.dto.LoginDto;
import com.cms.content_management_system.dto.UserRegistrationCreateDto;
import com.cms.content_management_system.dto.UserRegistrationDto;
import com.cms.content_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationCreateDto userRegistrationCreateDto)
    {
        String username = userService.registerUser(userRegistrationCreateDto);
        return ResponseEntity.ok(username + ": user registered successfully");
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto)
    {
        Boolean loginStatus = userService.login(loginDto);


        if (loginStatus) {

            String role = userService.getRole(loginDto.getEmail());

            Map<String, String> response = new HashMap<>();
            response.put("email", loginDto.getEmail());
            response.put("role", role);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");


        }


    }




}
