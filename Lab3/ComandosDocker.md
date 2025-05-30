
## <p style="color:green"><b> COMANDOS DOCKER


<p style="color:blue; text-align:justify;"><b> 
Listado de imagenes

```bash
docker images
```

<p style="color:blue; text-align:justify;"><b>
Descargar una imagen

```bash
docker image pull nginx:alpine
```

<p style="color:blue; text-align:justify;"><b>
Ver historial de una imagen (capas):

```bash
docker image history nginx:alpine
```

<p style="color:blue; text-align:justify;"><b>
Inspeccionar una imagen:

```bash
docker image inspect nginx:alpine
```


_______

<p style="color:blue; text-align:justify;"><b> 
Listado de contendores ejecutándose y en no ejecución:

```bash
docker container ps
docker container ps -a
```

<p style="color:blue; text-align:justify;"><b>
Arrancar/parar un contenedor:

```bash
docker start nombre_contenedor
docker stop nombre_contenedor
```

<p style="color:blue; text-align:justify;"><b>Ejecutar una imagen modo interactivo (bash)

```bash
docker run -it --name=alpine-cova nginx:alpine /bin/sh
```

<p style="color:blue; text-align:justify;"><b>Ejecutar una imagen modo demonio(segundo plano):

```bash
docker run -d --name=alpine-cova-1 nginx:alpine
```

<p style="color:blue; text-align:justify;"><b>Entrar en un contenedor que se está ejecutando en modo demonio: 

```bash
docker exec -it alpine-xxxx-1 /bin/sh
```

<p style="color:blue; text-align:justify;"><b> Borrar contenedor, borrar imagen:

```bash
docker rm -f alpine-cova-1
docker rmi -f alpine-cova:tag
```

_________

<p style="color:green; font-size: 1.5em;">Redes
<p style="color:blue; text-align:justify;">Listar, crear, inspeccionar, eliminar, desconectar:

```bash
docker network ls
docker network create mi_red
docker network inspect mi_red
docker network rm mi_red
docker network disconnect red_name contenedor_name
```
<p style="color:blue; text-align:justify;"><b>Conectar un contenedor a una red:

```bash
docker run -d --name contenedor_name --network red_name nombre_imagen
docker run -d --name db --network multi_red redis
```
_____________


<p style="color:blue; text-align:justify;"><b>Exponer puertos al exterior:

```bash
docker container run -d -p 80:80 --name=alpine-xxxx nginx:alpine
```


<p style="color:blue; text-align:justify;"><b>Persistencia de datos. Volumenes:

```bash
docker container run -d -p 80:80 -v /root/dockers/web:/usr/share/nginx/html --name=alpine-xxxx nginx:alpine
```
<span style="font-size: 0.8em; color:rgb(174, 13, 248);"> demonio puertos volumen_local:volumen_contenedor nombre_contenedor  nombre_imagen</span>



__________

<p style="color:green; font-size: 1.5em;"><b>Personalizar una imagen

<p style="color:blue; text-align:justify;"><b>
Crear imagen, guardarla .tar y cargarla desde el .tar:

```bash
docker commit ubuntu-custom ubuntu-curl:1.0
docker save ubuntu-curl:1.0 > ubuntu-curl.tar
docker load --input ubuntu-curl.tar
```

<p style="color:blue; text-align:justify;"><b>
Subir la imagen a DockerHub:

```bash

docker login

---Creamos y lo personalizamos--
docker run -it --name ubuntu-info ubuntu:latest

--Creamos nueva imagen---
docker commit cleguina77/ubuntu-info:1.0

---Subimos a DockerHub---
docker push cleguina77/ubuntu-info:1.0

---descargamos de DockerHub---
docker pull cleguina77/ubuntu-info:1.0
```
_____________

<p style="color:green; font-size: 1.5em;"><b>
Construcción de imagenes con dockerfile


<p style="color:blue; text-align:justify;"><b>Dockerfile básico:

```bash
Copy code
# Usar nginx:alpine como base
FROM nginx:alpine

# Copiar el archivo index.html al directorio de contenido de nginx
COPY index.html /usr/share/nginx/html/

# Exponer el puerto 80
EXPOSE 80
```


<p style="color:blue; text-align:justify;"><b>Dockerfile integrando variables de entorno:

```bash
   # Usar la imagen base de Node.js
   FROM node:16

   # Establecer un directorio de trabajo
   WORKDIR /usr/src/app

   # Definir una variable de entorno para la URL del servicio
   ARG SERVICE_URL=http://localhost

   # Establecer la variable de entorno dentro del contenedor
   ENV SERVICE_URL=$SERVICE_URL

   # Copiar y crear un archivo de prueba que use esta variable
   COPY test-env.js .

   # Instalar dependencias (vacío aquí, pero necesario para npm init)
   RUN npm init -y

   # Ejecutar el script como punto de entrada
   CMD ["node", "test-env.js"]
```


<p style="color:blue; text-align:justify;"><b>Dockerfile con ENTRYPOINT, se ejecuta al arrancarse. Perfecto para ajecutar scripts de inicio. Automatización de procesos.

