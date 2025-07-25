package com.cms.content_management_system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

    private int user_id;


    private String name;


    private String email;


    private String password;


    private String mobile_number;


    private String role;




}
