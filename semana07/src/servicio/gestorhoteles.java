package com.servicio.servicio;

import com.servicio.modelo.Hotel;
import com.servicio.excepciones.DisponibilidadException;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestorHoteles {
    
    private ArrayList<Hotel> hoteles = new ArrayList<>();
    
    public void agregarHotel(Hotel hotel) {
        hoteles.add(hotel);
    }
    
    public Hotel buscarYConfirmar(String nombreHotel, LocalDate fecha) throws DisponibilidadException {
        Hotel hotel = hoteles.stream()
            .filter(h -> h.getNombre().equalsIgnoreCase(nombreHotel))
            .findFirst()
            .orElse(null);
            
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel con nombre " + nombreHotel + " no registrado.");
        }
        
        // Simulación: Si es un fin de semana, asumimos que está lleno
        if (fecha.getDayOfWeek().getValue() >= 6) { 
             throw new DisponibilidadException("El hotel " + nombreHotel + " está lleno para el fin de semana del " + fecha);
        }
        
        return hotel;
    }
}