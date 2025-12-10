package semana_06; // Puedes ajustar el paquete si usas uno diferente

import abstractas.ServicioTuristico;
import implementaciones.Vuelo;
import implementaciones.Hotel;
import implementaciones.Tour;
import implementaciones.PaqueteTuristico;
import interfaces.Reservable;
import interfaces.Calificable;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== ✈️ AGENCIA DE VIAJES: DEMOSTRACIÓN SEMANA 06 ===\n");
        
        // =========================================================
        // 1. Demostrar polimorfismo con Clase Abstracta (Ejercicio 3)
        // =========================================================
        System.out.println("--- 🌍 GESTIÓN POLIMÓRFICA DE SERVICIOS TURÍSTICOS ---");
        
        // Array/List de tipo abstracto: ServicioTuristico
        ArrayList<ServicioTuristico> inventarioServicios = new ArrayList<>();
        
        // Almacenamos diferentes subclases concretas
        inventarioServicios.add(new Vuelo("Vuelo BOG-SCL", 950000, "LATAM",
                                         "Bogotá", "Santiago", 0));
        inventarioServicios.add(new Hotel("Hotel Estelar", 150000, "Estelar",
                                          "Cali", 2)); // 2 noches
        inventarioServicios.add(new Tour("Tour Nevado", 80000, 
                                        "Aventura Tours", "Manizales", 6, 4)); // 4 personas
        inventarioServicios.add(new PaqueteTuristico("Luna de Miel Bali", 12000000, 
                                                    "Paradise", 10)); // 10 días
        
        double costoTotalInventario = 0;

        // Invocar métodos polimórficos y abstractos
        for (ServicioTuristico servicio : inventarioServicios) {
            System.out.println("\n-------------------------------------");
            servicio.mostrarInformacionBase(); // Método concreto de la abstracta
            
            // Dynamic Binding: El método implementado varía según el tipo real (Vuelo, Hotel, Tour, Paquete)
            System.out.println("Descripción: " + servicio.obtenerDescripcionDetallada()); 
            double costo = servicio.calcularCostoTotal();
            System.out.println("Costo Total Calculado: $" + String.format("%,.0f", costo)); 
            
            costoTotalInventario += costo;
        }
        
        System.out.println("\n-------------------------------------");
        System.out.println("COSTO TOTAL DEL INVENTARIO: $" + String.format("%,.0f", costoTotalInventario)); 

        // =================================================
        // 2. Demostrar Interfaces (Ejercicio 3 y 4)
        // =================================================
        
        System.out.println("\n=== 🧩 DEMOSTRACIÓN DE CAPACIDADES POR INTERFACE ===\n");
        
        // Referencias a los objetos para demostrar interfaces
        Vuelo vueloDemo = (Vuelo) inventarioServicios.get(0);
        Hotel hotelDemo = (Hotel) inventarioServicios.get(1);
        PaqueteTuristico paqueteDemo = (PaqueteTuristico) inventarioServicios.get(3);
        
        // --- 2.1. Uso de la Interface Reservable ---
        System.out.println("--- GESTIÓN DE RESERVAS ---");
        
        // 1. Vuelo como Reservable
        Reservable reservableVuelo = vueloDemo;
        System.out.println("Vuelo - Disponibilidad: " + reservableVuelo.verificarDisponibilidad("2026-05-20"));
        reservableVuelo.realizarReserva("C001", "2026-05-20");
        System.out.println("Código: " + reservableVuelo.obtenerCodigoReserva());
        
        // 2. Paquete Turístico como Reservable (Múltiple Implementación)
        Reservable reservablePaquete = paqueteDemo;
        reservablePaquete.realizarReserva("C002", "2026-11-01");
        System.out.println("Paquete - Código: " + reservablePaquete.obtenerCodigoReserva());

        // --- 2.2. Uso de la Interface Calificable ---
        System.out.println("\n--- GESTIÓN DE CALIFICACIONES ---");

        // 1. Hotel como Calificable
        Calificable calificableHotel = hotelDemo;
        calificableHotel.agregarCalificacion(5, "Excelente ubicación.");
        calificableHotel.agregarCalificacion(4, "Buen servicio.");
        System.out.println("Hotel - Promedio: " + String.format("%.1f", calificableHotel.obtenerPromedioCalificaciones()) + " estrellas.");

        // 2. Paquete Turístico como Calificable (Múltiple Implementación)
        Calificable calificablePaquete = paqueteDemo;
        calificablePaquete.agregarCalificacion(5, "Viaje inolvidable.");
        calificablePaquete.agregarCalificacion(5, "Todo perfecto.");
        System.out.println("Paquete - Promedio: " + String.format("%.1f", calificablePaquete.obtenerPromedioCalificaciones()) + " estrellas.");
        
        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}