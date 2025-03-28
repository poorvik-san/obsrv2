package com.example.obsrv2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.obsrv2.entity.Dataset;
import com.example.obsrv2.service.DatasetService;

@RestController
@RequestMapping("/v1/dataset")
public class DatasetController {

    private final DatasetService datasetService;

    public DatasetController(DatasetService datasetService) {
        this.datasetService = datasetService;
        System.out.println((this.datasetService.toString()));
    }

    @PostMapping
    public ResponseEntity<Dataset> createDataset(@RequestBody Dataset dataset) {
        Dataset savedDataset = datasetService.createDataset(dataset);
        System.out.println(savedDataset.toString());
        return ResponseEntity.ok(savedDataset);
    }
}
