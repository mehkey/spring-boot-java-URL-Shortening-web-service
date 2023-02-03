package com.mehkey.URLShortening.service;

import com.mehkey.URLShortening.entities.URL;
import com.mehkey.URLShortening.repositories.URLCacheRepository;
import com.mehkey.URLShortening.repositories.URLRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class URLShorteningServiceTest {
    private URLShorteningService service;
    private URLRepository dao = mock(URLRepository.class);
    private URLCacheRepository cache = mock(URLCacheRepository.class);

    private URL url = new URL();

    @BeforeEach
    public void setUp() {
        service = new URLShorteningService(dao,cache);
    }

    @Test
    void generateShortURLAndSave_ShouldSaveURLWithShortUrlAndCreationDate() {
        url.setUrl("https://example.com");
        when(dao.save(url)).thenReturn(url);
        URL savedUrl = service.generateShortURLAndSave(url);

        assertNotNull(savedUrl);
        assertNotNull(savedUrl.getShortUrl());
        //assertNotNull(savedUrl.getCreatedDate());
        assertEquals("https://example.com", savedUrl.getUrl());
        verify(dao).save(url);
    }

    @Test
    void generateShortURLAndSave_ShouldSaveURLWithExistShortUrlAndCreationDate() {
        url.setUrl("https://example.com");
        url.setShortUrl("1234567890");
        url.setCreatedDate(LocalDateTime.now());
        when(dao.save(url)).thenReturn(url);
        URL savedUrl = service.generateShortURLAndSave(url);

        assertNotNull(savedUrl);
        assertEquals("1234567890", savedUrl.getShortUrl());
        //assertEquals(LocalDateTime.now(), savedUrl.getCreatedDate());
        assertEquals("https://example.com", savedUrl.getUrl());
        verify(dao).save(url);
    }


    @Test
    void randomCode_ShouldReturnRandomCode() {
        URL url = new URL();
        String code1 = service.randomCode();
        String code2 = service.randomCode();

        assertNotNull(code1);
        assertNotNull(code2);
        assertNotEquals(code1, code2);
        assertTrue(code1.length() == 10);
        assertTrue(code2.length() == 10);
    }

    @Test
    void initializeDatabase() {
    }

    @Test
    void getAllUrls() {
    }

    @Test
    void findByShortUrl() {
    }

    @Test
    void findById() {
    }

    @Test
    void saveURL() {
    }

    @Test
    void generateShortURLAndSave() {
    }
}