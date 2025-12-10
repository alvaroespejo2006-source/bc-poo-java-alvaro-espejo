import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Crear la Agencia de Viajes (Sistema)
        AgenciaViajes agencia = new AgenciaViajes();

        // 2. Crear empleados de diferentes tipos
        EmpleadoPlanta emp1 = new EmpleadoPlanta(
            "Sofía Ramírez", "EP001", 3500000, 7 // 7 años de antigüedad
        );

        EmpleadoContrato emp2 = new EmpleadoContrato(
            "Roberto Guzmán", "EC002", 2800000,
            LocalDate.of(2025, 6, 30) // Fin de contrato
        );

        EmpleadoPlanta emp3 = new EmpleadoPlanta(
            "Laura Montes", "EP003", 4000000, 15 // 15 años de antigüedad
        );

        // 3. Agregar empleados (Ejercicio 3: Método polimórfico)
        System.out.println("=== 👥 REGISTRO DE EMPLEADOS ===");
        agencia.agregarEmpleado(emp1);
        agencia.agregarEmpleado(emp2);
        agencia.agregarEmpleado(emp3);

        // 4. Procesar nómina completa (Ejercicio 3 y 4: Dynamic binding en acción)
        agencia.procesarNominaCompleta();

        // 5. Demostración de ArrayList polimórfico (Ejercicio 4)
        ArrayList<Empleado> personal = new ArrayList<>();
        personal.add(emp1);
        personal.add(emp2);
        personal.add(emp3);
        
        System.out.println("\n=== 🔄 DEMOSTRACIÓN POLIMORFISMO Y DYNAMIC BINDING ===");
        for (Empleado e : personal) {
            // Se llama al método obtenerDescripcion() específico de la clase real (Planta o Contrato)
            System.out.println(e.obtenerDescripcion()); // Dynamic binding
            // Se llama al método calcularSalario() específico (con o sin bono)
            System.out.println("Salario Calculado: $" + e.calcularSalario()); // Dynamic binding
            System.out.println("Tipo de objeto real: " + e.getClass().getSimpleName());
            System.out.println("---");
        }
        
        // 6. Demostración de Sobrecarga (Ejercicio 1)
        System.out.println("\n=== 🛠️ DEMOSTRACIÓN SOBRECARGA (OVERLOADING) ===");
        
        Cliente cDemo = new Cliente("Ana Pérez", "C001");
        LocalDate hoy = LocalDate.now();
        LocalDate proxMes = hoy.plusMonths(1);

        // Llamada 1: Sobrecarga por String (código)
        Reserva r1 = agencia.buscarReserva("R002");
        System.out.println("Resultado búsqueda por Código: " + (r1 != null ? r1 : "No encontrada"));

        // Llamada 2: Sobrecarga por Cliente
        ArrayList<Reserva> r2 = agencia.buscarReserva(cDemo);
        System.out.println("Resultado búsqueda por Cliente: " + r2);

        // Llamada 3: Sobrecarga por dos LocalDates (rango)
        ArrayList<Reserva> r3 = agencia.buscarReserva(hoy.minusDays(5), hoy.plusDays(30)); 
        System.out.println("Resultado búsqueda por Rango de Fechas: " + r3);
    }
}