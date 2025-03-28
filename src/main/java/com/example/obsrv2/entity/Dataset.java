// package com.example.obsrv.entity;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDateTime;
// import java.util.List;
// //import java.util.Map;

// @Data
// @Entity
// @Table(name = "datasets")
// public class Dataset {

//     @Id
//     private String id;

//     @Column(name = "dataset_id")
//     private String datasetId;

//     @Column(name = "type")
//     private String type;

//     @Column(name = "name")
//     private String name;

//     @Column(name = "validation_config", columnDefinition = "json")
//     private String validationConfig;

//     @Column(name = "extraction_config", columnDefinition = "json")
//     private String extractionConfig;

//     @Column(name = "dedup_config", columnDefinition = "json")
//     private String dedupConfig;

//     @Column(name = "data_schema", columnDefinition = "json")
//     private String dataSchema;

//     @Column(name = "denorm_config", columnDefinition = "json")
//     private String denormConfig;

//     @Column(name = "router_config", columnDefinition = "json")
//     private String routerConfig;

//     @Column(name = "dataset_config", columnDefinition = "json")
//     private String datasetConfig;

//     @Column(name = "status")
//     private String status;

//     @Column(name = "tags")
//     @ElementCollection
//     private List<String> tags;

//     @Column(name = "data_version")
//     private Integer dataVersion;

//     @Column(name = "created_by")
//     private String createdBy;

//     @Column(name = "updated_by")
//     private String updatedBy;

//     @Column(name = "created_date")
//     private LocalDateTime createdDate;

//     @Column(name = "updated_date")
//     private LocalDateTime updatedDate;

//     @Column(name = "published_date")
//     private LocalDateTime publishedDate;
// }


package com.example.obsrv2.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.Type;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "datasets")
@DynamicUpdate
public class Dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    // @Version
    // private Long version;
    @Version
    @Column(name = "version")
    private Long version;


    @Column(name = "dataset_id", nullable = false)
    private String datasetId;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "validation_config", columnDefinition = "jsonb")
    private String validationConfig;

    @Column(name = "extraction_config", columnDefinition = "jsonb")
    private String extractionConfig;

    @Column(name = "dedup_config", columnDefinition = "jsonb")
    private String dedupConfig;

    @Column(name = "data_schema", columnDefinition = "jsonb")
    private String dataSchema;

    @Column(name = "denorm_config", columnDefinition = "jsonb")
    private String denormConfig;

    @Column(name = "router_config", columnDefinition = "jsonb")
    private String routerConfig;

    @Column(name = "dataset_config", columnDefinition = "jsonb")
    private String datasetConfig;

    @Column(name = "status")
    private String status;

    @ElementCollection
    @CollectionTable(name = "dataset_tags", joinColumns = @JoinColumn(name = "dataset_id"))
    @Column(name = "tag")
    private List<String> tags;

    @Column(name = "data_version")
    private Integer dataVersion;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "published_date")
    private LocalDateTime publishedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
