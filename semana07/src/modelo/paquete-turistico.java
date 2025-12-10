package com.servicio.modelo;

public final class PaqueteTuristico extends ServicioTuristico implements Reservable, Calificable { 

    private int duracionDias;
    
    public PaqueteTuristico(String nombre, double precioBase, String proveedor, int duracionDias) {
        super(nombre, precioBase, proveedor);
        this.duracionDias = duracionDias;
    }

    @Override
    public double calcularCostoTotal() {
        // Aplica un pequeño recargo del 5% al precio base del paquete
        return precioBase * 1.05; 
    }

    @Override
    public String obtenerDescripcionDetallada() {
        return "Tipo: Paquete Todo Incluido | Duración: " + duracionDias + " días";
    }
    
    // Implementación de Reservable
    @Override
    public String verificarDisponibilidad(String fecha) { return "Disponible"; }
    
    @Override
    public void realizarReserva(String clienteId, String fecha) { 
        // Lógica de reserva para paquetes
    }
    
    @Override
    public String obtenerCodigoReserva() { return "PAQ-456"; }

    // Implementación de Calificable
    @Override
    public void agregarCalificacion(int estrellas, String comentario) { 
        // Lógica para agregar calificación al paquete
    }
    
    @Override
    public double obtenerPromedioCalificaciones() { 
        // Simulación o cálculo real del promedio
        return 4.5; 
    }
}