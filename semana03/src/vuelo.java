public class VueloMejorado {
    private String codigo;
    private String origen;
    private String destino;
    private int capacidad;

    // Constructor completo
    public VueloMejorado(String codigo, String origen, String destino, int capacidad) {
        setCodigo(codigo);
        setOrigen(origen);
        setDestino(destino);
        setCapacidad(capacidad);
    }

    // Constructor con código, origen y destino (capacidad por defecto)
    public VueloMejorado(String codigo, String origen, String destino) {
        this(codigo, origen, destino, 120);
    }

    // Constructor solo código y destino (origen y capacidad por defecto)
    public VueloMejorado(String codigo, String destino) {
        this(codigo, "Bogotá", destino, 120); // origen: Bogotá por defecto
    }

    // Setters con validación
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty())
            this.codigo = codigo.trim();
        else
            throw new IllegalArgumentException("El código de vuelo no puede ser vacío.");
    }

    public void setOrigen(String origen) {
        if (origen != null && !origen.trim().isEmpty())
            this.origen = origen.trim();
        else
            throw new IllegalArgumentException("El origen no puede ser vacío.");
    }

    public void setDestino(String destino) {
        if (destino != null && !destino.trim().isEmpty())
            this.destino = destino.trim();
        else
            throw new IllegalArgumentException("El destino no puede ser vacío.");
    }

    public void setCapacidad(int capacidad) {
        if (capacidad > 0)
            this.capacidad = capacidad;
        else
            throw new IllegalArgumentException("La capacidad debe ser positiva.");
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public int getCapacidad() { return capacidad; }

    // Método de mostrar información
    public void mostrarInfo() {
        System.out.println("Vuelo:");
        System.out.println("Código: " + codigo);
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        System.out.println("Capacidad: " + capacidad + " pasajeros");
        System.out.println();
    }
}