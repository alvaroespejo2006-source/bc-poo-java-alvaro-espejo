package com.servicio.servicio;

import com.servicio.modelo.Reserva;
import com.servicio.modelo.Cliente;
import com.servicio.excepciones.ReservaInvalidaException;
import com.servicio.excepciones.DisponibilidadException;
import com.servicio.excepciones.PagoRechazadoException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorReservas {
    
    // Uso de HashMap para almacenamiento eficiente: Clave (Código de Reserva) -> Valor (Objeto Reserva)
    private Map<String, Reserva> reservas = new HashMap<>();
    private static final int CUPO_MAXIMO_DIARIO = 5; 

    public Reserva buscarReserva(String codigo) {
        // Búsqueda eficiente O(1)
        return reservas.get(codigo);
    }

    public void agregarReserva(String codigo, Cliente cliente, LocalDate fecha, double precio)
            throws ReservaInvalidaException, DisponibilidadException {
        
        if (reservas.containsKey(codigo)) {
            throw new ReservaInvalidaException("El código de reserva " + codigo + " ya existe.");
        }
        if (precio <= 0) {
            throw new ReservaInvalidaException("El precio de la reserva debe ser estrictamente positivo.");
        }
        if (!codigo.matches("[A-Z]{3}\\d{3}")) {
            throw new ReservaInvalidaException("El código debe tener formato AAA### (ejemplo: BOG101).");
        }
        
        // Contar reservas para la fecha usando Stream API
        long reservasEnFecha = reservas.values().stream()
                .filter(r -> r.getFecha().isEqual(fecha))
                .count();
                
        if (reservasEnFecha >= CUPO_MAXIMO_DIARIO) {
            throw new DisponibilidadException(
                "No hay cupo disponible (" + CUPO_MAXIMO_DIARIO + " máximo) para la fecha: " + fecha
            );
        }
        
        Reserva nueva = new Reserva(codigo, cliente, fecha, precio);
        reservas.put(codigo, nueva); // Almacenar en el Map
        System.out.println("✅ Reserva " + codigo + " agregada exitosamente para " + cliente.getNombre());
    }
    
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