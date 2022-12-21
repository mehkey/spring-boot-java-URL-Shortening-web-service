package com.mehkey.URLShortening.controllers;

import com.mehkey.URLShortening.entities.URL;
import com.mehkey.URLShortening.service.URLShorteningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/url")
public class URLShorteningController {

    private final Logger log = LoggerFactory.getLogger(URLShorteningController.class);

    private URLShorteningService service;

    @Autowired
    public URLShorteningController(URLShorteningService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<URL> findById(@PathVariable int id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<URL> insertProduct(@RequestBody URL url) {
        URL p = service.saveURL(url);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(p.getId())
                .toUri();
        return ResponseEntity.created(location).body(p);
    }

    @GetMapping("/all")
    public List<URL> findAll() {
        return service.getAllUrls();
    }
}
