package com.agencia.excepciones;

/**
 * Excepción lanzada cuando un servicio (Vuelo, Hotel, Paquete) 
 * no tiene la disponibilidad requerida para la fecha o cantidad solicitada.
 * Es una excepción CHEQUEADA.
 */
public class DisponibilidadException extends Exception {
    
    // Constructor 1: Acepta solo el mensaje de error
    public DisponibilidadException(String mensaje) {
        super(mensaje);
    }
    
    // Constructor 2: Acepta el mensaje y la causa original (Throwable)
    public DisponibilidadException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}