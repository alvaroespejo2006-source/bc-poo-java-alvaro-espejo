package com.servicio.servicio;

import com.servicio.modelo.Vuelo;
import com.servicio.excepciones.DisponibilidadException;

import java.util.HashMap;
import java.util.Map;

public class GestorVuelos {
    
    // Uso de HashMap para almacenamiento eficiente: Clave (Código de Reserva) -> Valor (Objeto Vuelo)
    private Map<String, Vuelo> vuelos = new HashMap<>();
    
    public void agregarVuelo(Vuelo vuelo) {
        if (vuelo == null) {
            throw new NullPointerException("El vuelo a agregar no puede ser nulo.");
        }
        vuelos.put(vuelo.obtenerCodigoReserva(), vuelo); // Usar el código como clave
    }
    
    public Vuelo buscarYReservar(String codigoVuelo) throws DisponibilidadException {
        // Búsqueda directa O(1)
        Vuelo vuelo = vuelos.get(codigoVuelo);
            
        if (vuelo == null) {
            throw new IllegalArgumentException("Vuelo con código " + codigoVuelo + " no encontrado.");
        }
        
        if (vuelo.verificarDisponibilidad("hoy").equals("No Disponible")) {
             throw new DisponibilidadException("El vuelo " + vuelo.obtenerCodigoReserva() + " está sobrevendido.");
        }
        
        return vuelo;
    }
}