package com.agencia.modelo;

public final class Vuelo extends ServicioTuristico implements Reservable { 
    private String origen;
    private String destino;
    
    public Vuelo(String nombre, double precioBase, String aerolinea,
                 String origen, String destino) {
        super(nombre, precioBase, aerolinea);
        this.origen = origen;
        this.destino = destino;
    }

    @Override
    public double calcularCostoTotal() {
        return precioBase * 1.19;
    }

    @Override
    public String obtenerDescripcionDetallada() {
        return "Tipo: Vuelo | Ruta: " + origen + " -> " + destino;
    }
    
    @Override
    public String verificarDisponibilidad(String fecha) { return "Disponible"; }
    @Override
    public void realizarReserva(String clienteId, String fecha) { /* Lógica */ }
    @Override
    public String obtenerCodigoReserva() { return "VLO-123"; }
}