  # Usar Node.js como base
   FROM node:16

   # Establecer el directorio de trabajo
   WORKDIR /usr/src/app

   # Copiar el archivo de dependencias
   COPY package.json .

   # Instalar las dependencias
   RUN npm install

   # Copiar el resto de los archivos al contenedor
   COPY . .

   # Exponer el puerto de la aplicación
   EXPOSE 3000

   # Comando de inicio
   CMD ["node", "app.js"]
