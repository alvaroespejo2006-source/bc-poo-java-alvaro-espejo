package implementaciones;

import abstractas.ServicioTuristico;
import interfaces.Reservable;
import interfaces.Calificable;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa la clase abstracta ServicioTuristico
 * e implementa MÚLTIPLES interfaces (Reservable y Calificable).
 */
public class PaqueteTuristico extends ServicioTuristico implements Reservable, Calificable { 

    private int duracionDias;
    private String codigoReserva;
    private List<Integer> calificaciones;
    private static final double FEE_AGENCIA = 0.05; // 5% de cargo de agencia

    public PaqueteTuristico(String nombre, double precioBase, String proveedor, int duracionDias) {
        super(nombre, precioBase, proveedor);
        this.duracionDias = duracionDias;
        this.calificaciones = new ArrayList<>();
    }

    // --- Implementación de Métodos Abstractos (ServicioTuristico) ---

    /**
     * @Override: Calcula el costo total del paquete (Precio Base + Fee de Agencia).
     */
    @Override
    public double calcularCostoTotal() {
        return precioBase * (1 + FEE_AGENCIA);
    }

    /**
     * @Override: Ofrece una descripción detallada del Paquete.
     */
    @Override
    public String obtenerDescripcionDetallada() {
        return "Tipo: Paquete Todo Incluido | Duración: " + duracionDias + " días | Destino: " + nombre;
    }

    // --- Implementación de Métodos de la Interfaz Reservable ---

    @Override
    public String verificarDisponibilidad(String fecha) {
        return "Paquete con disponibilidad confirmada para " + fecha + ".";
    }

    @Override
    public void realizarReserva(String clienteId, String fecha) {
        // Lógica de reserva y generación de código
        this.codigoReserva = "PAQ-" + clienteId.substring(0, 3) + "-" + System.currentTimeMillis() % 10000;
        System.out.println("Reserva de paquete realizada para cliente " + clienteId + ".");
    }

    @Override
    public String obtenerCodigoReserva() {
        return this.codigoReserva;
    }

    // --- Implementación de Métodos de la Interfaz Calificable ---

    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        if (estrellas >= 1 && estrellas <= 5) {
            calificaciones.add(estrellas);
            System.out.println(" -> Calificación de " + estrellas + " estrellas registrada.");
        }
    }

    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;
        double suma = calificaciones.stream().mapToInt(Integer::intValue).sum();
        return suma / calificaciones.size();
    }
}