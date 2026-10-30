package com.example.metrics.service;

import com.example.metrics.dto.MetricsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Comparator;

@Service
public class MetricsService {

    private static final List<Integer> NUMEROS = List.of(
        17, 204, 55, 81, 902, 33, 710, 12,
        6543, 88, 19, 456, 72, 9001, 123,
        76, 4555, 997, 31, 600, 248, 1111,
        45000, 7, 390, 8421, 678, 99999,
        2345, 16
    );

    public MetricsResponse calcularMetricas() {

        int total = NUMEROS.size();

        long suma = NUMEROS.stream()
            .mapToLong(Integer::longValue)
            .sum();

        double media = (double) suma / total;

        long sumaPares = NUMEROS.stream()
            .filter(n -> n % 2 == 0)
            .mapToLong(Integer::longValue)
            .sum();

        long sumaImpares = suma - sumaPares;

        List<Integer> ascendente = NUMEROS.stream()
            .sorted()
            .toList();

        List<Integer> descendente = NUMEROS.stream()
            .sorted(Comparator.reverseOrder())
            .toList();

        double mediana;

        if (total % 2 == 0) {
            mediana = (
                (long) ascendente.get(total / 2 - 1)
                + ascendente.get(total / 2)
            ) / 2.0;
        } else {
            mediana = ascendente.get(total / 2);
        }

        List<Integer> sinDuplicados = NUMEROS.stream()
            .distinct()
            .toList();

        List<Integer> top5 = descendente.stream()
            .limit(5)
            .toList();

        return new MetricsResponse(
            total,
            suma,
            media,
            sumaPares,
            sumaImpares,
            ascendente,
            descendente,
            mediana,
            sinDuplicados,
            top5
        );
    }
}