package com.mehkey.URLShortening.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UrlCache {
    @Id
    String shortUrl;

    String url;
}