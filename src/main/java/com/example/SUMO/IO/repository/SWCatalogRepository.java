package com.example.SUMO.IO.repository;

import com.example.SUMO.IO.catalog.model.SWCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SWCatalogRepository extends JpaRepository<SWCatalog, Long> {
    List<SWCatalog> findByEcuName(String ecuName);
    List<SWCatalog> findByVersion(String version);
    List<SWCatalog> findByReleaseDate(LocalDateTime releaseDate);
}
