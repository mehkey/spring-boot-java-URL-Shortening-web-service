package com.mehkey.URLShortening.controllers;

import com.mehkey.URLShortening.entities.URL;
import com.mehkey.URLShortening.service.URLShorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/url")
public class URLShorteningController {


    private URLShorteningService service;

    @Autowired
    public URLShorteningController(URLShorteningService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public URL findById(@PathVariable int id) {
        //if service.findById(id).ifPresent();
        return service.findById(id).get();
    }

    @GetMapping("/all")
    public List<URL> findAll() {
        return service.getAllUrls();
    }
}
