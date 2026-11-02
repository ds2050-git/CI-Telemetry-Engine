CREATE TABLE IF NOT EXISTS build_jobs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job_name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    log_output TEXT NOT NULL,
    ai_analysis TEXT,
    risk_level VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_status ON build_jobs(status);
CREATE INDEX idx_risk ON build_jobs(risk_level);