package com.servicenow.telemetry.service;

import com.servicenow.telemetry.model.BuildJob;
import com.servicenow.telemetry.repository.BuildJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TelemetryEngineService {
    @Autowired
    private BuildJobRepository buildJobRepository;
    @Autowired
    private AILogAnalyzer aiLogAnalyzer;

    private final ExecutorService executorService=Executors.newFixedThreadPool(4);

    public BuildJob processBuildJob(BuildJob job){
        executorService.submit(()->{
            String analysis=aiLogAnalyzer.analyzeLogs(job.getLogOutput());
            String risk=aiLogAnalyzer.calculateRisk(job.getLogOutput());
            job.setAiAnalysis(analysis);
            job.setRiskLevel(risk);
            buildJobRepository.save(job);
        });
        job.setAiAnalysis("Processing asynchronously...");
        job.setRiskLevel("PENDING");
        return buildJobRepository.save(job);
    }

    public List<BuildJob> getAllJobs(){
        return buildJobRepository.findAll();
    }
}