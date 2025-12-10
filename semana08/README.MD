# ✈️ Sistema de Gestión de Agencia de Viajes (POO en Java)

Este repositorio contiene la implementación incremental de un sistema de gestión para una Agencia de Viajes, aplicando conceptos de Programación Orientada a Objetos (POO) en Java.

---

## 🚀 Progreso del Proyecto

| Semana | Concepto Principal Aplicado | Foco del Dominio |
| :--- | :--- | :--- |
| **06** | Abstracción e Interfaces | Clases Abstractas e Interfaces. |
| **07** | Paquetes y Excepciones | Reorganización en paquetes (`com.servicio.*`) y manejo de errores de negocio. |
| **08** | **Colecciones Avanzadas y Generics** | **Mejora de la eficiencia** del sistema de gestión utilizando estructuras de datos avanzadas (`HashMap`). |

---

## 💡 Foco de la Semana 08: Eficiencia y Estructuras de Datos

El objetivo principal fue migrar las clases de servicio para utilizar estructuras de datos más eficientes, priorizando la velocidad de búsqueda y el rendimiento del sistema.

### 1. Migración a `HashMap`

En las clases de gestión (`GestorReservas`, `GestorVuelos`, `GestorHoteles`), se reemplazó el uso de la lista lineal (`ArrayList`) por la colección de tipo **Mapa (`HashMap`)**.

* **Antes (`Semana 07`):** Se usaba `ArrayList` (búsqueda lenta: O(n)).
* **Ahora (`Semana 08`):** Se usa **`HashMap<String, T>`** (búsqueda casi instantánea: O(1)).

### 2. Clave Única para Búsqueda Instantánea

Cada gestor almacena ahora sus entidades indexadas por una clave única:

| Gestor | Clave de Almacenamiento | Propósito |
| :--- | :--- | :--- |
| **`GestorReservas`** | Código de Reserva (`MAD101`) | Permite encontrar una reserva sin recorrer toda la colección. |
| **`GestorVuelos`** | Código del Vuelo (`VY007`) | Permite validar rápidamente la existencia de un vuelo. |
| **`GestorHoteles`** | Nombre del Hotel (`The Weekend Inn`) | Permite obtener la entidad Hotel directamente. |

---

## 📦 Estructura de Paquetes (Semana 08)

La estructura de paquetes se mantiene desde la Semana 07, pero la lógica interna se ha optimizado:

src/ └── com/ └── servicio/ ├── excepciones/ <-- Sin cambios. ├── modelo/ <-- Sin cambios. ├── servicio/ <-- MODIFICADO: Uso de HashMap en los Gestores. └── Main.java <-- AJUSTADO: Demuestra la búsqueda rápida.


## 🔗 Enlaces Importantes

* [**GestorReservas.java**](com/servicio/servicio/GestorReservas.java): Muestra el uso de `HashMap<String, Reserva>` y la lógica de conteo de cupos optimizada.
* [**Main.java**](com/servicio/Main.java): Demuestra la integración del sistema, ahora con la validación de excepciones y la búsqueda eficiente.

---