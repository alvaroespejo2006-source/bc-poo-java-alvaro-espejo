public class Empleado {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;

    public Empleado(String nombre, String identificacion, double salarioBase) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salarioBase = salarioBase;
    }

    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("ID: " + identificacion);
    }

    public double calcularSalario() {
        return salarioBase;
    }
}