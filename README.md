# TrabajoSpringBootValentino (H2 local)

Proyecto Spring Boot de ejemplo (API REST Cursos - Profesores - Estudiantes)
Configurado para usar **H2** en modo local (archivo en disco) y con datos de ejemplo que se insertan al arrancar.

## Requisitos
- Java 17
- Maven

## Instrucciones
1. Descomprimí el ZIP y abrí la carpeta del proyecto.
2. Compilar y correr la app:
   ```
   mvn clean package
   mvn spring-boot:run
   ```
   La aplicación arrancará en `http://localhost:8080`.

3. Acceder a la consola H2 (opcional, para ver la base de datos en un navegador):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:file:./data/cursosdb`
   - User: `sa`
   - Password: (dejar vacío)

Endpoints principales:
- `GET /api/cursos`
- `POST /api/cursos` (crear con body {"nombre":"...","profesorNombre":"...","profesorEmail":"..."})
- `POST /api/cursos/{id}/asignar-estudiantes` (body {"estudianteIds":[1,2]})
- `GET /api/estudiantes/{id}/cursos`

Datos de ejemplo: se crean un profesor, dos estudiantes y un curso con ambos estudiantes al iniciar la app.

Notes:
- The H2 database will be saved in the `data/` folder. To reset the DB, delete that folder.
