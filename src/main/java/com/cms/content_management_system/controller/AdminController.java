package com.cms.content_management_system.controller;


import com.cms.content_management_system.dto.ContentTypeCreateDto;
import com.cms.content_management_system.dto.ContentTypeDto;


import com.cms.content_management_system.dto.UserRegistrationDto;
import com.cms.content_management_system.service.AdminService;

import com.cms.content_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;



    @PostMapping(path = "/contentTypeSave")
    public ResponseEntity<String> contentTypeSave(@RequestBody ContentTypeCreateDto contentTypeCreateDto)
    {
        Boolean saveStatus = adminService.saveContentType(contentTypeCreateDto);

        if(saveStatus==true)
        {
            return ResponseEntity.ok( "Content type saved!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save content type!");
        }

    }

    @GetMapping(path = "/getContentType/{content_id}")
    public ResponseEntity<ContentTypeDto> getContentType(@PathVariable("content_id") int content_id)
    {
        ContentTypeDto contentType = adminService.getContentType(content_id);
        return ResponseEntity.ok(contentType);

    }

    @GetMapping(path = "/getAllContentType")
    public ResponseEntity<List<ContentTypeDto>> getAllContentType()
    {
        List<ContentTypeDto> allContetntType = adminService.getAllContentType();
        return ResponseEntity.ok(allContetntType);

    }

    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<UserRegistrationDto>> getAllUsers()
    {
        List<UserRegistrationDto> allUsers = adminService.getAllUsers();
        return ResponseEntity.ok(allUsers);

    }

    @PutMapping(path = "/updateContentType")
    public ResponseEntity<String> updateContentType(@RequestBody ContentTypeDto contentTypeDto)
    {
        Boolean updateStatus = adminService.updateContentType(contentTypeDto);
        if( updateStatus == true)
        {
            return ResponseEntity.ok("Content Type Update Successful!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Content Type Updation Failed!");
        }

    }

    @DeleteMapping(path = "/deleteContentType/{content_id}")
    public ResponseEntity<String> deleteContentType(@PathVariable(value = "content_id")int content_id)
    {
        Boolean deleteStatus = adminService.deleteContentType(content_id);
        if( deleteStatus == true)
        {
            return ResponseEntity.ok("Profile Deletion Successful!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Profile Deletion Failed!");
        }

    }

    @DeleteMapping(path = "/deleteUser/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "user_id")int user_id)
    {
        Boolean deleteStatus = adminService.deleteUser(user_id);
        if( deleteStatus == true)
        {
            return ResponseEntity.ok("User Deletion Successful!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Deletion Failed!");
        }

    }

    @PutMapping(path = "/updateUserDetails")
    public ResponseEntity<String> updateUserDetails(@RequestBody UserRegistrationDto userRegistrationDto)
    {
        Boolean updateStatus = adminService.updateUserDetails(userRegistrationDto);
        if( updateStatus == true)
        {
            return ResponseEntity.ok("User updation successful!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User updation Failed!");
        }

    }

}
