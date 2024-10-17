package com.example.SUMO.IO.repository;

import com.example.SUMO.IO.catalog.model.ConfigCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigCatalogRepository extends JpaRepository<ConfigCatalog, Long> {
    // Custom query methods if necessary
}
