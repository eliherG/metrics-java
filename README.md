
# Metrics API — Java 17 + Spring Boot

Aplicación desarrollada como práctica técnica para demostrar
fundamentos de Java, lógica de programación, desarrollo de
APIs REST, frontend y pruebas unitarias.

El proyecto procesa una colección de 30 números enteros,
calcula métricas estadísticas y muestra los resultados en
un dashboard web.

## Tecnologías

- Java 17
- Spring Boot 4.0.9
- Maven
- Spring Web MVC
- HTML5 y CSS3
- JavaScript (Fetch API)
- JUnit 5

## Funcionalidades

### Métricas principales

- Total de elementos
- Suma total
- Media aritmética
- Suma de números pares
- Suma de números impares
- Orden ascendente
- Orden descendente

### Funcionalidades adicionales

- Cálculo de mediana
- Eliminación de duplicados
- Top 5 de números mayores
- Manejo de errores en el frontend
- Pruebas unitarias

## Arquitectura

Se utiliza una arquitectura por capas:

Controller → Service → DTO

- Controller: expone el endpoint REST.
- Service: contiene la lógica de cálculo.
- DTO: define la estructura de la respuesta JSON.
- Frontend: consume la API y presenta las métricas.

### Estructura del proyecto

```text
src/
├── main/
│   ├── java/com/example/metrics/
│   │   ├── MetricsApiApplication.java
│   │   ├── controller/
│   │   │   └── MetricsController.java
│   │   ├── service/
│   │   │   └── MetricsService.java
│   │   └── dto/
│   │       └── MetricsResponse.java
│   └── resources/
│       ├── application.properties
│       └── static/
│           └── index.html
└── test/
    └── java/com/example/metrics/
        ├── MetricsApiApplicationTests.java
        └── service/
            └── MetricsServiceTest.java
```

## Requisitos

- JDK 17
- Maven, o utilizar Maven Wrapper incluido

No se requiere base de datos ni servicios externos.

## Instalación y ejecución

Desde la raíz del proyecto:

### 1. Ejecutar la aplicación

En macOS o Linux:

```bash
./mvnw spring-boot:run
```

En Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

### 2. Consultar la API

Endpoint:

GET http://localhost:8080/api/metrics

También se puede consultar con cURL:

```bash
curl http://localhost:8080/api/metrics
```

### 3. Abrir el frontend

Acceder desde el navegador:

http://localhost:8080/

El dashboard consume automáticamente la API REST.

## Resultados esperados

| Métrica | Resultado |
|---|---:|
| Total de elementos | 30 |
| Suma total | 182790 |
| Media | 6093.00 |
| Suma pares | 49452 |
| Suma impares | 133338 |
| Mediana | 319.00 |
| Elementos únicos | 30 |

Top 5 mayores:

```json
[99999, 45000, 9001, 8421, 6543]
```

## Pruebas unitarias

Las pruebas verifican:

1. Cantidad de elementos, suma y media.
2. Cálculo de números pares e impares.
3. Ordenamiento ascendente y descendente.
4. Cálculo de la mediana.
5. Obtención de los cinco valores mayores.
6. Eliminación de duplicados.

Ejecutar:

```bash
./mvnw clean test
```

Resultado verificado:

```text
Tests run: 7
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

El total incluye seis pruebas del servicio y una
prueba de contexto de Spring Boot.

## Decisiones técnicas

### Separación de responsabilidades

La lógica de negocio se encuentra en MetricsService,
separada del controlador REST.

Esto permite probar los cálculos sin iniciar
el servidor HTTP.

### Uso de Streams

Se utilizan operaciones como:

- filter()
- mapToLong()
- sum()
- sorted()
- distinct()
- limit()
- toList()

Estas operaciones permiten trabajar con colecciones
de manera declarativa.

### Uso de record

MetricsResponse se implementa como un record de Java 17
para representar la respuesta mediante un objeto
inmutable y reducir código repetitivo.

### Tipos numéricos

Se utiliza long para las sumas y double para
la media y mediana.

### Complejidad

Las operaciones de recorrido y suma tienen
complejidad O(n).

El ordenamiento tiene complejidad O(n log n).

La complejidad temporal general de los cálculos
es O(n log n), debido a los ordenamientos.

### Persistencia

Los datos se definen como una lista constante
dentro del servicio.

No se utiliza base de datos porque no es
un requisito del ejercicio.

### Manejo de errores

El frontend utiliza async/await, try/catch y
validación de respuestas HTTP para informar
al usuario cuando la API no está disponible.

## Consideraciones

- Los datos de entrada son fijos.
- La API no recibe parámetros.
- No se utilizan bibliotecas estadísticas externas.
- El frontend se sirve desde el mismo proyecto Spring Boot.
- El cálculo de duplicados conserva la primera aparición
  de cada valor.
- La lista proporcionada originalmente no tiene duplicados.

## Endpoint disponible

| Método | Ruta | Descripción |
|---|---|---|
| GET | /api/metrics | Obtiene todas las métricas |

## Autor

Proyecto realizado como evaluación técnica de
desarrollo Java y Spring Boot.
