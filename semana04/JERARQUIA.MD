# Jerarquía de Clases - Semana 04

## Diagrama

    Empleado
       |
   +---+-----------------+
   |                     |
EmpleadoPlanta     EmpleadoContrato

## Justificación

Elegí esta jerarquía porque en una agencia de viajes existen empleados que comparten muchos datos y comportamientos básicos (nombre, identificación, salario base, mostrar información), pero existen diferencias importantes según el tipo de contratación:

- **EmpleadoPlanta** representa trabajadores de planta, quienes reciben un bono adicional por cada año de antigüedad.
- **EmpleadoContrato** representa trabajadores contratados por meses, que no reciben bonos pero sí están diferenciados por la duración del contrato.

Esta estructura permite reutilizar atributos y métodos comunes en la clase padre `Empleado` y especializar comportamientos en las subclases usando herencia y sobrescritura de métodos. Además, facilita la implementación de polimorfismo para gestionar empleados de distintos tipos de manera uniforme en el sistema.

## Atributos Heredados

- `nombre` (String): nombre completo del empleado.
- `identificacion` (String): documento o código único del empleado.
- `salarioBase` (double): salario base mensual.

## Métodos Sobrescritos

- **calcularSalario()**
    - En `EmpleadoPlanta`: calcula salario base + bono por años de antigüedad.
    - En `EmpleadoContrato`: devuelve solo el salario base.
- **mostrarInfo()**
    - Ambas subclases amplían la visualización: muestran tipo de contrato y su dato adicional (años o meses).