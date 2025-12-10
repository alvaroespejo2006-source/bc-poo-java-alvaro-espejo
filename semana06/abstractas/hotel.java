package implementaciones;

import abstractas.ServicioTuristico;
import interfaces.Calificable;
import java.util.ArrayList;
import java.util.List;

public class Hotel extends ServicioTuristico implements Calificable { 
    
    private String ciudad;
    private int numeroNoches;
    private List<Integer> calificaciones;
    private static final double IVA_HOTEL = 0.19;

    public Hotel(String nombre, double precioPorNoche, String cadena,
                 String ciudad, int numeroNoches) {
        super(nombre, precioPorNoche, cadena); // precioBase es el precioPorNoche
        this.ciudad = ciudad;
        this.numeroNoches = numeroNoches;
        this.calificaciones = new ArrayList<>();
    }

    /**
     * @Override: Calcula el costo total específico para un Hotel
     * (Precio por Noche * Número de Noches + IVA).
     */
    @Override
    public double calcularCostoTotal() {
        double subtotal = precioBase * numeroNoches;
        double iva = subtotal * IVA_HOTEL;
        return subtotal + iva;
    }

    /**
     * @Override: Ofrece una descripción detallada del Hotel.
     */
    @Override
    public String obtenerDescripcionDetallada() {
        return "Tipo: Alojamiento | Ubicación: " + ciudad + 
               " | Duración: " + numeroNoches + " noche(s)";
    }
    
    // --- Métodos de la Interfaz Calificable ---
    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        if (estrellas >= 1 && estrellas <= 5) {
            calificaciones.add(estrellas);
        }
    }

    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;
        double suma = calificaciones.stream().mapToInt(Integer::intValue).sum();
        return suma / calificaciones.size();
    }
}