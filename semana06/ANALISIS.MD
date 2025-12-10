# Análisis de Diseño - Semana 06: Abstracción e Interfaces en Agencia de Viajes

## 1. Identificación de Abstracciones

### Clase Abstracta
**Nombre:** `ServicioTuristico` (Ubicado en `abstractas/`)

**¿Por qué es abstracta?**
Elegimos hacer `ServicioTuristico` abstracta porque un "servicio" genérico no existe en la realidad de la agencia; un cliente siempre reserva un tipo concreto: un vuelo, un hotel o un paquete. La clase se definió abstracta para:
1.  **Imponer un Contrato:** Obligar a todas las subclases (Vuelo, Hotel, Tour, Paquete) a implementar métodos esenciales y variables como `calcularCostoTotal()` y `obtenerDescripcionDetallada()`, ya que la lógica de cálculo varía drásticamente entre ellas.
2.  **Compartir Estado y Comportamiento:** Compartir atributos (`nombre`, `precioBase`, `proveedor`) y métodos comunes (`mostrarInformacionBase()`).

**Jerarquía:**
<<abstract>>
ServicioTuristico (Compartir estado y comportamiento base)
      |
+-----+-----+-----+------+
|     |     |     |
Vuelo Hotel Tour PaqueteTuristico (Implementan la lógica de cálculo específica)


---

## 2. Interfaces Implementadas

### Interface 1: `Reservable`
**Capacidad que define:** El contrato para gestionar la disponibilidad y registrar formalmente una reserva.

**Clases que la implementan:**
- **`Vuelo`**: Necesita verificar la disponibilidad de asientos y emitir un código de reserva de vuelo.
- **`PaqueteTuristico`**: La venta final de un paquete requiere la generación de un código de reserva global.

### Interface 2: `Calificable`
**Capacidad que define:** El contrato para recibir, almacenar y procesar las valoraciones de los clientes (calificaciones/estrellas).

**Clases que la implementan:**
- **`Hotel`**: La reputación y promedio de calificaciones son esenciales para este servicio.
- **`PaqueteTuristico`**: Los paquetes son evaluados por la experiencia completa que ofrecen.

---

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

| Característica | Clase Abstracta (`ServicioTuristico`) | Interface (`Reservable`, `Calificable`) |
| :--- | :--- | :--- |
| **Relación** | "Es-un" (`Vuelo` **es un** `ServicioTuristico`) | "Puede-hacer" (`Hotel` **puede ser** `Calificable`) |
| **Implementación** | Necesitaba compartir atributos (`protected`) y lógica base (`mostrarInformacionBase`). | Solo define el **contrato** (qué hacer), no cómo hacerlo, permitiendo implementación múltiple. |
| **Propósito** | Definir la jerarquía fundamental del sistema de inventario. | Definir capacidades transversales que pueden ser implementadas por clases de diferentes jerarquías. |

---

## 4. Principios SOLID Aplicados

### Single Responsibility Principle (SRP)
- Las interfaces (`Reservable`, `Calificable`) separan las preocupaciones: una se encarga solo de la reserva, la otra solo de la calificación, impidiendo que una clase como `Hotel` tenga métodos de reserva si no los necesita.

### Open/Closed Principle (OCP)
- El diseño es **abierto a extensión** pero **cerrado a modificación**. Si se añade un nuevo servicio (ej. `AlquilerAuto`), solo se crea una nueva subclase que extiende `ServicioTuristico` e implementa las interfaces pertinentes. El código de la clase abstracta o el bucle de procesamiento en `Main.java` no necesitan modificarse (solo extenderse).

### Liskov Substitution Principle (LSP)
- Se cumple al 100%. Las subclases (`Vuelo`, `Hotel`, `PaqueteTuristico`) pueden ser sustituidas por la clase abstracta (`ServicioTuristico`) o por las interfaces que implementan (`Reservable`, `Calificable`) sin causar errores de comportamiento en tiempo de ejecución (dynamic binding).

### Interface Segregation Principle (ISP)
- Se cumple al usar interfaces pequeñas y específicas. Creamos `Reservable` y `Calificable` en lugar de una única interfaz grande (`IServicio`) con todos los métodos, asegurando que las clases solo implementen lo que realmente necesitan.

---

## 5. Mejoras Logradas

**Antes (Semana 05 - Solo Herencia):**
- La herencia era suficiente para la jerarquía, pero limitada para las capacidades. Si un `Cliente` también tuviera que ser `Calificable` (para calificar al agente), la herencia no permitiría compartir esa capacidad con `Hotel`.

**Después (Semana 06 - Abstracción e Interfaces):**
- **Flexibilidad y Reutilización:** Las interfaces permiten que el sistema de reportes o el gestor de reservas trabaje con cualquier objeto que cumpla el contrato (`Reservable`), sin importar su tipo (`Vuelo` o `PaqueteTuristico`).
- **Claridad del Diseño:** La abstracción obligó a definir la lógica de costo en el lugar correcto (cada subclase), haciendo el código más limpio y fácil de mantener (OCP).

---

## 6. Diagrama de Clases



---

## 7. Desafíos y Soluciones

**Desafío 1:** ¿Cómo manejar la implementación múltiple?
**Solución:** Se utilizó la clase **`PaqueteTuristico`** para demostrar que una clase puede extender una clase abstracta y, al mismo tiempo, implementar múltiples interfaces (`implements Reservable, Calificable`), combinando jerarquía y capacidades.

**Desafío 2:** ¿A qué nivel colocar el polimorfismo?
**Solución:** Se demostró el polimorfismo a dos niveles en `Main.java`:
1.  **Nivel Jerárquico:** Usando `ArrayList<ServicioTuristico>` para llamar a `calcularCostoTotal()`.
2.  **Nivel de Capacidad:** Usando referencias de tipo interfaz (`Reservable reservableVuelo = ...`) para invocar métodos como `realizarReserva()`.

---

## 8. Próximos Pasos

En futuras semanas, podríamos aplicar la **Inversión de Dependencias (DIP)** creando un `GestorReservas` que no dependa de `Vuelo` o `Hotel` concretos, sino que dependa únicamente de la abstracción `Reservable`.