package com.servicenow.telemetry.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="build_jobs")
public class BuildJob {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String jobName;
    private String status;
    @Column(columnDefinition="TEXT")
    private String logOutput;
    @Column(columnDefinition="TEXT")
    private String aiAnalysis;
    private String riskLevel;
    private LocalDateTime createdAt=LocalDateTime.now();

    public BuildJob(){}

    public BuildJob(String jobName,String status,String logOutput){
        this.jobName=jobName;
        this.status=status;
        this.logOutput=logOutput;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getJobName(){return jobName;}
    public void setJobName(String jobName){this.jobName=jobName;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
    public String getLogOutput(){return logOutput;}
    public void setLogOutput(String logOutput){this.logOutput=logOutput;}
    public String getAiAnalysis(){return aiAnalysis;}
    public void setAiAnalysis(String aiAnalysis){this.aiAnalysis=aiAnalysis;}
    public String getRiskLevel(){return riskLevel;}
    public void setRiskLevel(String riskLevel){this.riskLevel=riskLevel;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
}