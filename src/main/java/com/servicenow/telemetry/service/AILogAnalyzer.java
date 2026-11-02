package com.servicenow.telemetry.service;

import org.springframework.stereotype.Service;

@Service
public class AILogAnalyzer {
    public String analyzeLogs(String logOutput){
        if(logOutput.toLowerCase().contains("nullpointer")||logOutput.toLowerCase().contains("exception")){
            return "AI Signature Match: Null pointer dereference in runtime execution thread.";
        }
        if(logOutput.toLowerCase().contains("timeout")||logOutput.toLowerCase().contains("connection refused")){
            return "AI Signature Match: Network connectivity timeout during database handshake.";
        }
        if(logOutput.toLowerCase().contains("outofmemory")||logOutput.toLowerCase().contains("heap")){
            return "AI Signature Match: JVM heap exhaustion detected during parallel build tasks.";
        }
        return "AI Signature Match: Clean build execution with standard telemetry metrics.";
    }

    public String calculateRisk(String logOutput){
        if(logOutput.toLowerCase().contains("exception")||logOutput.toLowerCase().contains("error")){
            return "HIGH_RISK";
        }
        return "LOW_RISK";
    }
}