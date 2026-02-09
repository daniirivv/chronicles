# Diseño

---

## Value Object
El _value object_ es un objeto que encapsula un valor y sus reglas de dominio asociadas.

### ¿Cómo detectarlo?

* ✅ Tiene significado en el dominio 
* ✅ Tiene reglas propias 
* ✅ Puede evolucionar 
* ✅ Quieres evitar estados inválidos SIEMPRE
* ✅ Se comporta más como un “concepto” que como un dato bruto

### Caso de uso:
Podemos tener un atributo `rating` de tipo Integer, sobre el que debemos de forzar que se mantenga en un intervalo (algo así):

```java
class Entry{
    //...
    private Integer rating;
    
    public Entry(Integer rating){ // + otros parámetros
        //...
        rating(rating); //Hay que llamar al método, porque si no, no se comprueba la lógica
    }
    
    //...
    
    private void setRating(Integer rating){
        this.rating = rating;
    }
    
    public void rating(Integer rating){
        if(rating >= 0 && rating <= 5) setRating(rating);
        else throw new InvalidRatingException();
    }
}
```

Sin embargo, es mejor encapsular esta lógica en un _value object_ `Rating`, de esta forma:

```java
class Entry{
    //...
    private Rating rating;
    
    //...
    private void setRating(Rating rating){
        this.rating = rating;
    }
}

public final class Rating {

    private final int value;

    private static final int MIN = 1;
    private static final int MAX = 5;

    public Rating(int value) {
        if (value < MIN || value > MAX) {
            throw new InvalidRatingException(value);
        }
        this.value = value;
    }

    public int value() {
        return value;
    }
}
```

Incluso, podríamos plantear una factoría estática de la siguiente manera:
```java
public static Rating of(Integer value) { return new Rating(value); }
```

Esta opción es, si cabe, más expresiva y directa al uso.

---
## Programación defensiva VS lanzamiento de excepciones

---

# Arquitectura

---

# Metodologías

---

# Testing

## Anotaciones

### `@BeforeEach`

Sirve para:

* **Inicialización de Objetos (Setup)**: Instancia la clase que se va a probar (comúnmente llamada "System Under Test" o SUT).
* **Preparación de Datos**: Configura escenarios, carga datos necesarios o inicializar estructuras de datos.
* **Evitar el Código Repetitivo (Boilerplate)**: Elimina la necesidad de crear los mismos objetos al inicio de cada método de prueba, manteniendo los tests concisos y centrados en la acción principal.
* **Garantizar Aislamiento**: Al recrear el entorno antes de cada test, se evita que los efectos secundarios de una prueba afecten a la siguiente.

En vez de:

```java
@Test
void correctInitialCompletionState() {
    BookEntry bookEntry = new BookEntry("Gerónimo Stilton");

    assertEquals(CompletionState.PLANEADO, bookEntry.getState());
}

@Test
void shouldReturnErrorWhenRatingWithoutCompletion() {
    BookEntry bookEntry = new BookEntry("Gerónimo Stilton");

    assertThrows(InvalidStateException.class, () -> bookEntry.rate(Rating.of(3)));
}
```

Se transforma en:

```java
@BeforeEach
void initializeBook() {
    BookEntry bookEntry = new BookEntry("Gerónimo Stilton");
}

@Test
void correctInitialCompletionState() {
    assertEquals(CompletionState.PLANEADO, bookEntry.getState());
}

@Test
void shouldReturnErrorWhenRatingWithoutCompletion() {
    assertThrows(InvalidStateException.class, () -> bookEntry.rate(Rating.of(3)));
}
```

---

# Version Control

---

# Java Language

---

# IntellIJ IDE

---