package com.cms.content_management_system.service.IMPL;

import com.cms.content_management_system.dto.ContentTypeCreateDto;
import com.cms.content_management_system.dto.ContentTypeDto;
import com.cms.content_management_system.dto.ContentWriterProfileDto;
import com.cms.content_management_system.dto.UserRegistrationDto;
import com.cms.content_management_system.entity.ContentType;
import com.cms.content_management_system.entity.ContentWriterProfile;
import com.cms.content_management_system.entity.UserRegistration;
import com.cms.content_management_system.repo.ContentTypeRepo;
import com.cms.content_management_system.repo.UserRepo;
import com.cms.content_management_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminServiceIMPL implements AdminService {

    @Autowired
    private ContentTypeRepo contentTypeRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Boolean saveContentType(ContentTypeCreateDto contentTypeCreateDto) {

        try{
            ContentType contentType =  new ContentType(
                    contentTypeCreateDto.getContent_type()
            );

            contentTypeRepo.save(contentType);
            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ContentTypeDto> getAllContentType() {
        List<ContentType> getContentTypes = contentTypeRepo.findAll();
        List<ContentTypeDto> ContentTypeDtoList = new ArrayList<>();

        for(ContentType contentType : getContentTypes)
        {
            ContentTypeDto contentTypeDto = new ContentTypeDto(
                    contentType.getContent_id(),
                    contentType.getContent_type()
            );
            ContentTypeDtoList.add(contentTypeDto);
        }

        return ContentTypeDtoList;

    }

    @Override
    public Boolean updateContentType(ContentTypeDto contentTypeDto) {

        if(contentTypeRepo.existsById(contentTypeDto.getContent_id()))
        {
            ContentType contentType = contentTypeRepo.getById(contentTypeDto.getContent_id());
            contentType.setContent_type(contentTypeDto.getContent_type());


            contentTypeRepo.save(contentType);
            return true;


        }else{
            System.out.println("Content type doesn't exists!");
            return false;
        }

    }

    @Override
    public Boolean deleteContentType(int contentId) {
        if(contentTypeRepo.existsById(contentId))
        {
            contentTypeRepo.deleteById(contentId);
            return true;
        }else {
            System.out.println("Content type doesn't exists!");
            return false;
        }
    }

    @Override
    public ContentTypeDto getContentType(int contentId) {

        ContentType contentType = contentTypeRepo.findById(contentId)
                .orElseThrow(() -> new NoSuchElementException("Content Type not found with ID: " + contentId));

        return new ContentTypeDto(
                contentType.getContent_id(),
                contentType.getContent_type()
        );

    }

    @Override
    public List<UserRegistrationDto> getAllUsers() {

        List<UserRegistration> getAllUsers = userRepo.findAll();
        List<UserRegistrationDto>  getAllUsersDtoList = new ArrayList<>();

        for(UserRegistration user : getAllUsers)
        {
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto(
                    user.getUser_id(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getMobile_number(),
                    user.getRole()
            );
            getAllUsersDtoList.add(userRegistrationDto);
        }

        return getAllUsersDtoList;


    }

    @Override
    public Boolean updateUserDetails(UserRegistrationDto userRegistrationDto) {

        if(userRepo.existsById(userRegistrationDto.getUser_id()))
        {
            UserRegistration userRegistration = userRepo.getById(userRegistrationDto.getUser_id());
            userRegistration.setEmail(userRegistrationDto.getEmail());
            userRegistration.setName(userRegistrationDto.getName());
            userRegistration.setRole(userRegistrationDto.getRole());
            userRegistration.setMobile_number(userRegistrationDto.getMobile_number());
            userRegistration.setPassword(userRegistrationDto.getPassword());

            userRepo.save(userRegistration);
            return true;


        }else{
            System.out.println("User contenet doesn't exists!");
            return false;
        }

    }

    @Override
    public Boolean deleteUser(int userId) {
        if(userRepo.existsById(userId))
        {
            userRepo.deleteById(userId);
            return true;
        }else {
            System.out.println("User doesn't exists!");
            return false;
        }
    }
}
