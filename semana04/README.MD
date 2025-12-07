# 📘 Semana 04 – Sistema de Empleados (Herencia y Polimorfismo)

Este proyecto corresponde a la **Semana 04** y desarrolla un sistema básico de empleados usando **herencia**, **polimorfismo** y **sobrescritura de métodos** en Java. Se implementan distintos tipos de empleados: de planta y por contrato.

---

## 🏗️ Estructura del Proyecto

Empleado.java
EmpleadoPlanta.java
EmpleadoContrato.java
Main.java

---

## 👥 Jerarquía de Clases

Empleado
├── EmpleadoPlanta
└── EmpleadoContrato

---

## 📄 Descripción de las Clases

### ✔ Empleado (Clase Padre)
Contiene atributos y métodos comunes:

- `nombre` (String): nombre completo del empleado  
- `identificacion` (String): documento o código único del empleado  
- `salarioBase` (double): salario base mensual  

Métodos:
- `mostrarInfo()`: muestra información básica del empleado  
- `calcularSalario()`: retorna el salario base (puede ser sobrescrito)  

---

### ✔ EmpleadoPlanta
Empleado de planta con **bono por antigüedad**.

Atributo adicional:
- `anosAntiguedad` (int): años que lleva trabajando en la empresa  

Métodos sobrescritos:
- `calcularSalario()` → incluye bono del 5% por cada año de antigüedad  
- `mostrarInfo()` → muestra tipo de empleado y años de antigüedad  

---

### ✔ EmpleadoContrato
Empleado contratado por meses.

Atributo adicional:
- `mesesContrato` (int): duración del contrato en meses  

Métodos sobrescritos:
- `calcularSalario()` → devuelve solo el salario base  
- `mostrarInfo()` → muestra tipo de empleado y meses de contrato  

---

a
