public class EmpleadoPlanta extends Empleado {
    private int antiguedad; // Años de servicio
    private static final double BONO_ANUAL = 0.05; // 5% de bono por año

    public EmpleadoPlanta(String nombre, String identificacion,
                          double salarioBase, int antiguedad) {
        super(nombre, identificacion, salarioBase);
        this.antiguedad = antiguedad;
    }

    /**
     * Ejercicio 2: Sobrescritura (Overriding)
     * Sobrescribe el método para incluir un bono por antigüedad.
     */
    @Override
    public double calcularSalario() {
        // Bono: 5% del salario base por cada año de antigüedad
        double bono = salarioBase * (antiguedad * BONO_ANUAL);
        return salarioBase + bono;
    }

    /**
     * Ejercicio 2: Sobrescritura (Overriding)
     * Sobrescribe el método para incluir la antigüedad en la descripción.
     */
    @Override
    public String obtenerDescripcion() {
        return "Empleado de Planta: " + nombre + " (" + identificacion + 
               ") - Antigüedad: " + antiguedad + " años";
    }

    // Getter
    public int getAntiguedad() {
        return antiguedad;
    }
}