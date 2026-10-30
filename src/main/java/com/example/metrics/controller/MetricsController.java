package com.example.metrics.controller;

import com.example.metrics.dto.MetricsResponse;
import com.example.metrics.service.MetricsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MetricsController {

    private final MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping("/metrics")
    public MetricsResponse obtenerMetricas() {
        return metricsService.calcularMetricas();
    }
}