package com.example.SUMO.IO.catalog.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rd_catalog")
@Getter
@Setter
public class RDCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ecuName;
    private String rdType;
    private String version;
    private String containerId;
    private String uploadedBy;
    private LocalDate dateUploaded;

    private String rdName;
    private Long rdSize;
    private String calName;
    private Long calSize;
    private String testReport;
    private String releaseNotes;

}
