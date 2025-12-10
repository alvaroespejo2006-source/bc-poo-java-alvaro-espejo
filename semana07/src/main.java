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
        
        // Inicialización de gestores
        GestorReservas gestorReservas = new GestorReservas();
        GestorVuelos gestorVuelos = new GestorVuelos();
        GestorHoteles gestorHoteles = new GestorHoteles();

        // ----------------------------------------------------
        // CASO DE PRUEBA 1: ÉXITO (Reserva Válida y Pago)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("1. DEMOSTRACIÓN DE ÉXITO Y FLUJO COMPLETO");
        System.out.println("==================================================");
        
        Cliente clienteExito = new Cliente("Ana García", "12345678");
        LocalDate fechaExito = LocalDate.now().plusDays(10);
        Reserva reservaExitosa = null;

        try {
            // A. Intentar crear la reserva
            gestorReservas.agregarReserva("MAD101", clienteExito, fechaExito, 2500000);
            
            // B. Si la reserva se agregó, simular la creación del objeto
            reservaExitosa = new Reserva("MAD101", clienteExito, fechaExito, 2500000);
            
            // C. Procesar el pago
            gestorReservas.procesarPago(reservaExitosa, 1500000); // Pago suficiente

        } catch (ReservaInvalidaException | DisponibilidadException | PagoRechazadoException e) {
            System.err.println("❌ Error en flujo exitoso: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de Éxito.\n");
        }
        
        
        // ----------------------------------------------------
        // CASO DE PRUEBA 2: ReservaInválidaException (Precio Inválido)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("2. DEMOSTRACIÓN: ReservaInvalidaException");
        System.out.println("==================================================");
        
        try {
            // Intento con un precio no positivo
            gestorReservas.agregarReserva("BCN202", new Cliente("Carlos Pérez", "98765432"), LocalDate.now().plusDays(5), 0);
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Capturada ReservaInvalidaException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de ReservaInválida.\n");
        }
        
        
        // ----------------------------------------------------
        // CASO DE PRUEBA 3: DisponibilidadException (Cupo Lleno)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("3. DEMOSTRACIÓN: DisponibilidadException (Cupo en GestorReservas)");
        System.out.println("==================================================");
        
        LocalDate fechaAgotada = LocalDate.now().plusDays(2); 
        Cliente clienteBase = new Cliente("Cliente Prueba", "111");

        try {
            // Llenar el cupo (5 reservas)
            for (int i = 1; i <= 5; i++) {
                gestorReservas.agregarReserva("BOG00" + i, clienteBase, fechaAgotada, 1000000);
            }
            
            // Intento de la sexta reserva (que debe fallar)
            System.out.println("\nIntentando agregar la sexta reserva...");
            gestorReservas.agregarReserva("BOG006", clienteBase, fechaAgotada, 1000000);
            
        } catch (DisponibilidadException e) {
            System.err.println("❌ Capturada DisponibilidadException: " + e.getMessage());
        } catch (ReservaInvalidaException e) {
             System.err.println("❌ Error de lógica (no debería pasar): " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de Disponibilidad en Reservas.\n");
        }
        
        
        // ----------------------------------------------------
        // CASO DE PRUEBA 4: PagoRechazadoException (Monto Insuficiente)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("4. DEMOSTRACIÓN: PagoRechazadoException (Monto Insuficiente)");
        System.out.println("==================================================");
        
        Reserva reservaPago = new Reserva("CAL333", clienteExito, LocalDate.now().plusDays(20), 4000000); 

        try {
            // Intento de pago con monto inferior al 50% (mínimo $2'000.000)
            gestorReservas.procesarPago(reservaPago, 1500000);
        } catch (PagoRechazadoException e) {
            System.err.println("❌ Capturada PagoRechazadoException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de Pago Rechazado (monto).\n");
        }
        
        // ----------------------------------------------------
        // CASO DE PRUEBA 5: DisponibilidadException (GestorVuelos)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("5. DEMOSTRACIÓN: DisponibilidadException (GestorVuelos)");
        System.out.println("==================================================");
        
        // Simular un vuelo que está en estado "No Disponible"
        Vuelo vueloAgotado = new Vuelo("VY007", "Miami", 350000, "No Disponible");
        gestorVuelos.agregarVuelo(vueloAgotado);
        
        try {
            gestorVuelos.buscarYReservar("VY007");
        } catch (DisponibilidadException e) {
            System.err.println("❌ Capturada DisponibilidadException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
             System.err.println("❌ Error: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de Disponibilidad en Vuelos.\n");
        }
        
        // ----------------------------------------------------
        // CASO DE PRUEBA 6: DisponibilidadException (GestorHoteles)
        // ----------------------------------------------------
        System.out.println("==================================================");
        System.out.println("6. DEMOSTRACIÓN: DisponibilidadException (GestorHoteles)");
        System.out.println("==================================================");

        Hotel hotelEjemplo = new Hotel("The Weekend Inn", "Bogotá");
        gestorHoteles.agregarHotel(hotelEjemplo);
        
        // La lógica del hotel simula que los fines de semana (sábado y domingo) están llenos
        LocalDate fechaFinDeSemana = LocalDate.of(2025, 12, 6); // Sábado (fecha de ejemplo)

        try {
            System.out.println("Intentando reservar para el " + fechaFinDeSemana + " (Sábado)...");
            gestorHoteles.buscarYConfirmar("The Weekend Inn", fechaFinDeSemana);
        } catch (DisponibilidadException e) {
            System.err.println("❌ Capturada DisponibilidadException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
             System.err.println("❌ Error: " + e.getMessage());
        } finally {
            System.out.println("Fin de la demostración de Disponibilidad en Hoteles.\n");
        }
        
        System.out.println("==================================================");
        System.out.println("DEMOSTRACIÓN FINALIZADA");
        System.out.println("==================================================");
    }
}