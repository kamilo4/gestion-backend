## Descripción del sistema

Este proyecto consiste en el desarrollo de una API REST utilizando Spring Boot para la gestión de empleados dentro de una organización.

El sistema permite administrar la información de los empleados (usuarios), incluyendo su registro, autenticación, actualización, inactivación y eliminación. Además, se implementa la gestión de categorías para organizar la información de manera estructurada.

La aplicación está diseñada bajo una arquitectura por capas (Controller, Service, Repository y Entity), lo que permite una mejor organización del código, escalabilidad y mantenimiento.

La base de datos utilizada es PostgreSQL, desplegada en Railway, lo que garantiza persistencia y disponibilidad de la información.

---

##  Modelo del sistema

###  Usuario (Empleado)

Representa a un empleado dentro del sistema.

**Atributos principales:**
- id
- nombre
- email
- password
- telefono
- activo

---

### Categoría

Representa una clasificación dentro del sistema.

**Ejemplos:**
- Tecnología  
- Recursos Humanos  
- Ventas  

---

## Funcionalidades principales

### Gestión de empleados

- Registro de empleados  
- Inicio de sesión  
- Consulta de empleados  
- Actualización de datos  
- Inactivación lógica  
- Eliminación  

---

### Gestión de categorías

- Crear categorías  
- Listar categorías  
- Actualizar categorías  
- Eliminar categorías  

---

## Arquitectura

El sistema está estructurado en capas:

- **Controller:** Manejo de peticiones HTTP  
- **Service:** Lógica de negocio  
- **Repository:** Acceso a la base de datos  
- **Entity:** Representación de las tablas  

---

## Base de datos

Se utiliza PostgreSQL desplegado en Railway para la persistencia de los datos.

