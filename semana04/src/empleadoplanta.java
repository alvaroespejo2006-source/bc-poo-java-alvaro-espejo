public class EmpleadoPlanta extends Empleado {
    private int anosAntiguedad;

    public EmpleadoPlanta(String nombre, String identificacion, double salarioBase, int anosAntiguedad) {
        super(nombre, identificacion, salarioBase);
        this.anosAntiguedad = anosAntiguedad;
    }

    @Override
    public double calcularSalario() {
        double bono = salarioBase * 0.05 * anosAntiguedad;
        return salarioBase + bono;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: Planta");
        System.out.println("Años de antigüedad: " + anosAntiguedad);
    }
}