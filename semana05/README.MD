# 🚀 Semana 05: Polimorfismo en Agencia de Viajes

Este proyecto es una mejora del sistema de gestión de empleados y reservas de una Agencia de Viajes, enfocado en la aplicación práctica de los principios de **Polimorfismo** mediante la Sobrecarga y la Sobrescritura de métodos en Java.

## 🎯 Objetivo de la Semana

Implementar y demostrar:
1.  **Sobrecarga (Overloading)** de métodos en la clase de gestión.
2.  **Sobrescritura (Overriding)** de métodos clave (`calcularSalario`, `obtenerDescripcion`) en las subclases de empleados.
3.  **Polimorfismo Dinámico** a través de colecciones de tipo padre (`ArrayList<Empleado>`).

## 📁 Estructura del Proyecto

El proyecto está organizado en las siguientes clases:

| Clase | Tipo | Propósito |
| :--- | :--- | :--- |
| `Empleado` | Clase Padre | Define la estructura base y métodos genéricos. |
| `EmpleadoPlanta` | Subclase | Extiende `Empleado`. Sobrescribe métodos para aplicar bono por antigüedad. |
| `EmpleadoContrato` | Subclase | Extiende `Empleado`. Sobrescribe métodos para incluir fecha de fin de contrato. |
| `AgenciaViajes` | Clase de Gestión | Contiene la lógica de negocio, implementa **Sobrecarga** (para `buscarReserva`) y **Métodos Polimórficos** (para `procesarNomina`). |
| `Main` | Ejecución | Demuestra la creación de objetos polimórficos, el uso de colecciones polimórficas y el *dynamic binding*. |

## 1. Demostración de Polimorfismo (Dynamic Binding)

La clase `Main` instancia diferentes tipos de empleados y los gestiona a través de la referencia de la clase padre (`Empleado`), lo que prueba el Polimorfismo Dinámico.

```java
// Ejemplo de uso polimórfico en Main.java
ArrayList<Empleado> personal = new ArrayList<>();
personal.add(new EmpleadoPlanta(...));
personal.add(new EmpleadoContrato(...));

for (Empleado e : personal) {
    // La JVM decide en runtime si ejecuta la lógica con bono (Planta) o sin bono (Contrato)
    System.out.println(e.obtenerDescripcion());
    System.out.println("Salario: $" + e.calcularSalario());
}