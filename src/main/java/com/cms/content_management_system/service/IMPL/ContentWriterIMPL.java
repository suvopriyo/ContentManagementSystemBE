package com.cms.content_management_system.service.IMPL;

import com.cms.content_management_system.dto.ClientAdvertisementDto;
import com.cms.content_management_system.dto.ContentTypeDto;
import com.cms.content_management_system.dto.ContentWriterProfileCreateDto;
import com.cms.content_management_system.dto.ContentWriterProfileDto;
import com.cms.content_management_system.entity.ClientAdvertisement;
import com.cms.content_management_system.entity.ContentType;
import com.cms.content_management_system.entity.ContentWriterProfile;
import com.cms.content_management_system.repo.ContentWriterRepo;
import com.cms.content_management_system.repo.JpaSpecificationExecutorRepo.ClientAdvertisementJpaSpecificationExecutorRepo;
import com.cms.content_management_system.repo.JpaSpecificationExecutorRepo.ClientAdvertisementSpecification;
import com.cms.content_management_system.service.ContentWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ContentWriterIMPL implements ContentWriterService {

    @Autowired
    private ContentWriterRepo contentWriterRepo;

    @Autowired
    private ClientAdvertisementJpaSpecificationExecutorRepo clientAdvertisementJpaSpecificationExecutorRepo;


    @Override
    public Boolean createContentWriterProfile(ContentWriterProfileCreateDto contentWriterProfileCreateDto) {

        try{
            ContentWriterProfile contentWriterProfile = new ContentWriterProfile(
                    contentWriterProfileCreateDto.getEmail(),
                    contentWriterProfileCreateDto.getEducation_qualification(),
                    contentWriterProfileCreateDto.getExperience(),
                    contentWriterProfileCreateDto.getNumber_of_projects_completed(),
                    contentWriterProfileCreateDto.getWages_currency(),
                    contentWriterProfileCreateDto.getPer_page_wages(),
                    contentWriterProfileCreateDto.getDemo_project_link(),
                    contentWriterProfileCreateDto.getContent_type(),
                    contentWriterProfileCreateDto.getLanguage()

            );

            contentWriterRepo.save(contentWriterProfile);
            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public List<ContentWriterProfileDto> getAllContentWriterProfile() {
        List<ContentWriterProfile> getContentWriterProfiles = contentWriterRepo.findAll();
        List<ContentWriterProfileDto> contentWriterProfileDtoList = new ArrayList<>();

        for(ContentWriterProfile contentWriterProfile : getContentWriterProfiles)
        {
            ContentWriterProfileDto contentWriterProfileDto = new ContentWriterProfileDto(
                    contentWriterProfile.getProfile_id(),
                    contentWriterProfile.getEmail(),
                    contentWriterProfile.getEducation_qualification(),
                    contentWriterProfile.getExperience(),
                    contentWriterProfile.getNumber_of_projects_completed(),
                    contentWriterProfile.getWages_currency(),
                    contentWriterProfile.getPer_page_wages(),
                    contentWriterProfile.getDemo_project_link(),
                    contentWriterProfile.getContent_type(),
                    contentWriterProfile.getLanguage()
            );
            contentWriterProfileDtoList.add(contentWriterProfileDto);
        }

        return contentWriterProfileDtoList;






    }

    @Override
    public Boolean updateContentWriterProfile(ContentWriterProfileDto contentWriterProfileDto) {

        if(contentWriterRepo.existsById(contentWriterProfileDto.getProfile_id()))
        {
            ContentWriterProfile contentWriterProfile = contentWriterRepo.getById(contentWriterProfileDto.getProfile_id());
            contentWriterProfile.setEmail(contentWriterProfileDto.getEmail());
            contentWriterProfile.setEducation_qualification(contentWriterProfileDto.getEducation_qualification());
            contentWriterProfile.setExperience(contentWriterProfileDto.getExperience());
            contentWriterProfile.setNumber_of_projects_completed(contentWriterProfileDto.getNumber_of_projects_completed());
            contentWriterProfile.setWages_currency(contentWriterProfileDto.getWages_currency());
            contentWriterProfile.setPer_page_wages(contentWriterProfileDto.getPer_page_wages());
            contentWriterProfile.setDemo_project_link(contentWriterProfileDto.getDemo_project_link());
            contentWriterProfile.setContent_type(contentWriterProfileDto.getContent_type());
            contentWriterProfile.setLanguage(contentWriterProfileDto.getLanguage());

            contentWriterRepo.save(contentWriterProfile);
            return true;


        }else{
            System.out.println("Profile doesn't exists!");
            return false;
        }

    }

    @Override
    public Boolean deleteContentWriterProfile(int profileId) {
        if(contentWriterRepo.existsById(profileId))
        {
            contentWriterRepo.deleteById(profileId);
            return true;
        }else {
            System.out.println("Profile doesn't exists!");
            return false;
        }
    }

    @Override
    public ContentWriterProfileDto getContentWriterProfile(String email) {
        ContentWriterProfile contentWriterProfile = contentWriterRepo.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("Content Writer Profile not found with email: " + email));

        return new ContentWriterProfileDto(
                contentWriterProfile.getProfile_id(),
                contentWriterProfile.getEmail(),
                contentWriterProfile.getEducation_qualification(),
                contentWriterProfile.getExperience(),
                contentWriterProfile.getNumber_of_projects_completed(),
                contentWriterProfile.getWages_currency(),
                contentWriterProfile.getPer_page_wages(),
                contentWriterProfile.getDemo_project_link(),
                contentWriterProfile.getContent_type(),
                contentWriterProfile.getLanguage()
        );
    }

    @Override
    public List<ClientAdvertisementDto> searchSpecificAdvertisement(Map<String, String> filters) {

        Specification<ClientAdvertisement> spec = ClientAdvertisementSpecification.build(filters);
        List<ClientAdvertisement> clientAdvertisementList = clientAdvertisementJpaSpecificationExecutorRepo.findAll(spec);

        List<ClientAdvertisementDto> ClientAdvertisementDtoList = new ArrayList<>();

        for(ClientAdvertisement clientAdvertisement : clientAdvertisementList)
        {
            ClientAdvertisementDto clientAdvertisementDto = new ClientAdvertisementDto(
                    clientAdvertisement.getAdvertisement_id(),
                    clientAdvertisement.getTitle(),
                    clientAdvertisement.getDescription(),
                    clientAdvertisement.getSubject(),
                    clientAdvertisement.getNumber_of_pages(),
                    clientAdvertisement.getContent_type(),
                    clientAdvertisement.getE_t_a(),
                    clientAdvertisement.getBudget_currency(),
                    clientAdvertisement.getBudget(),
                    clientAdvertisement.getNumber_of_words(),
                    clientAdvertisement.getLanguage()
            );
            ClientAdvertisementDtoList.add(clientAdvertisementDto);
        }


        return ClientAdvertisementDtoList;
    }


}
