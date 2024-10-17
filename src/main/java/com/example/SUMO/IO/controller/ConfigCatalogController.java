package com.example.SUMO.IO.controller;

import com.example.SUMO.IO.catalog.model.ConfigCatalog;
import com.example.SUMO.IO.service.ConfigCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
