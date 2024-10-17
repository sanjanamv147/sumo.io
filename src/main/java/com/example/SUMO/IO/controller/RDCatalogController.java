package com.example.SUMO.IO.controller;

import com.example.SUMO.IO.catalog.model.RDCatalog;
import com.example.SUMO.IO.service.RDCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rd-catalog")
public class RDCatalogController {

    @Autowired
    private RDCatalogService rdCatalogService;

    @GetMapping("/list")
    public List<RDCatalog> getAllRDCatalogs() {
        return rdCatalogService.getAllRDCatalogs();
    }

    @PostMapping("/upload")
    public RDCatalog uploadRDCatalog(@RequestBody RDCatalog rdCatalog) {
        return rdCatalogService.uploadRDCatalog(rdCatalog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RDCatalog> getRDCatalogById(@PathVariable Long id) {
        return rdCatalogService.getCatalogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/retire/{id}")
    public ResponseEntity<Void> retireRDCatalog(@PathVariable Long id) {
        rdCatalogService.retireCatalog(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/download")
    public ResponseEntity<?> downloadFiles(@RequestParam Long id, @RequestParam String fileType) {
        // Logic to download Test Report or Release Notes
        // You will have to handle file download logic here based on fileType
        return ResponseEntity.ok("File downloaded: " + fileType);
    }
}
