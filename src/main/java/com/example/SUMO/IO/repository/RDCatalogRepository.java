package com.example.SUMO.IO.repository;

import com.example.SUMO.IO.catalog.model.RDCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RDCatalogRepository extends JpaRepository<RDCatalog, Long> {
    List<RDCatalog> findByEcuName(String ecuName);
    List<RDCatalog> findByVersion(String version);
    List<RDCatalog> findByReleaseDate(LocalDateTime releaseDate);
}
