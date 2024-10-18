package com.example.SUMO.IO.service;

import com.example.SUMO.IO.catalog.model.SWCatalog;
import com.example.SUMO.IO.repository.SWCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SWCatalogService {

    @Autowired
    private SWCatalogRepository swCatalogRepository;

    public List<SWCatalog> getAllSWCatalogs() {
        return swCatalogRepository.findAll();
    }

    public SWCatalog uploadSWCatalog(SWCatalog swCatalog) {
        return swCatalogRepository.save(swCatalog);
    }

    public Optional<SWCatalog> getCatalogById(Long id) {
        return swCatalogRepository.findById(id);
    }

    public void retireCatalog(Long id) {
        swCatalogRepository.deleteById(id);  // Or update its status instead of deleting
    }


    public List<SWCatalog> filterSWCatalog(String ecuName, String version, LocalDateTime releaseDate) {
        List<SWCatalog> softwareList = new ArrayList<>();

        if ((ecuName == null || ecuName.isEmpty()) &&
                (version == null || version.isEmpty()) &&
                releaseDate == null) {
            return swCatalogRepository.findAll();
        }

        // Filter by ecuName
        if (ecuName != null && !ecuName.isEmpty()) {
            softwareList.addAll(swCatalogRepository.findByEcuName(ecuName));
        }

        // Filter by version
        if (version != null && !version.isEmpty()) {
            softwareList.addAll(swCatalogRepository.findByVersion(version));
        }

        // Filter by releaseDate
        if (releaseDate != null) {
            softwareList.addAll(swCatalogRepository.findByReleaseDate(releaseDate));
        }

        return softwareList.stream().distinct().toList();
    }

    public List<SWCatalog> sortSWCatalog(String sortBy, boolean ascending) {
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
        return swCatalogRepository.findAll(sort);
    }
}
