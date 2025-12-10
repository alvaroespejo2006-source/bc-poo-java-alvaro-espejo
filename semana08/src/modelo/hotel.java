package com.agencia.modelo;

import java.util.ArrayList;
import java.util.List;

public final class Hotel extends ServicioTuristico implements Calificable { 
    private String ciudad;
    private int numeroNoches;

    public Hotel(String nombre, double precioPorNoche, String cadena,
                 String ciudad, int numeroNoches) {
        super(nombre, precioPorNoche, cadena); 
        this.ciudad = ciudad;
        this.numeroNoches = numeroNoches;
    }

    @Override
    public double calcularCostoTotal() {
        return precioBase * numeroNoches * 1.19;
    }

    @Override
    public String obtenerDescripcionDetallada() {
        return "Tipo: Alojamiento | Ubicación: " + ciudad;
    }
    
    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        if (estrellas < 1 || estrellas > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5 estrellas."); 
        }
        // ... Lógica de agregar
    }
    @Override
    public double obtenerPromedioCalificaciones() { return 4.5; }
}