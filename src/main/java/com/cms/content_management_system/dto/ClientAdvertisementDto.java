package com.cms.content_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientAdvertisementDto {

    private int advertisement_id;

    private String title;


    private String description;


    private String subject;


    private int number_of_pages;


    private String content_type;


    private String e_t_a;


    private String budget_currency;


    private BigDecimal budget;


    private String number_of_words;


    private String language;

}
