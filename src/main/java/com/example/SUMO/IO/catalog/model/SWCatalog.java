package com.example.SUMO.IO.catalog.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sw_catalog")
public class SWCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ecuName;
    private String swType;
    private String version;
    private String containerId;
    private String uploadedBy;
    private LocalDate dateUploaded;

    private String swName;
    private Long swSize;
    private String calName;
    private Long calSize;
    private String testReport;
    private String releaseNotes;
    @Column(nullable = false)
    private LocalDateTime releaseDate;
}
