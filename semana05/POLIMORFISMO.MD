# 🧬 Principios de Polimorfismo Aplicados

Este documento describe cómo se implementó el polimorfismo (sobrecarga y sobrescritura) en las clases de Empleado de la Agencia de Viajes.

---

## 1. Sobrecarga (Overloading)

La sobrecarga se implementó en la clase de gestión central, `AgenciaViajes`, para proporcionar múltiples formas de realizar una búsqueda utilizando un único nombre de método, lo que mejora la usabilidad y la claridad de la interfaz.

* **Clase Aplicada:** `AgenciaViajes`

* **Métodos Sobrecargados:**

    ```java
    // 1. Buscar por código único de reserva (String)
    public Reserva buscarReserva(String codigo) 
    
    // 2. Buscar por el objeto Cliente asociado (Cliente)
    public ArrayList<Reserva> buscarReserva(Cliente cliente)
    
    // 3. Buscar por un rango de fechas (LocalDate, LocalDate)
    public ArrayList<Reserva> buscarReserva(LocalDate inicio, LocalDate fin) 
    ```

* **Justificación:**
    Es fundamental que el sistema de la agencia permita la recuperación de reservas utilizando **diferentes criterios** (identificador único, cliente, o periodo de tiempo). La sobrecarga permite que todas estas operaciones se agrupen lógicamente bajo el mismo nombre (`buscarReserva`), simplificando la interfaz para el desarrollador.

---

## 2. Sobrescritura (Overriding)

La sobrescritura se utiliza para que las subclases (`EmpleadoPlanta` y `EmpleadoContrato`) proporcionen implementaciones específicas de los métodos definidos en la clase padre (`Empleado`), asegurando que cada tipo de empleado tenga su propia lógica de cálculo salarial y descripción.

* **Clases Aplicadas:** `EmpleadoPlanta` y `EmpleadoContrato`

* **Métodos Sobrescritos con `@Override`:**

    | Método | Clase Padre (`Empleado`) | Subclase 1 (`EmpleadoPlanta`) | Subclase 2 (`EmpleadoContrato`) |
    | :--- | :--- | :--- | :--- |
    | `calcularSalario()` | `return salarioBase` | `return salarioBase + bono` (5% por año de antigüedad) | `return salarioBase` (Solo salario base) |
    | `obtenerDescripcion()` | Retorna nombre e identificación | Retorna nombre, identificación **y años de antigüedad** | Retorna nombre, identificación **y fecha de fin de contrato** |

---

## 3. Polimorfismo Dinámico (Dynamic Binding)

El polimorfismo dinámico es la capacidad de que la máquina virtual de Java (JVM) determine en tiempo de ejecución (runtime) qué implementación de un método sobrescrito debe ejecutarse, basándose en el **tipo real** del objeto, no en el tipo de su referencia.

* **Ejemplo de Código Demostrado:**

    ```java
    ArrayList<Empleado> personal = new ArrayList<>();
    personal.add(new EmpleadoPlanta(...));    // Tipo real: EmpleadoPlanta
    personal.add(new EmpleadoContrato(...)); // Tipo real: EmpleadoContrato

    for (Empleado e : personal) {
        // Aunque 'e' es de tipo Empleado, la JVM llama a la versión correcta.
        // Si es Planta, llama al calcularSalario con bono.
        // Si es Contrato, llama al calcularSalario simple.
        System.out.println("Salario: $" + e.calcularSalario()); 
    }
    ```

* **Explicación:**
    La clase `AgenciaViajes` utiliza un **ArrayList polimórfico** (`ArrayList<Empleado>`) que almacena objetos de diferentes subclases. Al iterar y llamar a `e.calcularSalario()`, el método concreto que se ejecuta no se conoce en tiempo de compilación. El *dynamic binding* asegura que, para cada elemento de la colección, se ejecute la lógica de salario definida en su clase específica (`EmpleadoPlanta` o `EmpleadoContrato`).

---

## 4. Beneficios del Polimorfismo

| Beneficio | Descripción |
| :--- | :--- |
| **Extensibilidad** | Permite añadir nuevos tipos de empleados (ej. `EmpleadoFreelance`) simplemente creando una nueva subclase y sobrescribiendo los métodos. El código de gestión de nómina (`procesarNominaCompleta`) no necesita ser modificado. |
| **Código Limpio** | Se evita el uso de múltiples sentencias `if`/`else if` o `switch` para determinar el tipo de objeto y ejecutar la lógica correcta. Se utiliza una única interfaz (`Empleado`) para trabajar con múltiples implementaciones. |
| **Mantenibilidad** | Los cambios en la lógica de cálculo salarial de un tipo de empleado (ej. aumentar el bono de `EmpleadoPlanta`) se encapsulan solo en esa subclase, sin afectar otras clases de empleados o el sistema de nómina principal. |

| ¿Qué sería difícil sin polimorfismo? |
| :--- |
| La clase `AgenciaViajes` se volvería muy rígida y tendría que conocer y manejar explícitamente cada subclase de empleado, obligándonos a escribir métodos específicos para cada una o a usar lógica de verificación de tipos (`instanceof`), lo cual va en contra del diseño orientado a objetos. |