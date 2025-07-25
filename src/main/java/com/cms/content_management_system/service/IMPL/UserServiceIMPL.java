package com.cms.content_management_system.service.IMPL;

import com.cms.content_management_system.dto.LoginDto;
import com.cms.content_management_system.dto.UserRegistrationCreateDto;
import com.cms.content_management_system.dto.UserRegistrationDto;
import com.cms.content_management_system.entity.UserRegistration;
import com.cms.content_management_system.repo.UserRepo;
import com.cms.content_management_system.service.UserService;
import com.cms.content_management_system.utility.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public String registerUser(UserRegistrationCreateDto userRegistrationDto) {

        System.out.println(userRegistrationDto.getName());
        System.out.println(userRegistrationDto.getEmail());
        System.out.println(userRegistrationDto.getPassword());
        System.out.println(userRegistrationDto.getMobile_number());
        System.out.println(userRegistrationDto.getRole());

       UserRegistration userRegistration = new UserRegistration(
               userRegistrationDto.getName(),
               userRegistrationDto.getEmail(),
               UserUtility.encryptPassword(userRegistrationDto.getPassword()),
               userRegistrationDto.getMobile_number(),
               userRegistrationDto.getRole()
       );

        userRepo.save(userRegistration);

        return userRegistration.getEmail();

    }

    @Override
    public Boolean login(LoginDto loginDto) {

        String email = loginDto.getEmail();
        String password = loginDto.getPassword();

        UserRegistration userRegistration = userRepo.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("Username not found : " + email));

        return UserUtility.checkPassword(password, userRegistration.getPassword());

    }

    @Override
    public String getRole(String email) {
        UserRegistration userRegistration = userRepo.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("Username not found : " + email));

        return userRegistration.getRole();
    }


}
