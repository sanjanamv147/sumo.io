package com.example.SUMO.IO.service;

import com.example.SUMO.IO.catalog.model.RDCatalog;
import com.example.SUMO.IO.repository.RDCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
