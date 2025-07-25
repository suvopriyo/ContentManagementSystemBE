package com.cms.content_management_system.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ClientAdvertisement")
public class ClientAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="advertisement_id", length = 11)
    private int advertisement_id;

    @Column(name="title", length = 255)
    private String title;

    @Column(name="description", length = 255)
    private String description;

    @Column(name="subject", length = 255)
    private String subject;

    @Column(name="number_of_pages", length = 11)
    private int number_of_pages;

    @Column(name="content_type", length = 255)
    private String content_type;

    @Column(name="e_t_a", length = 255)
    private String e_t_a;

    @Column(name="budget_currency", length = 255)
    private String budget_currency;

    @Column(name = "budget", precision = 10, scale = 2)
    private BigDecimal budget;

    @Column(name="number_of_words", length = 255)
    private String number_of_words;

    @Column(name="language", length = 255)
    private String language;

    public int getAdvertisement_id() {
        return advertisement_id;
    }

    public void setAdvertisement_id(int advertisement_id) {
        this.advertisement_id = advertisement_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getE_t_a() {
        return e_t_a;
    }

    public void setE_t_a(String e_t_a) {
        this.e_t_a = e_t_a;
    }

    public String getBudget_currency() {
        return budget_currency;
    }

    public void setBudget_currency(String budget_currency) {
        this.budget_currency = budget_currency;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getNumber_of_words() {
        return number_of_words;
    }

    public void setNumber_of_words(String number_of_words) {
        this.number_of_words = number_of_words;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ClientAdvertisement( String title, String description, String subject, int number_of_pages, String content_type, String e_t_a, String budget_currency, BigDecimal budget, String number_of_words, String language) {

        this.title = title;
        this.description = description;
        this.subject = subject;
        this.number_of_pages = number_of_pages;
        this.content_type = content_type;
        this.e_t_a = e_t_a;
        this.budget_currency = budget_currency;
        this.budget = budget;
        this.number_of_words = number_of_words;
        this.language = language;
    }


    public ClientAdvertisement() {
    }


    @Override
    public String toString() {
        return "ClientAdvertisement{" +
                "advertisement_id=" + advertisement_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subject='" + subject + '\'' +
                ", number_of_pages=" + number_of_pages +
                ", content_type='" + content_type + '\'' +
                ", e_t_a='" + e_t_a + '\'' +
                ", budget_currency='" + budget_currency + '\'' +
                ", budget=" + budget +
                ", number_of_words=" + number_of_words + '\''+
                ", language='" + language + '\'' +
                '}';
    }
}
