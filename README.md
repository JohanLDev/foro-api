# Foro Hub API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-green)
![Flyway](https://img.shields.io/badge/Flyway-DB--Migration-red)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Swagger](https://img.shields.io/badge/Swagger-API%20Docs-brightgreen)

## 📖 Historia

¡Bienvenido a **Foro Hub API**! 🎉  
Este proyecto corresponde al **Challenge Back End de Alura**, cuyo objetivo es replicar la lógica de un foro a nivel de **back end**, implementando una **API REST** con **Spring Boot**.

Un foro es un espacio de aprendizaje y colaboración donde los usuarios pueden crear tópicos, resolver dudas y compartir conocimiento. Nuestro reto fue construir la base de este sistema, enfocándonos en el manejo de **tópicos** y ofreciendo un CRUD completo.

### Objetivos principales

La API permite a los usuarios:

- **Crear un nuevo tópico**  
- **Listar todos los tópicos**  
- **Mostrar un tópico específico por ID**  
- **Actualizar un tópico existente**  
- **Eliminar un tópico**  

### Alcance técnico

- API con rutas implementadas siguiendo las mejores prácticas REST  
- Validaciones de negocio aplicadas en cada endpoint  
- Persistencia de datos en base de datos relacional (MySQL)  
- Autenticación y autorización mediante servicio de login con JWT  
- Documentación interactiva con Swagger UI  

---

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.3**
- **Spring Data JPA**
- **Flyway** (Migraciones de base de datos)
- **MySQL 8.0**
- **Spring Security con JWT**
- **Swagger / OpenAPI 3.0**

---

## 🚀 Endpoints principales

### Tópicos (`/topicos`)

| Método | Endpoint          | Descripción                  |
|--------|------------------|------------------------------|
| GET    | `/topicos`       | Obtiene todos los tópicos    |
| GET    | `/topicos/{id}`  | Obtiene un tópico por ID     |
| POST   | `/topicos`       | Crea un nuevo tópico         |
| PUT    | `/topicos/{id}`  | Actualiza un tópico existente|
| DELETE | `/topicos/{id}`  | Elimina un tópico            |

### Autenticación (`/login`)

| Método | Endpoint  | Descripción                        |
|--------|-----------|------------------------------------|
| POST   | `/login`  | Genera un token JWT de autenticación|

---

## 📑 Documentación Swagger

Una vez levantado el proyecto, accede a la documentación interactiva en:

