# Mejoras Realizadas – Semana 03

## Cambios de Encapsulamiento
- Todos los atributos se declararon como `private`.
- Se implementaron getters y setters para controlar y validar el acceso a datos.

## Sobrecarga de Constructores
- Se añadieron varios constructores en cada clase:
  - Completo (todos los datos)
  - Parcial (algunos datos, el resto valores por defecto)
  - Mínimo (un solo dato obligatorio)

## Validaciones
- Validación de emails, nombres no vacíos, rango de edad, estrellas del hotel (1-5), precio no negativo, etc.
- Los setters y constructores lanzan excepciones si se intenta asignar un valor inválido.

## Métodos Auxiliares
- En este ejemplo, las validaciones están en los setters para mayor claridad. Se podrían mover a métodos privados reutilizables si hay lógica repetida.

## Ventajas obtenidas
- Los objetos no pueden caer en estados erróneos.
- El código es más seguro y profesional.
- Creación flexible de instancias según la información disponible.

---