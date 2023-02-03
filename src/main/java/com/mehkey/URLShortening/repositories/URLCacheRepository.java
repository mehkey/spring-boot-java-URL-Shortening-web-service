package com.mehkey.URLShortening.repositories;

import com.mehkey.URLShortening.entities.URL;
import org.springframework.data.repository.CrudRepository;

public interface  URLCacheRepository extends CrudRepository<URL, String> {

}


