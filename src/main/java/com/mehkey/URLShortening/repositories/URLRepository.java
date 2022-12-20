package com.mehkey.URLShortening.repositories;

import com.mehkey.URLShortening.entities.URL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface URLRepository extends CrudRepository<URL,Integer> {
    URL findURLById(Integer id);
    List<URL> findAll();
    //List<Product> findTop10ByNameContainsOrderByPrice(String regex);
}
