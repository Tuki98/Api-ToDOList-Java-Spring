Rutas de acceso público:

POST http://localhost:8080/auth/register
POST http://localhost:8080/auth/login 

Rutas protegidas:

POST http://localhost:8080/api/v1/demo --> Prueba para verificar correcto funcionamiento de JWT


1. Crear la bd: bd_proyectointegrador
2. Correr la aplicación en Spring
3. Registrar un usuario (http://localhost:8080/auth/register) con el siguiente modelo de JSON:

 {    
        "nombre": "Nombre",
        "apellido": "Apellido",
        "email": "email@email.com",
        "password": "123456"
}

4. Logearse (http://localhost:8080/auth/login) con el siguiente modelo de JSON:

{    
        "email": "email@email.com",
        "password": "123456"
}

5. Verificar el ingreso a la ruta protegida ingresando el Token obtenido en Postman al realizar el logeo.


____________________________________________________________________________________________________________________________________________________________________________

Configuracion de MySQL para Railway en application properties   

spring.datasource.url=jdbc:mysql://${MYSQLHOST}:${MYSQLPORT}/${MYSQLDATABASE}?useSSL=false&serverTimezone=UTC
spring.datasource.username=${MYSQLUSER}
spring.datasource.password=${MYSQLPASSWORD}


