package com.cms.content_management_system.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "ContentType")
public class ContentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="content_id", length = 11)
    private int content_id;

    @Column(name="content_type", length = 255)
    private String content_type;

    public ContentType(String content_type) {
        this.content_id = content_id;
        this.content_type = content_type;
    }

    public ContentType() {
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    @Override
    public String toString() {
        return "ContentType{" +
                "content_id=" + content_id +
                ", content_type='" + content_type + '\'' +
                '}';
    }
}
