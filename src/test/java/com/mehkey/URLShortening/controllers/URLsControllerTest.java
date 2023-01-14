package com.mehkey.URLShortening.controllers;

import com.mehkey.URLShortening.entities.URL;
import com.mehkey.URLShortening.service.URLShorteningService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile("test")
class URLsControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private URLShorteningService service;

    @Test
    void addUrl() {
    }

    @Test
    public void showUrls_ShouldReturnUrls() {
        List<URL> urls = Arrays.asList(new URL("https://example.com"), new URL("https://example2.com"));
        when(service.getAllUrls()).thenReturn(urls);

        client.get().uri("/urls")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(result -> {
                    assertTrue(result.getResponseBody().contains("https://example.com"));
                    assertTrue(result.getResponseBody().contains("https://example2.com"));
                });
    }


    @Test
    public void showUrl_ShouldReturnUrl() {
        URL url = new URL(1,"https://example.com", LocalDateTime.now(), "abc123");
        when(service.findById(1)).thenReturn(Optional.of(url));

        client.get().uri("/urls/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(result -> {
                    assertTrue(result.getResponseBody().contains("https://example.com"));
                    //assertTrue(result.getResponseBody().contains("abc123"));
                });
    }


    @Test
    public void showUrl_IdNotFound_ShouldReturn404() {
        when(service.findById(1)).thenReturn(Optional.empty());

        client.get().uri("/urls/1")
                .exchange()
                .expectStatus().isNotFound();
    }



}