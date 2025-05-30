FROM node:16

   WORKDIR /usr/src/app

   # Copiar el archivo package.json y app.js al contenedor
   COPY package.json .
   COPY app.js .

   # Instalar dependencias (aunque no están en el contexto)
   RUN npm install

   CMD ["node", "app.js"]
