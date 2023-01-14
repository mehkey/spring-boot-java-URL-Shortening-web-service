package com.mehkey.URLShortening.controllers;


import com.mehkey.URLShortening.entities.URL;
import com.mehkey.URLShortening.service.URLShorteningService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile("test")
class URLRedirectControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private URLShorteningService service;

    URLRedirectControllerTest() {

    }

    @Test
    public void redirect_ShortUrlFound_ShouldReturn302Found() {
        URL url = new URL();
        url.setUrl("https://example.com");
        Optional<URL> optional = Optional.of(url);
        when(service.findByShortUrl("abc123")).thenReturn(optional);

        client.get().uri("/r/abc123")
                .exchange()
                .expectStatus().isFound()
                .expectHeader().valueEquals("Location", "https://example.com");
    }

    @Test
    public void redirect_ShortUrlNotFound_ShouldReturn404NotFound() {
        when(service.findByShortUrl("abc123")).thenReturn(Optional.empty());

        client.get().uri("/r/abc123")
                .exchange()
                .expectStatus().isNotFound();
    }
}
