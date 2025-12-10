package semana02.src;

public class tour {
    public class Tour {
    private String tourName;
    private String city;
    private double price;
    
    public Tour(String tourName, String city, double price) {
        this.tourName = tourName;
        this.city = city;
        this.price = price;
    }
    
    // Getters
    public String getTourName() {
        return tourName;
    }
    
    public String getCity() {
        return city;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Setters
    public void setTourName(String tourName) {
        this.tourName = tourName;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Método de negocio
    public void showTour() {
        System.out.println("Nombre del Tour: " + tourName);
        System.out.println("Ciudad: " + city);
        System.out.println("Precio: $" + price);
    }
}
}