package com.example.SUMO.IO.repository;

import com.example.SUMO.IO.catalog.model.RDCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RDCatalogRepository extends JpaRepository<RDCatalog, Long> {
    // Add custom query methods if needed
}
