package com.cms.content_management_system.service;

import com.cms.content_management_system.dto.LoginDto;
import com.cms.content_management_system.dto.UserRegistrationCreateDto;
import com.cms.content_management_system.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {
    String registerUser(UserRegistrationCreateDto userRegistrationDto);


    Boolean login(LoginDto loginDto);

    String getRole(String email);
}
