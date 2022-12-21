package com.mehkey.URLShortening.repositories;

import com.mehkey.URLShortening.entities.URL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface URLRepository extends CrudRepository<URL,Integer> {
    URL findURLById(Integer id);
    List<URL> findAll();
    URL findURLByUrl(String url);
    Optional<URL> findURLByShortUrl(String shortUrl);
    //List<Product> findTop10ByNameContainsOrderByPrice(String regex);
}
