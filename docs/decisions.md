-## DR-01: Adopción de Test-Driven Development (TDD)

Fecha: 08/02/2005

### Contexto
El proyecto requiere gestionar diversos tipos de medios (películas, libros, etc.). Para asegurar la calidad del código desde el inicio y facilitar la futura migración a Spring Boot, necesitamos un mecanismo que valide la lógica de negocio de forma automática y evite errores al refactorizar.

### Decisión
Implementaremos la metodología **TDD (Test-Driven Development)** siguiendo el ciclo:
1. 🔴 **Red**: Escribir una prueba que falle para una pequeña funcionalidad
2. 🟢 **Green**: Escribir el código mínimo necesario para que la prueba pase
3. 🔵 **Refactor**: Optimizar el código manteniendo las pruebas en verde

Utilizaremos **JUnit 5** como framework de pruebas para la aplicación Java inicial

### Consecuencias
* **Positivas**:
    * Cobertura de código cercana al 100%
    * Diseño de código más modular y limpio
    * Documentación viva de cómo debe comportarse el software
* **Negativas**:
    * Mayor tiempo de desarrollo inicial
    * Curva de aprendizaje para escribir tests efectivos antes que el código

---

## DR-02: Separación de UserRating e ImdbRating

Fecha: 09/02/2026

### Contexto
El sistema necesita manejar dos tipos de valoraciones:

- **UserRating**: valoración personal del usuario (escala 1–5).
- **ImdbRating**: valoración externa proveniente de IMDb (escala 0–10 con decimales).

Se planteó crear una jerarquía común mediante una herencia para reutilizar lógica de validación.

### Decisión
Separar ambos conceptos en clases independientes:

- `UserRating` como Value Object del dominio interno.
- `ImdbRating` como dato externo asociado únicamente a ciertas entidades (Series y Películas).

Sin utilizar herencia entre ellos.

### Justificación

**Modelo honesto del dominio**  
IMDbRating no es un UserRating. Representan realidades distintas.

**Mayor legibilidad**  
El código expresa intención de forma inmediata:

```java
entry.setUserRating(...);
entry.setImdbRating(...);
```

**Menor acoplamiento**  
Cambios en la escala o reglas de IMDb no afectarán al rating del usuario.

**Evita herencia artificial**  
La herencia debe modelar una relación “ES UN”, no simplemente similitud estructural.

### Consecuencias
* **Positivas**:
  - Modelo más expresivo
  - Mayor mantenibilidad
  - Mejor alineación con DDD (Domain Driven Development)
  - Menor riesgo de diseño rígido

* **Negativas**:
  - Ligera duplicación de lógica de validación
  - Más clases en el modelo

### Conclusiones

> ⚠️ La reutilización no es una razón válida para usar herencia.
>
> 🧠 La herencia modela realidad, no evita duplicación de código.

---

## DR-03: Estructura de carpetas

---