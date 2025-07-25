package com.cms.content_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContentWriterProfileCreateDto {

    private String email;

    private String education_qualification;


    private String experience;


    private String number_of_projects_completed;

    private String wages_currency;


    private String per_page_wages;


    private String demo_project_link;


    private String content_type;


    private String language;

}
