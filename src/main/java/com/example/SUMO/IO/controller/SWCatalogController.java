package com.example.SUMO.IO.controller;


import com.example.SUMO.IO.catalog.model.SWCatalog;
import com.example.SUMO.IO.service.SWCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sw-catalog")
public class SWCatalogController {

    @Autowired
    private SWCatalogService swCatalogService;

    @GetMapping("/list")
    public List<SWCatalog> getAllSWCatalogs() {
        return swCatalogService.getAllSWCatalogs();
    }

    @PostMapping("/upload")
    public SWCatalog uploadSWCatalog(@RequestBody SWCatalog swCatalog) {
        return swCatalogService.uploadSWCatalog(swCatalog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SWCatalog> getSWCatalogById(@PathVariable Long id) {
        return swCatalogService.getCatalogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/retire/{id}")
    public ResponseEntity<Void> retireSWCatalog(@PathVariable Long id) {
        swCatalogService.retireCatalog(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/download")
    public ResponseEntity<?> downloadFiles(@RequestParam Long id, @RequestParam String fileType) {
        // Logic to download Test Report or Release Notes
        // You will have to handle file download logic here based on fileType
        return ResponseEntity.ok("File downloaded: " + fileType);
    }
}
