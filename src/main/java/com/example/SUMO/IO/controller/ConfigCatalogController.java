package com.example.SUMO.IO.controller;

import com.example.SUMO.IO.catalog.model.ConfigCatalog;
import com.example.SUMO.IO.service.ConfigCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/config-catalog")
public class ConfigCatalogController {

    @Autowired
    private ConfigCatalogService configCatalogService;

    @GetMapping("/list")
    public List<ConfigCatalog> getAllConfigCatalogs() {
        return configCatalogService.getAllConfigCatalogs();
    }

    @PostMapping("/upload")
    public ConfigCatalog uploadConfigCatalog(@RequestBody ConfigCatalog configCatalog) {
        return configCatalogService.uploadConfigCatalog(configCatalog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigCatalog> getConfigCatalogById(@PathVariable Long id) {
        return configCatalogService.getCatalogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/retire/{id}")
    public ResponseEntity<Void> retireConfigCatalog(@PathVariable Long id) {
        configCatalogService.retireCatalog(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/download")
    public ResponseEntity<?> downloadFiles(@RequestParam Long id, @RequestParam String fileType) {
        // Logic to download Test Report or Release Notes
        // You will have to handle file download logic here based on fileType
        return ResponseEntity.ok("File downloaded: " + fileType);
    }


    @GetMapping("/filter")
    public ResponseEntity<List<ConfigCatalog>> filterConfigCatalog(
            @RequestParam(value = "ecuName", required = false) String ecuName,
            @RequestParam(value = "version", required = false) String version,
            @RequestParam(value = "releaseDate", required = false) LocalDateTime releaseDate) {

        List<ConfigCatalog> filteredList = configCatalogService.filterConfigCatalog(ecuName, version, releaseDate);
        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<ConfigCatalog>> sortConfigCatalog(
            @RequestParam(value = "sortBy", defaultValue = "uploadDateTime") String sortBy,
            @RequestParam(value = "ascending", defaultValue = "true") boolean ascending) {

        List<ConfigCatalog> sortedSoftwareList = configCatalogService.sortConfigCatalog(sortBy, ascending);
        return ResponseEntity.ok(sortedSoftwareList);
    }
}
