package com.example.SUMO.IO.service;


import com.example.SUMO.IO.catalog.model.ConfigCatalog;
import com.example.SUMO.IO.repository.ConfigCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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


    public List<ConfigCatalog> filterConfigCatalog(String ecuName, String version, LocalDateTime releaseDate) {
        List<ConfigCatalog> softwareList = new ArrayList<>();

        if ((ecuName == null || ecuName.isEmpty()) &&
                (version == null || version.isEmpty()) &&
                releaseDate == null) {
            return configCatalogRepository.findAll();
        }

        // Filter by ecuName
        if (ecuName != null && !ecuName.isEmpty()) {
            softwareList.addAll(configCatalogRepository.findByEcuName(ecuName));
        }

        // Filter by version
        if (version != null && !version.isEmpty()) {
            softwareList.addAll(configCatalogRepository.findByVersion(version));
        }

        // Filter by releaseDate
        if (releaseDate != null) {
            softwareList.addAll(configCatalogRepository.findByReleaseDate(releaseDate));
        }

        return softwareList.stream().distinct().toList();
    }

    public List<ConfigCatalog> sortConfigCatalog(String sortBy, boolean ascending) {
        Sort.Direction direction = ascending ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort;
        switch (sortBy) {
            case "ecuName":
                sort = Sort.by(direction, "ecuName");
                break;
            case "releaseDate":
                sort = Sort.by(direction, "releaseDate");
                break;
            case "configSize":
                sort = Sort.by(direction, "configSize");
                break;
            default:
                sort = Sort.by(direction, "uploadDateTime");
        }
        return configCatalogRepository.findAll(sort);
    }
}
