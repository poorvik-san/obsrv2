package com.example.obsrv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.obsrv2.entity.Dataset;
import com.example.obsrv2.repository.DatasetRepository;

import java.time.LocalDateTime;

@Service
public class DatasetService {

    private final DatasetRepository datasetRepository;

    public DatasetService(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    @Transactional
    public Dataset createDataset(Dataset dataset) {
        dataset.setCreatedDate(LocalDateTime.now());
        dataset.setUpdatedDate(LocalDateTime.now());
        return datasetRepository.save(dataset);
    }
}

