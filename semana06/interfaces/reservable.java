package interfaces;

/**
 * Interface Reservable
 * Define la capacidad de gestionar la disponibilidad y el registro de una reserva.
 * * Clases que implementan: Vuelo, PaqueteTuristico, (posiblemente Tour).
 */
public interface Reservable {
    
    // Método para consultar el estado de la reserva en una fecha específica
    String verificarDisponibilidad(String fecha); 
    
    // Método para registrar la reserva para un cliente
    void realizarReserva(String clienteId, String fecha);
    
    // Método para obtener el código único de la reserva generada
    String obtenerCodigoReserva();
}