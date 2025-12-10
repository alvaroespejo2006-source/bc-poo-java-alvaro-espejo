package semana02.src;

public class hotel {
    public class Hotel {
    private String hotelName;
    private String location;
    private int starRating;

    public Hotel(String hotelName, String location, int starRating) {
        this.hotelName = hotelName;
        this.location = location;
        this.starRating = starRating;
    }

    // Getters
    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public int getStarRating() {
        return starRating;
    }

    // Setters
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    // Método de negocio
    public void showHotelInfo() {
        System.out.println("Hotel: " + hotelName);
        System.out.println("Ubicación: " + location);
        System.out.println("Estrellas: " + starRating);
    }
}
}