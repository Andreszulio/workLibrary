package com.example.Library.service;

import com.example.Library.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    @Autowired
    private ResourcesRepository resourcesRepository;



}
