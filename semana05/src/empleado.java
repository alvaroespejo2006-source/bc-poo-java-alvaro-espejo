public class Empleado {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;

    // Constructor
    public Empleado(String nombre, String identificacion, double salarioBase) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }

    // Método base para ser sobrescrito
    public double calcularSalario() {
        return salarioBase;
    }

    // Método base para ser sobrescrito
    public String obtenerDescripcion() {
        return "Empleado: " + nombre + " (" + identificacion + ")";
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    
    public double getSalarioBase() {
        return salarioBase;
    }
}