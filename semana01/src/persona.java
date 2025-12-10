public class persona {
    public class AsesorDeViajes {

    // Atributos
    String nombre;
    String idEmpleado;
    String especialidad;
    int aniosExperiencia;
    int numeroReservasAtendidas;

    // Constructor
    public AsesorDeViajes(String nombre, String idEmpleado, String especialidad,
                          int aniosExperiencia, int numeroReservasAtendidas) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.numeroReservasAtendidas = numeroReservasAtendidas;
    }

    // Métodos

    public void atenderCliente() {
        System.out.println(nombre + " está atendiendo a un cliente...");
    }

    public void registrarReserva() {
        numeroReservasAtendidas++;
        System.out.println("Reserva registrada por " + nombre + ". Total reservas atendidas: " + numeroReservasAtendidas);
    }

    public void recomendarPaquete() {
        System.out.println(nombre + " recomienda un paquete turístico según su especialidad: " + especialidad);
    }

    public void generarReporte() {
        System.out.println("=== Reporte del Asesor ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID Empleado: " + idEmpleado);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Años de Experiencia: " + aniosExperiencia);
        System.out.println("Reservas Atendidas: " + numeroReservasAtendidas);
        System.out.println("==========================");
    }
}
}