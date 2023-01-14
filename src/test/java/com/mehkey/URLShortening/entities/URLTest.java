package com.mehkey.URLShortening.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class URLTest {

    private URL url;

    @BeforeEach
    public void setUp() {
        url = new URL();
    }

    @Test
    public void getId_ShouldReturnId() {
        url.setId(1);
        assertEquals(1, url.getId());
    }

    @Test
    public void getUrl_ShouldReturnUrl() {
        url.setUrl("https://example.com");
        assertEquals("https://example.com", url.getUrl());
    }

    @Test
    public void getCreatedDate_ShouldReturnCreatedDate() {
        LocalDateTime now = LocalDateTime.now();
        url.setCreatedDate(now);
        assertEquals(now, url.getCreatedDate());
    }

    @Test
    public void getShortUrl_ShouldReturnShortUrl() {
        url.setShortUrl("abc123");
        assertEquals("abc123", url.getShortUrl());
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void getId() {
    }

    @Test
    void getUrl() {
    }

    @Test
    void getCreatedDate() {
    }

    @Test
    void getShortUrl() {
    }

    @Test
    void setId() {
    }

    @Test
    void setUrl() {
    }

    @Test
    void setCreatedDate() {
    }

    @Test
    void setShortUrl() {
    }

    @Test
    void testToString() {
    }
}