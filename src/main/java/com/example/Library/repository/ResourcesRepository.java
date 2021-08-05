package com.example.Library.repository;

import com.example.Library.domain.Resources;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourcesRepository extends MongoRepository<Resources, String> {
    Iterable<Resources> findByTypeOfResource(String type);
    Iterable<Resources> findByTypeOfThematic(String thematic);
}
