# ADR-01: Adopción de Test-Driven Development (TDD)

* **Fecha**: 08/02/2005

## Contexto
El proyecto requiere gestionar diversos tipos de medios (películas, libros, etc.). Para asegurar la calidad del código desde el inicio y facilitar la futura migración a Spring Boot, necesitamos un mecanismo que valide la lógica de negocio de forma automática y evite errores al refactorizar.

## Decisión
Implementaremos la metodología **TDD (Test-Driven Development)** siguiendo el ciclo:
1. 🔴 **Red**: Escribir una prueba que falle para una pequeña funcionalidad
2. 🟢 **Green**: Escribir el código mínimo necesario para que la prueba pase
3. 🔵 **Refactor**: Optimizar el código manteniendo las pruebas en verde

Utilizaremos **JUnit 5** como framework de pruebas para la aplicación Java inicial

## Consecuencias
* **Positivas**:
    * Cobertura de código cercana al 100%
    * Diseño de código más modular y limpio
    * Documentación viva de cómo debe comportarse el software
* **Negativas**:
    * Mayor tiempo de desarrollo inicial
    * Curva de aprendizaje para escribir tests efectivos antes que el código