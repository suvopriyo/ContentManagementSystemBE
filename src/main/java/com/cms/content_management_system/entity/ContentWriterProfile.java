package com.cms.content_management_system.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "ContentWriterProfile")
public class ContentWriterProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="profile_id", length = 11)
    private int profile_id;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="education_qualification", length = 255)
    private String education_qualification;

    @Column(name="experience", length = 255)
    private String experience;

    @Column(name="number_of_projects_completed", length = 255)
    private String number_of_projects_completed;


    @Column(name="wages_currency", length = 11)
    private String wages_currency;

    @Column(name="per_page_wages", length = 255)
    private String per_page_wages;

    @Column(name="demo_project_link", length = 255)
    private String demo_project_link;

    @Column(name="content_type", length = 255)
    private String content_type;

    @Column(name="language", length = 255)
    private String language;

    public int getProfile_id() {
        return profile_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfile_id(int email) {
        this.profile_id = profile_id;
    }



    public String getEducation_qualification() {
        return education_qualification;
    }

    public void setEducation_qualification(String education_qualification) {
        this.education_qualification = education_qualification;
    }

    public String getWages_currency() {
        return wages_currency;
    }

    public void setWages_currency(String wages_currency) {
        this.wages_currency = wages_currency;
    }


    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getNumber_of_projects_completed() {
        return number_of_projects_completed;
    }

    public void setNumber_of_projects_completed(String number_of_projects_completed) {
        this.number_of_projects_completed = number_of_projects_completed;
    }

    public String getPer_page_wages() {
        return per_page_wages;
    }

    public void setPer_page_wages(String per_page_wages) {
        this.per_page_wages = per_page_wages;
    }

    public String getDemo_project_link() {
        return demo_project_link;
    }

    public void setDemo_project_link(String demo_project_link) {
        this.demo_project_link = demo_project_link;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public ContentWriterProfile(String email, String education_qualification, String experience, String number_of_projects_completed,String wages_currency, String per_page_wages, String demo_project_link, String content_type, String language) {
        this.email = email;
        this.education_qualification = education_qualification;
        this.experience = experience;
        this.number_of_projects_completed = number_of_projects_completed;
        this.wages_currency = wages_currency;
        this.per_page_wages = per_page_wages;
        this.demo_project_link = demo_project_link;
        this.content_type = content_type;
        this.language = language;
    }

    public ContentWriterProfile() {
    }

    @Override
    public String toString() {
        return "ContentWriterProfile{" +
                "profile_id=" + profile_id +
                ", email='" + email + '\'' +
                ", education_qualification='" + education_qualification + '\'' +
                ", experience='" + experience + '\'' +
                ", number_of_projects_completed='" + number_of_projects_completed + '\'' +
                ", wages_currency='" + wages_currency + '\'' +
                ", per_page_wages='" + per_page_wages + '\'' +
                ", demo_project_link='" + demo_project_link + '\'' +
                ", content_type='" + content_type + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
