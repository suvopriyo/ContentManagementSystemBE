package com.cms.content_management_system.controller;

import com.cms.content_management_system.dto.ClientAdvertisementDto;
import com.cms.content_management_system.dto.ContentTypeDto;
import com.cms.content_management_system.dto.ContentWriterProfileCreateDto;
import com.cms.content_management_system.dto.ContentWriterProfileDto;
import com.cms.content_management_system.service.ContentWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/contentWriter")
public class ContentWriterController {

    @Autowired
    private ContentWriterService contentWriterService;

    @PostMapping(path = "/contentWriterProfileCreation")
    public ResponseEntity<String> contentWriterProfileCreation(@RequestBody ContentWriterProfileCreateDto contentWriterProfileCreateDto)
    {
        Boolean profileCreationStatus = contentWriterService.createContentWriterProfile(contentWriterProfileCreateDto);

        if(profileCreationStatus==true)
        {
            return ResponseEntity.ok("Profile Creation Successful!!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed To Create Profile!");
        }

    }

    @GetMapping(path = "/getAllContentWriterProfile")
    public ResponseEntity<List<ContentWriterProfileDto>> getAllContentWriterProfile()
    {
        List<ContentWriterProfileDto> allContentWriter = contentWriterService.getAllContentWriterProfile();
        return ResponseEntity.ok(allContentWriter);

    }

    @GetMapping(path = "/getContentWriterProfile/{email}")
    public ResponseEntity<ContentWriterProfileDto> getContentWriterProfile(@PathVariable("email") String email)
    {
        ContentWriterProfileDto contentWriterProfile = contentWriterService.getContentWriterProfile(email);
        return ResponseEntity.ok(contentWriterProfile);

    }

    @PutMapping(path = "/updateContentWriterProfile")
    public ResponseEntity<String> updateContentWriterProfile(@RequestBody ContentWriterProfileDto contentWriterProfileDto)
    {
       Boolean updateStatus = contentWriterService.updateContentWriterProfile(contentWriterProfileDto);
       if( updateStatus == true)
       {
           return ResponseEntity.ok("Profile Update Successful!");
       }else{
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Profile Updation Failed!");
       }

    }

    @DeleteMapping(path = "/deleteContentWriterProfile/{profile_id}")
    public ResponseEntity<String> deleteContentWriterProfile(@PathVariable(value = "profile_id")int profile_id)
    {
        Boolean deleteStatus = contentWriterService.deleteContentWriterProfile(profile_id);
        if( deleteStatus == true)
        {
            return ResponseEntity.ok("Profile Deletion Successful!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Profile Deletion Failed!");
        }

    }

    @GetMapping(path = "/searchSpecificAdvertisement")
    public ResponseEntity<List<ClientAdvertisementDto>> searchSpecificAdvertisement(@RequestParam Map<String, String> filters)
    {
        List<ClientAdvertisementDto> advertisementList = contentWriterService.searchSpecificAdvertisement(filters);
        return ResponseEntity.ok(advertisementList);

    }

}
