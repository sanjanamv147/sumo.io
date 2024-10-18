package com.example.SUMO.IO.service;

import com.example.SUMO.IO.catalog.model.RDCatalog;
import com.example.SUMO.IO.repository.RDCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RDCatalogService {

    @Autowired
    private RDCatalogRepository rdCatalogRepository;

    public List<RDCatalog> getAllRDCatalogs() {
        return rdCatalogRepository.findAll();
    }

    public RDCatalog uploadRDCatalog(RDCatalog rdCatalog) {
        return rdCatalogRepository.save(rdCatalog);
    }

    public Optional<RDCatalog> getCatalogById(Long id) {
        return rdCatalogRepository.findById(id);
    }

    public void retireCatalog(Long id) {
        rdCatalogRepository.deleteById(id);  // Or update its status instead of deleting
    }


    public List<RDCatalog> filterRDCatalog(String ecuName, String version, LocalDateTime releaseDate) {
        List<RDCatalog> softwareList = new ArrayList<>();

        if ((ecuName == null || ecuName.isEmpty()) &&
                (version == null || version.isEmpty()) &&
                releaseDate == null) {
            return rdCatalogRepository.findAll();
        }

        // Filter by ecuName
        if (ecuName != null && !ecuName.isEmpty()) {
            softwareList.addAll(rdCatalogRepository.findByEcuName(ecuName));
        }

        // Filter by version
        if (version != null && !version.isEmpty()) {
            softwareList.addAll(rdCatalogRepository.findByVersion(version));
        }

        // Filter by releaseDate
        if (releaseDate != null) {
            softwareList.addAll(rdCatalogRepository.findByReleaseDate(releaseDate));
        }

        return softwareList.stream().distinct().toList();
    }

    public List<RDCatalog> sortRDCatalog(String sortBy, boolean ascending) {
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
        return rdCatalogRepository.findAll(sort);
    }
}
