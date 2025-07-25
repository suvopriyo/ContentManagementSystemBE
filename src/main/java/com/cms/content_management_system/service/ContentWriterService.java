package com.cms.content_management_system.service;

import com.cms.content_management_system.dto.ClientAdvertisementDto;
import com.cms.content_management_system.dto.ContentWriterProfileCreateDto;
import com.cms.content_management_system.dto.ContentWriterProfileDto;

import java.util.List;
import java.util.Map;

public interface ContentWriterService {
    Boolean createContentWriterProfile(ContentWriterProfileCreateDto contentWriterProfileDto);

    List<ContentWriterProfileDto> getAllContentWriterProfile();

    Boolean updateContentWriterProfile(ContentWriterProfileDto contentWriterProfileDto);

    Boolean deleteContentWriterProfile(int profileId);

    ContentWriterProfileDto getContentWriterProfile(String email);

    List<ClientAdvertisementDto> searchSpecificAdvertisement(Map<String, String> filters);
}
