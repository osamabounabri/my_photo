package com.myphotos.demo.model;

import org.hibernate.validator.constraints.Length;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "This field is required")
    @Length(min = 2, message = "Min lenght is 2")
    private String url;

    public Photo(){}

    public Photo(int id, String url){

    this.id = id;
    this.url = url;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
