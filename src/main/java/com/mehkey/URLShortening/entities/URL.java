

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
@Table(name = "url")
public class URL{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String url;

    private Date creationDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        URL url1 = (URL) o;
        return id == url1.id && Objects.equals(url, url1.url) && Objects.equals(creationDate, url1.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, creationDate);
    }

    @Override
    public String toString() {
        return "URL{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public URL(int id, String url) {
        this.id = id;
        this.url = url;
        this.creationDate = new Date(System.currentTimeMillis());
    }
}