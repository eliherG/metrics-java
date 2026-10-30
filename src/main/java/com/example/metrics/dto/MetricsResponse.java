package com.example.metrics.dto;

import java.util.List;

public record MetricsResponse(
    int totalElementos,
    long sumaTotal,
    double media,
    long sumaPares,
    long sumaImpares,
    List<Integer> ordenAscendente,
    List<Integer> ordenDescendente,
    double mediana,
    List<Integer> sinDuplicados,
    List<Integer> top5Mayores
) {}