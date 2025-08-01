
# Proyecto - Obligatorio AED2 (Marzo 2025)

Este proyecto fue desarrollado como parte del curso **Algoritmos y Estructuras de Datos 2** (AED2) en la Universidad ORT Uruguay. El objetivo es implementar un sistema eficiente para gestionar las operaciones de una agencia de viajes, cumpliendo con las restricciones de tiempo indicadas para cada operación.  
Para esto, también utilizamos diferentes estructuras de datos para cumplir con las eficiencias requeridas.


## Autores

- Joaquín Gil - [@JoacoGDev](https://github.com/JoacoGDev)
- Mateo Gonzalez - [@M4730o](https://github.com/M4730o)


## Descripción

El sistema permite:

- Registrar, buscar y listar viajeros (por cédula, correo, categoría, edad, etc.)
- Registrar ciudades, conexiones y vuelos
- Consultar rutas entre ciudades según escalas, costo en minutos o en dólares
- Cumplir cotas de eficiencia como O(log n) u O(k) según el caso

Todas las operaciones implementadas retornan una instancia de la clase `Retorno`, que incluye resultado (OK o código de error), valor entero (si aplica) y valor string (si aplica).

## Estructuras utilizadas

Se implementaron estructuras de datos propias para cumplir con los requerimientos del curso:

- Árboles binarios de búsqueda (ABB) genéricos para gestionar viajeros
- Estructuras auxiliares como listas, pilas y colas, implementadas manualmente
- Grafo dirigido no genérico para modelar conexiones y vuelos entre ciudades

> **Importante:** No se utilizaron colecciones estándar de Java como `ArrayList`, `HashMap`, etc., tal como exige la consigna.

## Testing

El proyecto incluye un conjunto de pruebas unitarias en JUnit 5 que verifican el correcto funcionamiento de cada operación. Estas pruebas fueron desarrolladas por el equipo, complementando las pruebas publicadas por la cátedra.

## Cómo ejecutar

1. Abrir el proyecto en **IntelliJ IDEA**
2. Asegurarse de que la carpeta `lib/` contiene las dependencias necesarias para ejecutar los tests
3. Ejecutar desde la clase principal de test o desde cada clase específica según se quiera testear

## 📁 Estructura del proyecto

```
📁 src/
  ├── dominio/               # Clases internas del sistema (ciudad, viajero, vuelo, etc.)
  ├── interfaz/              # Interfaz Sistema.java (proporcionada por la cátedra)
  ├── sistema/               # Clase ImplementacionSistema.java con las operaciones
  └── test/                  # Pruebas unitarias (JUnit 5)

📁 lib/                      # Bibliotecas externas si se usan (por ejemplo junit.jar)
.gitignore                  # Archivo para ignorar compilados, .idea, etc.
README.md                   # Este archivo
```

## Consideraciones

- El proyecto **no imprime nada por consola**
- **No requiere interacción con el usuario**
- Se respetan todos los formatos de retorno y restricciones de eficiencia exigidas
