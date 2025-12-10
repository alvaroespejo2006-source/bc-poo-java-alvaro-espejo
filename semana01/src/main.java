public class main {
public class Main {
    public static void main(String[] args) {

        // Crear un asesor de viajes
        persona personaObj = new persona(); // Para acceder a la clase interna
        persona.AsesorDeViajes asesor = personaObj.new AsesorDeViajes(
                "Carlos Gómez",
                "A123",
                "Turismo Internacional",
                8,
                120
        );

        // Probar métodos del asesor
        asesor.atenderCliente();
        asesor.registrarReserva();
        asesor.recomendarPaquete();
        asesor.generarReporte();

        System.out.println("\n===============================\n");

        // Crear un vuelo
        Vuelo vuelo1 = new Vuelo(
                "AV452",
                "Avianca",
                "Bogotá",
                "Madrid",
                "2025-03-15 14:00",
                "2025-03-16 06:30",
                3500.00
        );

        // Probar métodos del vuelo
        vuelo1.mostrarInfoVuelo();
        System.out.println("Precio con impuestos: $" + vuelo1.calcularPrecioConImpuestos());

        vuelo1.cambiarFecha("2025-03-16 15:00", "2025-03-17 07:00");
        vuelo1.mostrarInfoVuelo();
    }
}

     
}