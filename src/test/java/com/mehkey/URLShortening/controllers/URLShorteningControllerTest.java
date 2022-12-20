package com.mehkey.URLShortening.controllers;

import com.mehkey.URLShortening.entities.URL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
public class URLShorteningControllerTest {
    @Autowired
    private WebTestClient client;

    @Test
    void today() {
        client.get().uri("/url/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(URL.class)
                .consumeWith(System.out::println);
    }

}
