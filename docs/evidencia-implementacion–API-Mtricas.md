# Evidencia de implementación — API de Métricas

## 1. Objetivo

Documentar la implementación y validación de una API REST desarrollada con Java 17 y Spring Boot para el procesamiento de una colección de números enteros.

La solución incluye el cálculo de métricas, un frontend HTML para visualizar los resultados y pruebas unitarias para verificar la lógica de programación.

## 2. Tecnologías utilizadas

- Java 17
- Spring Boot 4.0.9
- Maven
- Spring Web MVC
- HTML5, CSS3 y JavaScript
- JUnit 5
- Git

No se utilizaron bases de datos ni librerías externas de estadísticas.

## 3. Arquitectura implementada

El backend se organizó mediante una separación de responsabilidades:

**MetricsController → MetricsService → MetricsResponse**

- **MetricsController:** expone el endpoint HTTP y delega el procesamiento al servicio.
- **MetricsService:** implementa los cálculos utilizando colecciones y Streams de Java.
- **MetricsResponse:** utiliza un `record` de Java 17 para definir la estructura de la respuesta.
- **Frontend:** consume la API mediante `fetch()` y presenta los resultados en un dashboard responsive.

Esta organización facilita el mantenimiento y permite probar la lógica sin depender del servidor HTTP.

## 4. Implementación de la API REST

**Método:** GET

**Endpoint:** `/api/metrics`

**URL local:** `http://localhost:8080/api/metrics`

El endpoint procesa una colección estática de 30 enteros y devuelve un objeto JSON con las siguientes propiedades:

| Propiedad | Descripción |
|---|---|
| totalElementos | Cantidad de números |
| sumaTotal | Suma de todos los elementos |
| media | Media aritmética |
| sumaPares | Suma de los valores pares |
| sumaImpares | Suma de los valores impares |
| ordenAscendente | Lista ordenada de menor a mayor |
| ordenDescendente | Lista ordenada de mayor a menor |
| mediana | Valor central de los elementos ordenados |
| sinDuplicados | Lista con valores únicos |
| top5Mayores | Cinco valores más grandes |

### Resultados verificados

| Métrica | Resultado |
|---|---:|
| Total de elementos | 30 |
| Suma total | 182790 |
| Media | 6093.00 |
| Suma de pares | 49452 |
| Suma de impares | 133338 |
| Mediana | 319.00 |
| Elementos únicos | 30 |

**Top 5 mayores:** 99999, 45000, 9001, 8421, 6543.

## 5. Lógica de programación

Se utilizaron operaciones de Java Streams para procesar la colección:

- `filter()` para identificar números pares.
- `mapToLong()` y `sum()` para calcular las sumas.
- `sorted()` para realizar los ordenamientos.
- `distinct()` para eliminar duplicados.
- `limit()` para obtener los cinco números mayores.
- `toList()` para construir las listas de resultados.

La media se obtiene dividiendo la suma total entre la cantidad de elementos. La mediana se calcula a partir de la colección ordenada, considerando si la cantidad de elementos es par o impar.

La complejidad temporal general es **O(n log n)** debido a las operaciones de ordenamiento.

## 6. Implementación del frontend

Se desarrolló un dashboard utilizando HTML, CSS y JavaScript sin frameworks adicionales.

El frontend incluye:

- Tarjetas con indicadores principales.
- Visualización de números pares e impares.
- Listas ordenadas.
- Top 5 de números mayores.
- Cantidad de elementos únicos.
- Botón para actualizar los datos.
- Diseño adaptable a diferentes tamaños de pantalla.
- Manejo de errores de comunicación con la API.

Los datos se obtienen mediante una petición HTTP GET a `/api/metrics`.

### Evidencia visual

La siguiente captura muestra el dashboard ejecutándose localmente y presentando las métricas obtenidas desde la API REST.

![Dashboard de métricas](./captura-dashboard.png)

## 7. Pruebas unitarias

Se implementaron pruebas unitarias con JUnit para validar el servicio de métricas.

Los escenarios verificados incluyen:

1. Cálculo del total de elementos, suma y media.
2. Separación y suma de números pares e impares.
3. Ordenamiento ascendente y descendente.
4. Cálculo de la mediana.
5. Obtención de los cinco valores mayores.
6. Obtención de la colección sin duplicados.

Adicionalmente, se ejecutó la prueba de carga del contexto de Spring Boot.

**Resultado de ejecución:**

| Indicador | Resultado |
|---|---:|
| Pruebas ejecutadas | 7 |
| Pruebas exitosas | 7 |
| Fallos | 0 |
| Errores | 0 |
| Omitidas | 0 |
| Compilación | BUILD SUCCESS |

Comando utilizado: `./mvnw clean test`

## 8. Verificación funcional

Se verificó que:

- La aplicación inicia correctamente en el puerto 8080.
- El endpoint `/api/metrics` devuelve las métricas en formato JSON.
- El frontend consume correctamente la API.
- Los datos se visualizan en el dashboard.
- Las siete pruebas automatizadas finalizan correctamente.
- La aplicación funciona sin configurar una base de datos.

## 9. Conclusión

Se implementó una solución funcional que cumple los requisitos de la práctica técnica, incluyendo las métricas principales y las funcionalidades adicionales solicitadas.

La solución utiliza separación de responsabilidades, características de Java 17, procesamiento de colecciones, comunicación REST y pruebas automatizadas.

El proyecto también incluye un README con instrucciones para su instalación, ejecución y validación.