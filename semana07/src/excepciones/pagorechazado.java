package com.agencia.excepciones;

/**
 * Excepción lanzada específicamente cuando el intento de pago por la reserva falla 
 * (ej. tarjeta rechazada, fondos insuficientes, monto insuficiente).
 * Es una excepción CHEQUEADA.
 */
public class PagoRechazadoException extends Exception {
    
    public PagoRechazadoException(String mensaje) {
        super(mensaje);
    }
    
    public PagoRechazadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}