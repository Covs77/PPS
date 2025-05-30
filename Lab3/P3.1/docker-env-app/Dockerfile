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
