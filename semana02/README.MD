# Semana 02 - Modelado de Objetos: Hotel y Tour

**Estudiante:** Alvaro Enrique Espejo Barreto  
**Ficha:** 3228970A  
**Dominio Asignado:** Agencia de Viajes "Destinos del Mundo"  
**Carpeta:** `semana02`

---

## 🌎 Contexto

En el contexto de la agencia “Destinos del Mundo”, esta semana se explora el modelado de objetos más específicos del dominio turístico, como hoteles y tours, aplicando conceptos de clases, atributos, métodos y encapsulamiento en Java.

---

## 🎯 Objetivos de la Semana 02

- Aplicar los conceptos de clases y objetos para modelar elementos clave (hotel y tour) del dominio de una agencia de viajes.
- Implementar constructores, métodos getters y setters, y métodos para mostrar información.
- Instanciar y utilizar objetos desde una clase `Main`.

---

## 📝 Actividades Realizadas

### 1. Modelado de la clase **Hotel**

- Clase con atributos: `hotelName`, `location`, `starRating`.
- Incluye constructor, getters, setters y un método `showHotelInfo()` para mostrar los datos principales.

### 2. Modelado de la clase **Tour**

- Clase con atributos: `tourName`, `city`, `price`.
- Incluye constructor, getters, setters y un método `showTour()` para mostrar la información del tour.

### 3. Clase **Main**

- Contiene el método `main`.
- Crea varias instancias de `Hotel` y `Tour`.
- Llama a los métodos para mostrar la información de cada objeto.

---

## 🚩 Ejecución

1. Compila las clases:
    ```bash
    javac semana02/src/Hotel.java
    javac semana02/src/Tour.java
    javac semana02/src/Main.java
    ```
    O compílalas todas juntas:
    ```bash
    javac semana02/src/*.java
    ```

2. Ejecuta la clase `Main`:
    ```bash
    java semana02.src.Main
    ```

---

## 📁 Estructura de Archivos

```
semana02/
├── src/
│   ├── Hotel.java
│   ├── Tour.java
│   └── Main.java
└── README.md
```

---

## 💡 Notas

- El uso de nombres de clases con mayúscula inicial (`Hotel`, `Tour`, `Main`) sigue la convención de Java.
- Se recomienda una clase por archivo para claridad y mantenimiento.
- Puedes ampliar estos modelos agregando más atributos, métodos o clases según necesidades o actividades sugeridas por el instructor.

---

## 📚 Recursos de Apoyo

- [Material Teórico Semana 02 (en campus virtual/instructor)](#)
- Documentación oficial de [Java](https://docs.oracle.com/javase/tutorial/java/javaOO/)
- Ejercicios adicionales: consulta la carpeta `2-practica/` del repositorio del curso.

---

**¡Sigue practicando y preguntando cualquier duda que surja!**