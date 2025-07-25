package com.cms.content_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "UserRegistration")
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id", length = 11)
    private int user_id;

    @Column(name="name", length = 255)
    private String name;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="password", length = 255)
    private String password;

    @Column(name="mobile_number", length = 20)
    private String mobile_number;

    @Column(name="role", length = 255)
    private String role;



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public UserRegistration( String name, String email, String password, String mobile_number, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile_number = mobile_number;
        this.role = role;
    }

    public UserRegistration() {
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
