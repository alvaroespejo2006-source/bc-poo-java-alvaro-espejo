package implementaciones;

import abstractas.ServicioTuristico;

// Asumimos que el Tour no implementa Reservable ni Calificable para variar.
public class Tour extends ServicioTuristico { 
    
    private String destinoPrincipal;
    private int duracionHoras;
    private int numeroPersonas;

    public Tour(String nombre, double precioPorPersona, String operador,
                 String destinoPrincipal, int duracionHoras, int numeroPersonas) {
        super(nombre, precioPorPersona, operador); // precioBase es precioPorPersona
        this.destinoPrincipal = destinoPrincipal;
        this.duracionHoras = duracionHoras;
        this.numeroPersonas = numeroPersonas;
    }

    /**
     * @Override: Calcula el costo total específico para un Tour
     * (Precio por Persona * Número de Personas).
     */
    @Override
    public double calcularCostoTotal() {
        return precioBase * numeroPersonas;
    }

    /**
     * @Override: Ofrece una descripción detallada del Tour.
     */
    @Override
    public String obtenerDescripcionDetallada() {
        return "Tipo: Excursión | Destino: " + destinoPrincipal + 
               " | Duración: " + duracionHoras + " horas | Participantes: " + numeroPersonas;
    }
}