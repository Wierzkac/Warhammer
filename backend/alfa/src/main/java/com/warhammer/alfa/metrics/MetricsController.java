package com.warhammer.alfa.metrics;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class MetricsController {

    @GetMapping("/summary")
    public Map<String, Object> getMetricsSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("message", "Metrics are available at /actuator/prometheus");
        summary.put("endpoints", new String[]{
            "/actuator/health",
            "/actuator/info", 
            "/actuator/metrics",
            "/actuator/prometheus"
        });
        return summary;
    }
} 