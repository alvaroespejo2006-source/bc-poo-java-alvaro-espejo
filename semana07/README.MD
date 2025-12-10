# ✈️ Sistema de Gestión de Agencia de Viajes (POO en Java)

Este repositorio contiene la implementación incremental de un sistema de gestión para una Agencia de Viajes, aplicando conceptos de Programación Orientada a Objetos (POO) en Java.

---

## 🚀 Progreso del Proyecto

| Semana | Concepto Principal Aplicado | Foco del Dominio |
| :--- | :--- | :--- |
| **05** | Polimorfismo | Sobrecarga y Sobrescritura de métodos. |
| **06** | Abstracción e Interfaces | Clases Abstractas (`ServicioTuristico`) e Interfaces (`Reservable`, `Calificable`). |
| **07** | **Paquetes y Excepciones** | **Reorganización en paquetes** (`com.servicio.*`) y manejo de **errores de negocio** con excepciones personalizadas. |

---

## 📦 Estructura de Paquetes (Semana 07)

El código ha sido refactorizado para seguir una estructura de paquetes profesional, facilitando la modularidad y el mantenimiento:
src/ └── com/ └── servicio/ ├── excepciones/ <-- Excepciones de negocio (Ej. ReservaInvalidaException) ├── modelo/ <-- Entidades (Reserva, Vuelo, Hotel, Cliente) ├── servicio/ <-- Lógica de negocio (GestorReservas, GestorHoteles) └── Main.java <-- Punto de entrada y demostración


---

## 🚨 Foco de la Semana 07: Manejo de Errores

El objetivo principal fue asegurar la robustez del sistema mediante el manejo de errores específicos del dominio de la Agencia de Viajes.

### 1. Excepciones Personalizadas (Checked)

Se definieron excepciones que fuerzan al programador a manejar fallos críticos en tiempo de compilación:

* **`ReservaInvalidaException`**: Se lanza si los datos de la reserva no cumplen con las reglas de negocio (ej. precios <= 0).
* **`DisponibilidadException`**: Se lanza si no hay recursos (cupo, asientos) disponibles para la fecha solicitada.
* **`PagoRechazadoException`**: Se lanza si el intento de pago no es exitoso (ej. monto insuficiente).

### 2. Validaciones Integradas

Los métodos críticos en el paquete `com.servicio.servicio` (como `GestorReservas.agregarReserva` y `GestorReservas.procesarPago`) utilizan bloques **`try-catch`** para manejar las excepciones y **`throws`** para delegar su manejo al código de más alto nivel (`Main`).

### 3. Excepciones No Chequeadas (Unchecked)

Se utilizan excepciones de Java (`IllegalArgumentException`, `NullPointerException`) para validar errores de programación o datos de entrada básicos, mientras que las excepciones personalizadas manejan la lógica de negocio.

## 🔗 Enlaces Importantes

* [**Main.java**](com/servicio/Main.java): Clase principal que demuestra la captura de las tres excepciones personalizadas en diferentes casos de prueba.
* [**GestorReservas.java**](com/servicio/servicio/GestorReservas.java): Archivo donde se implementa la lógica de `throws` para las excepciones de negocio.