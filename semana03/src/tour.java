public class TourMejorado {
    private String nombre;
    private String ciudad;
    private double precio;

    // Constructor completo
    public TourMejorado(String nombre, String ciudad, double precio) {
        setNombre(nombre);
        setCiudad(ciudad);
        setPrecio(precio);
    }

    // Constructor nombre y ciudad
    public TourMejorado(String nombre, String ciudad) {
        this(nombre, ciudad, 100_000.0);
    }

    // Constructor solo nombre
    public TourMejorado(String nombre) {
        this(nombre, "Sin ciudad", 100_000.0);
    }

    // Setters con validación
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty())
            this.nombre = nombre.trim();
        else
            throw new IllegalArgumentException("El nombre del tour no puede estar vacío.");
    }

    public void setCiudad(String ciudad) {
        if (ciudad != null && !ciudad.trim().isEmpty())
            this.ciudad = ciudad.trim();
        else
            throw new IllegalArgumentException("La ciudad no puede estar vacía.");
    }

    public void setPrecio(double precio) {
        if (precio >= 0)
            this.precio = precio;
        else
            throw new IllegalArgumentException("El precio debe ser positivo.");
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
    public double getPrecio() { return precio; }

    // Mostrar info
    public void mostrarInfo() {
        System.out.println("Tour:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Precio: $" + precio);
        System.out.println();
    }
}