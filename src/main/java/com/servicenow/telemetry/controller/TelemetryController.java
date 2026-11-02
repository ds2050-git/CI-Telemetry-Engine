package com.servicenow.telemetry.controller;

import com.servicenow.telemetry.model.BuildJob;
import com.servicenow.telemetry.service.TelemetryEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telemetry")
@CrossOrigin(origins="*")
public class TelemetryController {
    @Autowired
    private TelemetryEngineService telemetryEngineService;

    @PostMapping
    public BuildJob submitJob(@RequestBody BuildJob job){
        return telemetryEngineService.processBuildJob(job);
    }

    @GetMapping
    public List<BuildJob> getAllJobs(){
        return telemetryEngineService.getAllJobs();
    }
}