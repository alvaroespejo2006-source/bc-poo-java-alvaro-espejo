package interfaces;

/**
 * Interface Calificable
 * Define la capacidad de recibir y gestionar la reputación o calidad de un servicio.
 * * Clases que implementan: Hotel, PaqueteTuristico.
 */
public interface Calificable {
    
    // Método para añadir una calificación (estrellas y comentario)
    void agregarCalificacion(int estrellas, String comentario);
    
    // Método para calcular el promedio actual de las calificaciones
    double obtenerPromedioCalificaciones();
}