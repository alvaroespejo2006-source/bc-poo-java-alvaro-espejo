public class Vuelo {

    // Atributos
    private String numeroVuelo;
    private String aerolinea;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String fechaLlegada;
    private double precio;

    // Constructor
    public Vuelo(String numeroVuelo, String aerolinea, String origen, String destino,
                 String fechaSalida, String fechaLlegada, double precio) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.precio = precio;
    }

    // Mostrar información del vuelo
    public void mostrarInfoVuelo() {
        System.out.println("✈️ Información del Vuelo");
        System.out.println("Número de Vuelo: " + numeroVuelo);
        System.out.println("Aerolínea: " + aerolinea);
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        System.out.println("Fecha de Salida: " + fechaSalida);
        System.out.println("Fecha de Llegada: " + fechaLlegada);
        System.out.println("Precio: $" + precio);
        System.out.println("------------------------------------");
    }

    // Calcular precio con impuestos (ejemplo simple 19%)
    public double calcularPrecioConImpuestos() {
        return precio * 1.19;
    }

    // Cambiar fecha del vuelo
    public void cambiarFecha(String nuevaSalida, String nuevaLlegada) {
        this.fechaSalida = nuevaSalida;
        this.fechaLlegada = nuevaLlegada;
        System.out.println("Las fechas del vuelo " + numeroVuelo + " han sido actualizadas.");
    }
}

