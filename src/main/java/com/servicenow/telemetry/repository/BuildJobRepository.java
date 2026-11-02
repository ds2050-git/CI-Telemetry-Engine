package com.servicenow.telemetry.repository;

import com.servicenow.telemetry.model.BuildJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildJobRepository extends JpaRepository<BuildJob,Long> {}