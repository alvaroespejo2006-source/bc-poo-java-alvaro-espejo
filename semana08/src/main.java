package com.servicio;

import com.servicio.modelo.Reserva;
import com.servicio.modelo.Cliente;
import com.servicio.modelo.Vuelo;
import com.servicio.modelo.Hotel;
import com.servicio.excepciones.DisponibilidadException;
import com.servicio.excepciones.PagoRechazadoException;
import com.servicio.excepciones.ReservaInvalidaException;
import com.servicio.servicio.GestorReservas;
import com.servicio.servicio.GestorVuelos;
import com.servicio.servicio.GestorHoteles;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        
        GestorReservas gestorReservas = new GestorReservas();
        GestorVuelos gestorVuelos = new GestorVuelos();
        GestorHoteles gestorHoteles = new GestorHoteles();

        // ----------------------------------------------------
        // 1. DEMOSTRACIÓN DE ÉXITO Y FLUJO COMPLETO
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("1. CASO DE ÉXITO: Reserva Válida y Pago");
        System.out.println("==================================================");
        
        Cliente clienteExito = new Cliente("Ana García", "ana@mail.com", "12345678");
        LocalDate fechaExito = LocalDate.now().plusDays(10);
        Reserva reservaExitosa = null;

        try {
            // Se agrega al Map en el gestor
            gestorReservas.agregarReserva("MAD101", clienteExito, fechaExito, 2500000);
            
            // Se recupera la reserva del Map para procesar el pago
            reservaExitosa = gestorReservas.buscarReserva("MAD101");
            
            if (reservaExitosa != null) {
                gestorReservas.procesarPago(reservaExitosa, 1500000); 
            }

        } catch (ReservaInvalidaException | DisponibilidadException | PagoRechazadoException e) {
            System.err.println("❌ Error en flujo exitoso: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de Éxito.\n");
        }
        
        
        // ----------------------------------------------------
        // 2. CASO FALLA: ReservaInvalidaException (Precio Inválido)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("2. CASO FALLA: ReservaInvalidaException");
        System.out.println("==================================================");
        
        try {
            gestorReservas.agregarReserva("BCN202", new Cliente("Carlos Pérez", "carlos@mail.com", "98765432"), LocalDate.now().plusDays(5), 0);
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Capturada ReservaInvalidaException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de ReservaInválida.\n");
        }
        
        
        // ----------------------------------------------------
        // 3. CASO FALLA: DisponibilidadException (Cupo Lleno)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("3. CASO FALLA: DisponibilidadException");
        System.out.println("==================================================");
        
        LocalDate fechaAgotada = LocalDate.now().plusDays(2); 
        Cliente clienteBase = new Cliente("Cliente Prueba", "prueba@mail.com", "111");

        try {
            // Llenar el cupo (5 reservas), MAD101 ya estaba en otra fecha.
            gestorReservas.agregarReserva("BOG001", clienteBase, fechaAgotada, 1000000);
            gestorReservas.agregarReserva("BOG002", clienteBase, fechaAgotada, 1000000);
            gestorReservas.agregarReserva("BOG003", clienteBase, fechaAgotada, 1000000);
            gestorReservas.agregarReserva("BOG004", clienteBase, fechaAgotada, 1000000);
            gestorReservas.agregarReserva("BOG005", clienteBase, fechaAgotada, 1000000);
            
            // Intento de la sexta reserva (que debe fallar)
            System.out.println("\nIntentando agregar la sexta reserva...");
            gestorReservas.agregarReserva("BOG006", clienteBase, fechaAgotada, 1000000);
            
        } catch (DisponibilidadException e) {
            System.err.println("❌ Capturada DisponibilidadException: " + e.getMessage());
        } catch (ReservaInvalidaException e) {
             System.err.println("❌ Error de lógica: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de Disponibilidad en Reservas.\n");
        }
        
        
        // ----------------------------------------------------
        // 4. CASO FALLA: PagoRechazadoException (Monto Insuficiente)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("4. CASO FALLA: PagoRechazadoException");
        System.out.println("==================================================");
        
        Reserva reservaPago = new Reserva("CAL333", clienteExito, LocalDate.now().plusDays(20), 4000000); 

        try {
            gestorReservas.procesarPago(reservaPago, 1500000);
        } catch (PagoRechazadoException e) {
            System.err.println("❌ Capturada PagoRechazadoException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("-> **FINALLY**: Auditoría de pago finalizada, independientemente del resultado.");
            System.out.println("Fin de la demostración de Pago Rechazado.\n");
        }
        
        // ----------------------------------------------------
        // 5. CASO FALLA: DisponibilidadException (GestorHoteles)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("5. CASO FALLA: DisponibilidadException (Hotel)");
        System.out.println("==================================================");

        Hotel hotelEjemplo = new Hotel("The Weekend Inn", 200000, "Hotel Chain", "Bogotá", 3);
        gestorHoteles.agregarHotel(hotelEjemplo);
        
        LocalDate fechaFinDeSemana = LocalDate.of(2025, 12, 6); 

        try {
            System.out.println("Intentando reservar para el " + fechaFinDeSemana + " (Sábado)...");
            gestorHoteles.buscarYConfirmar("The Weekend Inn", fechaFinDeSemana);
        } catch (DisponibilidadException e) {
            System.err.println("❌ Capturada DisponibilidadException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
             System.err.println("❌ Error de búsqueda: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de Disponibilidad en Hoteles.\n");
        }
        
        System.out.println("==================================================");
        System.out.println("DEMOSTRACIÓN COMPLETA DE LA SEMANA 08 FINALIZADA");
        System.out.println("==================================================");
    }
}