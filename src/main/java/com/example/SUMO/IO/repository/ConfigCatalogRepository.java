package com.example.SUMO.IO.repository;

import com.example.SUMO.IO.catalog.model.ConfigCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConfigCatalogRepository extends JpaRepository<ConfigCatalog, Long> {
    List<ConfigCatalog> findByEcuName(String ecuName);
    List<ConfigCatalog> findByVersion(String version);
    List<ConfigCatalog> findByReleaseDate(LocalDateTime releaseDate);
}
