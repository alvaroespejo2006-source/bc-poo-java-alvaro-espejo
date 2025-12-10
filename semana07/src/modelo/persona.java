public class PersonaMejorada {
    private String nombre;
    private String email;
    private int edad;

    // Constructor completo
    public PersonaMejorada(String nombre, String email, int edad) {
        setNombre(nombre);
        setEmail(email);
        setEdad(edad);
    }

    // Constructor parcial: nombre, email
    public PersonaMejorada(String nombre, String email) {
        this(nombre, email, 18);
    }

    // Constructor con solo nombre
    public PersonaMejorada(String nombre) {
        this(nombre, "sin-email@example.com", 18);
    }

    // Setters con validación
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("El email debe contener '@'.");
        }
    }

    public void setEdad(int edad) {
        if (edad >= 18) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("La edad mínima permitida es 18.");
        }
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public int getEdad() { return edad; }

    // Método para mostrar info
    public void mostrarInfo() {
        System.out.println("Persona:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Edad: " + edad);
        System.out.println();
    }
}