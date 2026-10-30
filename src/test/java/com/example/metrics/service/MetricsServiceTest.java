package com.example.metrics.service;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetricsServiceTest {

    private final MetricsService service = new MetricsService();

    @Test
    void debeCalcularTotalSumaYMedia() {
        var resultado = service.calcularMetricas();

        assertEquals(30, resultado.totalElementos());
        assertEquals(182790L, resultado.sumaTotal());
        assertEquals(6093.0, resultado.media());
    }

    @Test
    void debeSepararParesEImpares() {
        var resultado = service.calcularMetricas();

        assertEquals(49452L, resultado.sumaPares());
        assertEquals(133338L, resultado.sumaImpares());

        assertEquals(
            resultado.sumaTotal(),
            resultado.sumaPares() + resultado.sumaImpares()
        );
    }

    @Test
    void debeOrdenarAscendenteYDescendente() {
        var resultado = service.calcularMetricas();

        assertEquals(7, resultado.ordenAscendente().get(0));
        assertEquals(99999, resultado.ordenDescendente().get(0));

        assertEquals(30, resultado.ordenAscendente().size());
        assertEquals(30, resultado.ordenDescendente().size());
    }

    @Test
    void debeCalcularMediana() {
        var resultado = service.calcularMetricas();

        assertEquals(319.0, resultado.mediana());
    }

    @Test
    void debeObtenerTop5Mayores() {
        var resultado = service.calcularMetricas();

        assertEquals(
            List.of(99999, 45000, 9001, 8421, 6543),
            resultado.top5Mayores()
        );
    }

    @Test
    void debeEliminarDuplicados() {
        var resultado = service.calcularMetricas();

        assertEquals(30, resultado.sinDuplicados().size());
        assertEquals(
            resultado.sinDuplicados().size(),
            resultado.sinDuplicados().stream().distinct().count()
        );
    }
}
