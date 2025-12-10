package com.servicio.servicio;

import com.servicio.modelo.Vuelo;
import com.servicio.excepciones.DisponibilidadException;

import java.util.ArrayList;

public class GestorVuelos {
    
    private ArrayList<Vuelo> vuelos = new ArrayList<>();
    
    public void agregarVuelo(Vuelo vuelo) {
        if (vuelo == null) {
            throw new NullPointerException("El vuelo a agregar no puede ser nulo.");
        }
        vuelos.add(vuelo);
    }
    
    public Vuelo buscarYReservar(String codigoVuelo) throws DisponibilidadException {
        Vuelo vuelo = vuelos.stream()
            .filter(v -> v.obtenerCodigoReserva().equals(codigoVuelo))
            .findFirst()
            .orElse(null);
            
        if (vuelo == null) {
            throw new IllegalArgumentException("Vuelo con código " + codigoVuelo + " no encontrado.");
        }
        
        if (vuelo.verificarDisponibilidad("hoy").equals("No Disponible")) {
             throw new DisponibilidadException("El vuelo " + vuelo.obtenerCodigoReserva() + " está sobrevendido.");
        }
        
        return vuelo;
    }
}