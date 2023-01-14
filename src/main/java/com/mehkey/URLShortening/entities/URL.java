

package com.mehkey.URLShortening.entities;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
//@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "URL")
public class URL{

    public URL(String url){
        this.setUrl(url);
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotBlank
    //@Column
    private String url;

    @JsonFormat(pattern = ("yyyy/MM/dd HH:mm:ss"))
    //@JsonSerialize(using = LocalDateTimeSerializer.class)
    //@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    //@Column
    private LocalDateTime createdDate;

    @NotBlank
    //@Column
    private String shortUrl;

    /*public boolean equals(URL url2){
        if (url2 == null) {
            return false;
        }
        return url2.getId() == this.getId();
    }*/
    /*
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

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



    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }



    public URL(int id, String url, LocalDateTime createdDate, String shortUrl) {
        this.id = id;
        this.url = url;
        this.createdDate = createdDate;
        this.shortUrl = shortUrl;
        //this.creationDate = new Date(System.currentTimeMillis());
    }

     */
}