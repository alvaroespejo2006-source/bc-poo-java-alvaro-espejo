package com.servicio.servicio;

import com.servicio.modelo.Reserva;
import com.servicio.modelo.Cliente;
import com.servicio.excepciones.ReservaInvalidaException;
import com.servicio.excepciones.DisponibilidadException;
import com.servicio.excepciones.PagoRechazadoException;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestorReservas {
    
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private static final int CUPO_MAXIMO_DIARIO = 5; 

    /**
     * Intenta agregar una nueva reserva, validando datos y disponibilidad.
     * @throws ReservaInvalidaException Si los datos de entrada son incorrectos.
     * @throws DisponibilidadException Si no hay cupo en la fecha solicitada.
     */
    public void agregarReserva(String codigo, Cliente cliente, LocalDate fecha, double precio)
            throws ReservaInvalidaException, DisponibilidadException {
        
        if (cliente == null) {
            throw new NullPointerException("El objeto Cliente no puede ser nulo.");
        }
        
        if (precio <= 0) {
            throw new ReservaInvalidaException("El precio de la reserva debe ser estrictamente positivo.");
        }
        if (!codigo.matches("[A-Z]{3}\\d{3}")) {
            throw new ReservaInvalidaException("El código debe tener formato AAA### (ejemplo: BOG101).");
        }
        
        long reservasEnFecha = reservas.stream()
                .filter(r -> r.getFecha().isEqual(fecha))
                .count();
                
        if (reservasEnFecha >= CUPO_MAXIMO_DIARIO) {
            throw new DisponibilidadException(
                "No hay cupo disponible (" + CUPO_MAXIMO_DIARIO + " máximo) para la fecha: " + fecha
            );
        }
        
        Reserva nueva = new Reserva(codigo, cliente, fecha, precio);
        reservas.add(nueva);
        System.out.println("✅ Reserva " + codigo + " agregada exitosamente para " + cliente.getNombre());
    }
    
    /**
     * Simula el procesamiento de un pago para una reserva.
     * @throws PagoRechazadoException Si el pago falla por fondos o sistema.
     */
    public void procesarPago(Reserva reserva, double monto) throws PagoRechazadoException {
        
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del pago debe ser positivo.");
        }
        
        System.out.println("Procesando pago de $" + String.format("%,.0f", monto) + " para reserva " + reserva.getCodigo() + "...");
        
        if (monto < reserva.getPrecio() / 2) {
            throw new PagoRechazadoException(
                "Monto insuficiente. Se requiere un pago mínimo del 50% ($" + 
                String.format("%,.0f", reserva.getPrecio() / 2) + ")."
            );
        }
        
        if (Math.random() < 0.1) { 
             throw new PagoRechazadoException("Transacción rechazada por el banco emisor (Simulación de falla).");
        }
        
        System.out.println("✅ Pago de $" + String.format("%,.0f", monto) + " procesado correctamente.");
    }
}