

package com.mehkey.URLShortening.entities;

import jakarta.annotation.Generated;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "URL")
public class URL{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String url;

    //private Date creationDate;

    public URL() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        URL url1 = (URL) o;
        return id == url1.id && Objects.equals(url, url1.url) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }

    @Override
    public String toString() {
        return "URL{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }



    public URL(int id, String url) {
        this.id = id;
        this.url = url;
        //this.creationDate = new Date(System.currentTimeMillis());
    }
}