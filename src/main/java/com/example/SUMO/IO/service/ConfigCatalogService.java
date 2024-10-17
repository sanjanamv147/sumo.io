package com.example.SUMO.IO.service;


import com.example.SUMO.IO.catalog.model.ConfigCatalog;
import com.example.SUMO.IO.repository.ConfigCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigCatalogService {

    @Autowired
    private ConfigCatalogRepository configCatalogRepository;

    public List<ConfigCatalog> getAllConfigCatalogs() {
        return configCatalogRepository.findAll();
    }

    public ConfigCatalog uploadConfigCatalog(ConfigCatalog configCatalog) {
        return configCatalogRepository.save(configCatalog);
    }

    public Optional<ConfigCatalog> getCatalogById(Long id) {
        return configCatalogRepository.findById(id);
    }

    public void retireCatalog(Long id) {
        configCatalogRepository.deleteById(id);  // Or update its status instead of deleting
    }
}
