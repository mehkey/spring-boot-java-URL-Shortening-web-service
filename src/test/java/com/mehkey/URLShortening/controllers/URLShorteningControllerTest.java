package com.mehkey.URLShortening.controllers;

import com.mehkey.URLShortening.entities.URL;
import com.mehkey.URLShortening.service.URLShorteningService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile("test")
public class URLShorteningControllerTest {
    @Autowired
    private WebTestClient client;

    @MockBean
    private URLShorteningService service;


    URLShorteningControllerTest() {

    }

    @Test
    void URLRequest1ShouldBeOK() {
        URL url = new URL(1,"https://example.com", LocalDateTime.now(), null);
        when(service.findById(1)).thenReturn(Optional.of(url));

        client.get().uri("/url/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(URL.class)
                .consumeWith(System.out::println);
    }

    @Test
    void URLRequestAllShouldBeOK() {
        List<URL> urls = Arrays.asList(new URL("https://example.com"), new URL("https://example2.com"));
        when(service.getAllUrls()).thenReturn(urls);

        client.get().uri("/url/all")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                //.consumeWith(System.out::println);
                .expectBodyList(URL.class)
                .hasSize(2)
                .consumeWith(System.out::println);
    }

    @Test
    public void insertProduct_ShouldReturnCreatedProduct() {
        LocalDateTime time = LocalDateTime.now();
        URL url = new URL(1,"https://example.com", time, "abc124");
        //when(service.saveURL(url)).thenReturn(new URL(1,"https://example.com", time, "abc123"));
        ///when(service.saveURL(url)).thenReturn(url);
        when(service.saveURL(any(URL.class))).thenReturn(url);

        client.post().uri("/url")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(url))
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(URL.class)
                .consumeWith(result -> {
                    assertEquals("https://example.com", result.getResponseBody().getUrl());
                    assertEquals("abc124", result.getResponseBody().getShortUrl());
                });
    }
}
