public class EmpleadoContrato extends Empleado {
    private int mesesContrato;

    public EmpleadoContrato(String nombre, String identificacion, double salarioBase, int mesesContrato) {
        super(nombre, identificacion, salarioBase);
        this.mesesContrato = mesesContrato;
    }

    @Override
    public double calcularSalario() {
        return salarioBase;  // Sin bono
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: Contrato");
        System.out.println("Meses de contrato: " + mesesContrato);
    }
}