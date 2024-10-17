package com.example.SUMO.IO.repository;

import com.example.SUMO.IO.catalog.model.SWCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SWCatalogRepository extends JpaRepository<SWCatalog, Long> {
    // Custom query methods if necessary
}
