package com.cms.content_management_system.service;

import com.cms.content_management_system.dto.ContentTypeCreateDto;
import com.cms.content_management_system.dto.ContentTypeDto;
import com.cms.content_management_system.dto.UserRegistrationDto;

import java.util.List;

public interface AdminService {
    Boolean saveContentType(ContentTypeCreateDto contentTypeDto);

    List<ContentTypeDto> getAllContentType();

    Boolean updateContentType(ContentTypeDto contentTypeDto);

    Boolean deleteContentType(int contentId);

    ContentTypeDto getContentType(int contentId);

    List<UserRegistrationDto> getAllUsers();

    Boolean updateUserDetails(UserRegistrationDto userRegistrationDto);

    Boolean deleteUser(int userId);
}
