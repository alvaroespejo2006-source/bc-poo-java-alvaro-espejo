package implementaciones;

import abstractas.ServicioTuristico;
// Opcional: Implementación de la Interfaz Reservable (Asumimos que la Interfaz Reservable está en interfaces/)
import interfaces.Reservable; 

public class Vuelo extends ServicioTuristico implements Reservable { 
    
    private String origen;
    private String destino;
    private int numeroEscalas;
    private String codigoReserva;
    private static final double IMPUESTO_BASE = 0.19; // 19% IVA/Impuesto

    public Vuelo(String nombre, double precioBase, String aerolinea,
                 String origen, String destino, int numeroEscalas) {
        super(nombre, precioBase, aerolinea); // Llama al constructor padre
        this.origen = origen;
        this.destino = destino;
        this.numeroEscalas = numeroEscalas;
    }

    /**
     * @Override: Calcula el costo total específico para un Vuelo
     * (Precio Base + Impuestos + Cargo por Escalas).
     */
    @Override
    public double calcularCostoTotal() {
        double impuestos = precioBase * IMPUESTO_BASE;
        double cargoEscalas = numeroEscalas * 100000; // 100,000 por escala
        return precioBase + impuestos + cargoEscalas;
    }

    /**
     * @Override: Ofrece una descripción detallada del Vuelo.
     */
    @Override
    public String obtenerDescripcionDetallada() {
        return "Tipo: Vuelo | Ruta: " + origen + " -> " + destino +
               " | Escalas: " + numeroEscalas;
    }
    
    // --- Métodos de la Interfaz Reservable ---
    @Override
    public String verificarDisponibilidad(String fecha) {
        return "Vuelo disponible para la fecha " + fecha + ".";
    }

    @Override
    public void realizarReserva(String clienteId, String fecha) {
        this.codigoReserva = "VLO-" + clienteId.substring(0, 3) + "-" + System.currentTimeMillis() % 1000;
        System.out.println("Reserva de vuelo exitosa.");
    }

    @Override
    public String obtenerCodigoReserva() {
        return this.codigoReserva;
    }
}