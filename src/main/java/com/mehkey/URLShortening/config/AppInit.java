package com.mehkey.URLShortening.config;

import com.mehkey.URLShortening.service.URLShorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class AppInit implements CommandLineRunner {
    private final URLShorteningService service;

    @Autowired
    public AppInit(URLShorteningService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        service.initializeDatabase();
    }
}
