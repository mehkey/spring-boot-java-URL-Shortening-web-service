package com.mehkey.URLShortening.controllers;

import com.mehkey.URLShortening.entities.URL;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile("test")
public class URLShorteningControllerTest {
    @Autowired
    private WebTestClient client;

    /*@Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Integer> getIds() {
        return jdbcTemplate.query("select id from url",
                (rs, rowNum) -> rs.getInt("id"));
    }*/
    @Test
    void URLRequest1ShouldBeOK() {
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
        client.get().uri("/url/all")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                //.consumeWith(System.out::println);
                .expectBodyList(URL.class)
                .hasSize(3)
                .consumeWith(System.out::println);
    }


}
