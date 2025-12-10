# Semana 01 - Introducción al Paradigma Orientado a Objetos

**Estudiante:** Alvaro Enrique Espejo Barreto  
**Ficha:** 3228970A  
**Dominio Asignado:** Agencia de Viajes "Destinos del Mundo"

---

## 📋 Contexto del Dominio

**Tipo de Negocio:** Agencia de Viajes y Turismo  
**Nombre Comercial:** Destinos del Mundo  
**Ubicación:** Bogotá, Zona T  
**Especialidad:** Paquetes turísticos, reservas de vuelos, hoteles, tours

### Descripción Breve
Destinos del Mundo es una agencia de viajes que ofrece paquetes turísticos nacionales e internacionales, reservas de vuelos, hoteles, tours guiados y asesoría personalizada. Cuenta con 12 asesores de viajes y gestiona aproximadamente 200 reservas mensuales.

---

## 🎯 Objetivos de la Semana 01

Al finalizar esta semana, deberás ser capaz de:

1. Identificar objetos del mundo real en el contexto de una agencia de viajes
2. Comprender las diferencias entre programación estructurada y POO
3. Reconocer los conceptos fundamentales: clase, objeto, atributo, método
4. Crear tu primera clase simple en Java aplicada al dominio

---

## 📝 Actividades Obligatorias

### Actividad 1: Identificación de Objetos (Ejercicio 01)

**Instrucciones:**
- Lee el material teórico de la semana sobre conceptos fundamentales de POO
- Identifica **5 objetos principales** que existen en una agencia de viajes
- Para cada objeto, describe:
  - ¿Qué es? (definición)
  - ¿Qué características tiene? (atributos)
  - ¿Qué puede hacer? (comportamientos/métodos)

**Ejemplo:**
```
Objeto: Reserva de Viaje
- ¿Qué es?: Una reserva de paquete turístico realizada por un cliente
- Características: código de reserva, cliente, destino, fecha de salida, fecha de regreso, precio
- Comportamientos: registrar reserva, calcular costo, confirmar pago, cancelar reserva
```

**Entregable:** Documento con la identificación de 5 objetos del dominio de la agencia de viajes.

---

### Actividad 2: Comparación de Paradigmas (Ejercicio 02)

**Instrucciones:**
- Investiga las diferencias entre programación estructurada y POO
- Escribe un ejemplo conceptual de cómo se manejaría la información de una reserva de viaje en:
  1. **Programación estructurada** (usando variables sueltas y funciones)
  2. **Programación orientada a objetos** (usando una clase)

**Entregable:** Documento comparativo con ejemplos explicados.

---

### Actividad 3: Primera Clase Simple (Ejercicio 03)

**Instrucciones:**
Crea tu primera clase en Java llamada `TravelBooking` (Reserva de Viaje) con:
- **3 atributos** (ej: `bookingCode`, `destination`, `price`)
- **1 constructor** que inicialice los atributos
- **1 método** que muestre la información de la reserva

**Código de ejemplo:**

```java
public class TravelBooking {
    // Atributos
    String bookingCode;
    String destination;
    double price;
    
    // Constructor
    public TravelBooking(String bookingCode, String destination, double price) {
        this.bookingCode = bookingCode;
        this.destination = destination;
        this.price = price;
    }
    
    // Método para mostrar información
    public void showInfo() {
        System.out.println("Código de Reserva: " + bookingCode);
        System.out.println("Destino: " + destination);
        System.out.println("Precio: $" + price);
    }
}
```

**Instrucciones adicionales:**
1. Crea una clase `Main` con el método `main`
2. Instancia **3 objetos diferentes** de tipo `TravelBooking`
3. Llama al método `showInfo()` para cada objeto

**Entregable:** Archivo `TravelBooking.java` y `Main.java` funcionando correctamente.

---

### Actividad 4: Múltiples Objetos (Ejercicio 04)

**Instrucciones:**
Amplía el ejercicio anterior:
- Crea al menos **5 objetos** de tipo `TravelBooking` con datos diferentes
- Cada reserva debe tener información coherente con una agencia de viajes real
- Muestra la información de todas las reservas

**Ejemplo de datos:**
- RES-001, Cartagena, $1200000
- RES-002, San Andrés, $1800000
- RES-003, Eje Cafetero, $950000
- RES-004, Cancún, $3500000
- RES-005, Buenos Aires, $2800000

**Entregable:** Código Java con 5 instancias de `TravelBooking` y su salida en consola.

---

## 🎓 Criterios de Evaluación

| Criterio | Peso | Descripción |
|----------|------|-------------|
| **Identificación de objetos** | 25% | Objetos identificados son relevantes al dominio de la agencia de viajes |
| **Comprensión conceptual** | 25% | Demuestra entender diferencias entre paradigmas |
| **Implementación de clase** | 30% | Clase `TravelBooking` implementada correctamente con atributos, constructor y método |
| **Instanciación de objetos** | 20% | Crea múltiples objetos con datos coherentes |

---

## 📚 Recursos de Apoyo

### Material Teórico (Carpeta `1-teoria/`)
- `01-historia-evolucion-poo.md`
- `02-paradigmas-programacion.md`
- `03-conceptos-fundamentales-poo.md`
- `04-primer-programa-poo.md`

### Ejercicios Guiados (Carpeta `2-practica/`)
- `ejercicio-01-comparacion-paradigmas/`
- `ejercicio-02-primera-clase/`
- `ejercicio-03-multiples-objetos/`
- `ejercicio-04-modelado-mundo-real/`

### Glosario
Revisa el archivo `3-recursos/glosario.md` para términos clave de esta semana.

---

## 💡 Consejos

1. **No te compliques:** Esta semana es sobre conceptos básicos, no sobre código complejo
2. **Piensa en objetos reales:** Visualiza cómo funciona una agencia de viajes real
3. **Pregunta:** Si tienes dudas sobre el dominio o los conceptos, consulta con el instructor
4. **Compila y prueba:** Asegúrate de que tu código compile antes de entregar

---

## 📅 Fecha de Entrega

**Entrega:** Según calendario definido por el instructor  
**Formato:** Código fuente (.java) y documentos en formato Markdown o PDF

---

**Nota Importante:** Este es tu dominio personal para todo el bootcamp. Todas las actividades futuras seguirán en el contexto de la agencia de viajes Destinos del Mundo. No compartas tu código directamente con otros estudiantes, ya que cada uno tiene un dominio diferente.
