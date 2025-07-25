package com.cms.content_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegistrationCreateDto {

    private String name;


    private String email;


    private String password;


    private String mobile_number;


    private String role;

}