```bash
# Usar una imagen base de Linux ligera
FROM alpine:latest

# Instalar tar para la compresión
RUN apk add --no-cache tar

# Crear los directorios necesarios
RUN mkdir -p /data/input /data/output

# Copiar el script al contenedor
COPY compress.sh /usr/local/bin/compress.sh

# Hacer que el script sea el comando predeterminado
ENTRYPOINT ["/usr/local/bin/compress.sh"]
```


<p style="color:blue; text-align:justify;"><b>Crear imagen desde un Dockerfile (ojo con el punto final):

```bash
docker build <nuevo nombre imagen> .
```

<p style="color:blue; text-align:justify;"><b>Lanzar dicho contenedor:

```bash
docker run -d -p 8080:80 custom-nginx:1.0
```
__________


<p style="color:green; font-size: 1.5em;"><b>Usar en contexto remoto
<p style="color:blue; text-align:justify;"><b>Creo mi imagen personaliza y la subo a github.

```bash
    git init
   git add .
   git commit -m "Initial commit"
   git remote add origin https://github.com/Covs77/<el nombre de mi repo>.git
   git push
```
<p style="color:blue; text-align:justify;"><b>La uso de forma remota. Construyo la imagen y lanzo el contenedor:

```bash
docker build -t docker-node-app:1.0 https://github.com/tu-usuario/docker-node-app.git
docker run -d -p 3000:3000 docker-node-app:1.0
```



_______________


<p style="color:green; font-size: 1.5em;"><b>
Docker-compose
<p style="color:blue; text-align:justify;"><b>Permite ejecutar varios contenedores a la vez. Necesita el fichero de configuracion docker-compose.yml, puede levantar imagenes directamente o desde un Dockerfile. Pueden gestionar todo, redes ,volumenes... Es importante crear un ficher .env para no compartir datos sensibles (y añadirlo al dockerignore)


```bash
version: '3.7'
services:
  web:
    image: nginx:latest
    container_name: web
    ports:
      - "8080:80"
    networks:
      - app_network

  db:
    image: mysql:5.7
    container_name: db
    environment:
      MYSQL_ROOT_PASSWORD: toor
    networks:
      - app_network

networks:
  app_network:
    driver: bridge
```

iniciar servicios, inspeccionar, parar:

```bash
docker-compose up -d
docker-compose ps
docker-compose down
docker-compose down -v # para y elimina
```
<p style="color:blue; text-align:justify;"><b>
<p style="color:blue; text-align:justify;"><b>




___________________________

<p style="color:green; font-size: 1.5em;"><b>
Securización de contenedores
<p style="color:blue; text-align:justify;"><b>Habilitar Docker Content Trust:

```bash
    export DOCKER_CONTENT_TRUST=1
```
<p style="color:blue; text-align:justify;"><b>Verificamos que la imagen esté firmada

```bash
docker trust inspect --pretty <tu_usuario>/my-secure-image:1.0
```

<p style="color:blue; text-align:justify;"><b>Restricción de privilegios en contenedores:

1. Uso del flag --read-only para montar el sistema de archivos del contenedor en modo solo lectura.
2. Restricción de capacidades del kernel mediante el flag --cap-drop.
3. Uso del flag --user para ejecutar contenedores con un usuario no root.

```bash
docker run --rm -it --read-only alpine sh #solo lectura
docker run --rm -it --cap-drop=ALL alpine sh #deshabilita capacidades del kernel
docker run --rm -it --user 1000:1000 alpine sh # usuario no root
docker run --rm -it --memory=64m alpine sh # limita memoria
docker run --rm -it --memory=128m --memory-reservation=64m alpine sh #reserva y limita memoria
docker run --rm -it --cpus=0.5 alpine sh #limita uso cpu
docker stats # monitorea uso cpu
htop # comando uso de memoria y cpu del sistema
```

<p style="color:blue; text-align:justify;"><b>Para construir una imagen segura:

1. Dockerfile básico
2. Imagen base mínima
3. .dokerignore: .env .git node_modules/
4. Usuario no root o limitaciónes de kernel(memoria, cpu)

<p style="color:blue; text-align:justify;"><b>Se debe añadir al docker-compose.yml:

```bash
version: '3.7'
services:
  app:
    image: alpine
    deploy:
      resources:
        limits:
          memory: 128m
          cpus: "0.5"
        reservations:
          memory: 64m
```
________________

<p style="color:green; font-size: 1.5em;"><b>
Herramientas de securización
<p style="color:blue; text-align:justify;"><b>Docker scout. Análisis básico de vulnerabilidades. 
<br>Identificar vulnerabilidades

```bash
docker scout cves nginx:latest
docker scout cves neondatabase/dbt-pipeline:769cce6 --only-severity=critical #solo muestra cve críticas
docker scout cves nginx:latest --only-cve-id=CVE-2023-12345 #muesta ID concreto
docker scout cves your-repo/your-image:tag # un repo remoto
docker scout recommendations node:16 #muestra recomendaciones
docker scout compare --to node:16 node:18 # comparar imagenes
docker scout quickview nginx:1.23 #informe resumido
```

<p style="color:blue; text-align:justify;"><b>Trivy: Herramienta para analizar imagenes sin necesidad de descargarlas. Permite comparar pero descargando informes y haciendo diff.

```bash
 trivy image nombre_imagen:tag
  trivy fs --vuln-type os /ruta/al/contenedor #escanea las vulnerabilidades de las dependencias
```