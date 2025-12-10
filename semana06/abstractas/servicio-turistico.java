package abstractas;

/**
 * Clase Abstracta ServicioTuristico
 * Define el comportamiento y los atributos comunes para todos los servicios
 * turísticos (Vuelo, Hotel, Tour). No puede ser instanciada directamente.
 */
public abstract class ServicioTuristico {
    
    // Atributos protegidos: Accesibles para las subclases
    protected String nombre;
    protected double precioBase;
    protected String proveedor;
    
    // Constructor: Inicializa el estado común (Requisito de Ejercicio 1)
    public ServicioTuristico(String nombre, double precioBase, String proveedor) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.proveedor = proveedor;
    }
    
    // Método abstracto 1: Obliga a cada subclase a definir cómo se calcula su costo final
    // (El cálculo varía según el servicio: noches, escalas, personas, etc.)
    public abstract double calcularCostoTotal();
    
    // Método abstracto 2: Obliga a cada subclase a ofrecer una descripción específica
    public abstract String obtenerDescripcionDetallada();
    
    // Método concreto: Comportamiento común que se hereda (Requisito de Ejercicio 1)
    public void mostrarInformacionBase() {
        System.out.println("=== Detalle del Servicio ===");
        System.out.println("Proveedor: " + proveedor);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio Base: $" + precioBase);
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecioBase() {
        return precioBase;
    }
    
    public String getProveedor() {
        return proveedor;
    }
}