package com.mehkey.URLShortening.service;

import com.mehkey.URLShortening.entities.URL;
import com.mehkey.URLShortening.repositories.URLRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class URLShorteningService {

    private final URLRepository dao;

    public void initializeDatabase() {
        if (dao.count() == 0) {
            dao.saveAll(Arrays.asList(
                    new URL(1, "www.google.com"),
                    new URL(2, "www.reddit.com"),
                    new URL(3, "www.yahoo.com")
            ));
        }
    }
    @Autowired
    public URLShorteningService(URLRepository dao) {
        this.dao = dao;
    }

    public List<URL> getAllUrls(){
        return dao.findAll();
    }

    /*public List<URL> findAll() {
        return dao.findAll();
    }*/

    public Optional<URL> findById(int id) {
        return dao.findById(id);
    }

}
