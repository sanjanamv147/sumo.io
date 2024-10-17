package com.example.SUMO.IO.catalog.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "config_catalog")
@Getter
@Setter
public class ConfigCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ecuName;
    private String configType;
    private String version;
    private String containerId;
    private String uploadedBy;
    private LocalDate dateUploaded;

    private String configName;
    private Long configSize;
    private String calName;
    private Long calSize;
    private String testReport;
    private String releaseNotes;

}
