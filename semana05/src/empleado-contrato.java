import java.time.LocalDate;

public class EmpleadoContrato extends Empleado {
    private LocalDate fechaFinContrato;

    public EmpleadoContrato(String nombre, String identificacion,
                            double salarioBase, LocalDate fechaFinContrato) {
        super(nombre, identificacion, salarioBase);
        this.fechaFinContrato = fechaFinContrato;
    }

    /**
     * Ejercicio 2: Sobrescritura (Overriding)
     * Sobrescribe el método. En este caso, solo devuelve el salario base
     * (sin bonificaciones extra por ser contrato temporal).
     */
    @Override
    public double calcularSalario() {
        return salarioBase;
    }

    /**
     * Ejercicio 2: Sobrescritura (Overriding)
     * Sobrescribe el método para incluir la fecha de fin de contrato.
     */
    @Override
    public String obtenerDescripcion() {
        return "Empleado por Contrato: " + nombre + " (" + identificacion +
               ") - Fin: " + fechaFinContrato;
    }

    // Getter
    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }
}