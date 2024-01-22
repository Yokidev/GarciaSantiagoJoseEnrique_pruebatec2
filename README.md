# Aplicación de Gestión de Turnos

<p>Segundo proyecto desarrollado durante el curso de Java en HaB. El objetivo de esta prueba es evaluar tus conocimientos en Java y Java Web, incluyendo sintaxis, estructuras repetitivas, estructuras selectivas, manejo de colecciones y operaciones CRUD (Crear, Leer, Actualizar y Borrar) utilizando JPA (Java Persistence API)  para interactuar con una base de datos, JSP para interactuar con el usuario y programación funcional como complemento. </p>
<p>Para ello se ha desarrollado un proyecto web java para una aplicación de gestión de turnos de una entidad gubernamental.</p>

## Pre-requisitos 📋

_Programas y herramientas necesarias para utilizar el programa_

```
Java 17 o superior
IDE compatible con Java 17 o superior
Un gestor de bases de datos compatible con MySQL
Un contenedor de servlet como Apache Tomcat para desplegar el proyecto web
```
_Supuestos:_ <br>
De cara al usuario el id de los turnos corresponde con el nº de turno. Se ajudican automaticamente cuando se crea un nuevo turno de forma ordenada.
El usuario tiene conocimiento de su identificacion para registrarse y pedir turnos en la BBDD asi como del usuario y contraseña de la misma.
```
Usuario: root
Contraseña: ""
```

Así mismo, el administrador tiene las claves y ciertos conocimientos como el id de los usuarios y de los turnos para poder realizar modificaciones en la base de datos
```
Usuario: batman
Contraseña: nosoybrucewayne
```

## Instalación 🔧

- Descargar el proyecto o realizar un git clone.
- Importar el archivo .sql alojado en la carpeta BBDD dentro de \src\main\resources del proyecto al SGBD compatible con MySql deseado.
- Abrir el proyecto en el IDE deseado.
- Tener instalado Apache tomcat para el despliege del proyecto web

## Funcionalidades del proyecto :hammer:
La aplicación permite a los usuarios realizar distintas operaciones en funcion de si se ingresa como ciudadano o como administrador:

![index](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/df0feeec-7ba6-46cc-bad4-50ce9ed98d5a)
### Ciudadano

- `Ciudadano`: Permite registrar nuevos ciudadanos, pedir turnos y mostrar una lista de turnos en funcion de filtros.

![ciudadano](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/25775f9d-a5cb-4cc5-bf44-e7720964730d)
<br>

- `Registro de ciudadano`: Agrega un nuevo ciudadano a la base de dato, proporcionando imformacion sobre los siguientes campos: nombre, edad e identificacion.
  
![registro](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/8de4ddb7-52ee-4acd-94ce-6b94da57c9f9)
<br>

- `Registro de turno`: Agrega un nuevo turno a la base de dato, proporcionando imformacion sobre los siguientes campos: fecha, descripcion e identificacion de usuario.

![agregar turno](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/4923be31-9c75-47a1-9c28-880a5157562a)
<br>

- `Mostrar turnos`: Muestra por pantalla los turnos en funcion de los siguientes filtros: fecha y estado(todos, en espera o ya atendido).
  
![mostrarturno](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/f8745464-33fb-493f-b4aa-110631b1c31e)
![mostrar](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/0e2a639b-a08c-4761-acd2-88b3b663e25d)

### Administrador
Proporciona las herramientas para poder modificar y visualizar la BBDD.
<p>Para acceder como administrador es necesario registrarse:</p>

```
Usuario: batman
Contraseña: nosoybrucewayne
```

![login](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/dcf4ee23-2bfc-433a-a891-0e05704c05e1)

- `Mostrar ciudadanos`: Muestra todos los ciudadanos de la BBDD
  
![todos ciudadanos](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/d345f4cd-7bff-4bc3-aed6-97ac105cd063)

![ciudadanostodos](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/dacb686a-7b9b-43a1-ad85-02c7ad5d4268)


- `Actualizar ciudadanos`: Permite actualizar la informacion de un ciudadano de la base de datos.
  
![actciudadano](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/3a9e6b2a-1410-492a-ba7f-65c70803c7ae)

- `Borrar ciudadanos`: Permite eliminar el registro de un ciudadano de la base de datos.
  
![borrar ciudadano](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/10b79d42-dc89-4d92-a531-67c99c7d160c)

- `Mostrar turnos`: Muestra todos los turnos de la BBDD

![todosturnos](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/ea461efe-9299-4073-9121-82a206f98a0d)

![tablaturnos](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/ca56800d-1dd5-44cd-8d3f-5cc04787fd7e)

- `Actualizar turno`: Permite actualizar la informacion de un turno de la base de datos.
  
![actturno](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/515e1517-e43d-42bb-91a0-4591a9e8dcd8)

- `Borrar turno`: Permite eliminar el registro de un turno de la base de datos.

![borrarturno](https://github.com/Yokidev/GarciaSantiagoJoseEnrique_pruebatec2/assets/113154741/db73d3cb-f43e-4e0a-8343-944fd3e4ca3f)


## Construido con 🛠️

* [Java](https://docs.oracle.com/en/java/javase/17/docs/api/index.html) - Lenguaje utilizado, especificamente el JDK17
* [JPA](https://www.ibm.com/docs/es/was-liberty/nd?topic=liberty-java-persistence-api-jpa) - Acceso a la base de datos
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [JSP](https://docs.oracle.com/cd/E17802_01/products/products/jsp/2.1/docs/jsp-2_1-pfd2/index.html) - Manejo de Front-End con Java
* [Apache Tomcat](https://tomcat.apache.org/) - Contenedor de servlets

## Autor ✒️
* **Jose Enrique Garcia** [Yokidev](https://github.com/Yokidev)
