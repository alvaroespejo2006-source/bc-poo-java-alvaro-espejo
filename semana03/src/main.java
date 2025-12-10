public class Main {
    public static void main(String[] args) {
        // Prueba PersonaMejorada
        PersonaMejorada p1 = new PersonaMejorada("Juan Pérez", "juanp@gmail.com", 28);
        PersonaMejorada p2 = new PersonaMejorada("Laura Gómez", "lau@g.com");
        PersonaMejorada p3 = new PersonaMejorada("Carlos Soto");
        
        p1.mostrarInfo();
        p2.mostrarInfo();
        p3.mostrarInfo();

        // Prueba HotelMejorado
        HotelMejorado h1 = new HotelMejorado("Hotel Cartagena Plaza", "Cartagena", 4);
        HotelMejorado h2 = new HotelMejorado("W Bogotá", "Bogotá");
        HotelMejorado h3 = new HotelMejorado("Ibis");

        h1.mostrarInfo();
        h2.mostrarInfo();
        h3.mostrarInfo();

        // Prueba TourMejorado
        TourMejorado t1 = new TourMejorado("Tour Ciudad Amurallada", "Cartagena", 125000);
        TourMejorado t2 = new TourMejorado("Aventura Café", "Armenia");
        TourMejorado t3 = new TourMejorado("City Tour");

        t1.mostrarInfo();
        t2.mostrarInfo();
        t3.mostrarInfo();
    }
}