# <p style="color:grey; text-align:justify;"><b>Covadonga Leguina Roig
## <p style="color:orange; text-align:justify;"><b>Prueba de verificación de prácticas de Docker</b>
### Puesta en Producción Segura. CECTI 2024/2025
#### 19 de Febrero 2025
____________

### Ejercicio 3.

3.1 Usando Docker commit creamos una imagen basada en ubuntu:latest e instalaremos curl.

![P3](capturas/1.png)

He tenido que actualizar el sistema para podere instalar curl en el contenedor.

![P3](capturas/2.png)

Lo comiteo:

![P3](capturas/3.png)

3.2. Guardo la imagen en un fichero comprimido y lo restauro desde ahi.
Lo guardo en un fichero comprimido y borro la imagen:

![P3](capturas/4.png)

Vuelvo a cargar la imagen desde el fichero comprimido:

![P3](capturas/5.png)

3.3 Crear un fichero de información y la subimos a Dockerhub

Creamos un fichero de información en modo interactivo, creamos una imagen personalizada y la subo a Docker Hub.

![P3](capturas/7.png)
![P3](capturas/8.png)

3.4 Construcción de una imagen con Dockerfile

![P3](capturas/9.png)
![P3](capturas/10.png)
![P3](capturas/11.png)

Ejecuto el contenedor:

![P3](capturas/12.png)
![P3](capturas/13.png)