package semana02.src;

public class Main {
    public static void main(String[] args) {
        // Creando instancias de Hotel
        Hotel hotel1 = new Hotel("Hotel Cartagena Plaza", "Cartagena", 4);
        Hotel hotel2 = new Hotel("W Bogotá", "Bogotá", 5);

        // Creando instancias de Tour
        Tour tour1 = new Tour("Tour Ciudad Amurallada", "Cartagena", 120000);
        Tour tour2 = new Tour("Tour Café y Cultura", "Armenia", 95000);

        // Mostrando información de hoteles
        System.out.println("--- Información de Hoteles ---");
        hotel1.showHotelInfo();
        System.out.println();
        hotel2.showHotelInfo();

        // Mostrando información de tours
        System.out.println("\n--- Información de Tours ---");
        tour1.showTour();
        System.out.println();
        tour2.showTour();
    }
}