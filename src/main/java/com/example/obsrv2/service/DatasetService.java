package com.example.obsrv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.obsrv2.entity.Dataset;
import com.example.obsrv2.repository.DatasetRepository;

import java.time.LocalDateTime;
// import org.springframework.retry.annotation.Retryable;
// import org.springframework.retry.annotation.Backoff;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

@Service
public class DatasetService {

    private final DatasetRepository datasetRepository;
    

    public DatasetService(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    @Transactional
    public Dataset createDataset(Dataset dataset) {
        System.out.println("create dataset...");

        dataset.setCreatedDate(LocalDateTime.now());
        dataset.setUpdatedDate(LocalDateTime.now());
        System.out.println(dataset.toString());
        return datasetRepository.save(dataset);
    }
}

