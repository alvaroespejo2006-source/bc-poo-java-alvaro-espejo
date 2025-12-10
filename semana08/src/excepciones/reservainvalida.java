package com.agencia.excepciones;

/**
 * Excepción lanzada cuando los datos de una reserva (código, precio, fechas) 
 * no cumplen con los requisitos mínimos o reglas de negocio de la agencia.
 * Es una excepción CHEQUEADA.
 */
public class ReservaInvalidaException extends Exception {
    
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
    
    public ReservaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}