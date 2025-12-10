package com.servicio.servicio;

import com.servicio.modelo.Hotel;
import com.servicio.excepciones.DisponibilidadException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class GestorHoteles {
    
    // Uso de HashMap para almacenamiento eficiente: Clave (Nombre del Hotel) -> Valor (Objeto Hotel)
    private Map<String, Hotel> hoteles = new HashMap<>();
    
    public void agregarHotel(Hotel hotel) {
        hoteles.put(hotel.getNombre(), hotel); // Usar el nombre como clave
    }
    
    public Hotel buscarYConfirmar(String nombreHotel, LocalDate fecha) throws DisponibilidadException {
        // Búsqueda directa O(1)
        Hotel hotel = hoteles.get(nombreHotel);
            
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel con nombre " + nombreHotel + " no registrado.");
        }
        
        if (fecha.getDayOfWeek().getValue() >= 6) { 
             throw new DisponibilidadException("El hotel " + nombreHotel + " está lleno para el fin de semana del " + fecha);
        }
        
        return hotel;
    }
}