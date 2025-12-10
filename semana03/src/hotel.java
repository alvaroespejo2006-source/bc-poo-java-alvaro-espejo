public class HotelMejorado {
    private String nombre;
    private String ubicacion;
    private int estrellas;

    // Constructor completo
    public HotelMejorado(String nombre, String ubicacion, int estrellas) {
        setNombre(nombre);
        setUbicacion(ubicacion);
        setEstrellas(estrellas);
    }

    // Constructor nombre y ubicación
    public HotelMejorado(String nombre, String ubicacion) {
        this(nombre, ubicacion, 3);
    }

    // Constructor solo nombre
    public HotelMejorado(String nombre) {
        this(nombre, "Sin ubicación", 3);
    }

    // Setters con validación
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            throw new IllegalArgumentException("El nombre del hotel no puede estar vacío.");
        }
    }

    public void setUbicacion(String ubicacion) {
        if (ubicacion != null && !ubicacion.trim().isEmpty()) {
            this.ubicacion = ubicacion.trim();
        } else {
            throw new IllegalArgumentException("La ubicación no puede estar vacía.");
        }
    }

    public void setEstrellas(int estrellas) {
        if (estrellas >= 1 && estrellas <= 5) {
            this.estrellas = estrellas;
        } else {
            throw new IllegalArgumentException("El número de estrellas debe ser de 1 a 5.");
        }
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public int getEstrellas() { return estrellas; }

    // Mostrar info
    public void mostrarInfo() {
        System.out.println("Hotel:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Estrellas: " + estrellas);
        System.out.println();
    }
}