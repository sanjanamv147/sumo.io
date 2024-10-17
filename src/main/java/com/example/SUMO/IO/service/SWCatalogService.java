package com.example.SUMO.IO.service;

import com.example.SUMO.IO.catalog.model.SWCatalog;
import com.example.SUMO.IO.repository.SWCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
