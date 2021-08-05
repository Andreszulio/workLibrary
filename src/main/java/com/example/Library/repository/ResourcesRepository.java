package com.example.Library.repository;

import com.example.Library.domain.Resources;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResourcesRepository extends MongoRepository<Resources, String> {
    List<Resources> findTypeOfResource(String type);
    List<Resources> findTypeOfThematic(String thematic);
}
