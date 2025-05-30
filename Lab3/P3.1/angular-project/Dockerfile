# Etapa 1: Construcción de la aplicación Angular
FROM node:18 AS builder

# Establecer el directorio de trabajo
WORKDIR /usr/src/app

# Copiar los archivos de configuración y dependencias
COPY package*.json ./
RUN npm install

# Copiar el resto del proyecto al contenedor
COPY . .

# Construir la aplicación para producción
RUN npm run build --prod

# Etapa 2: Servir la aplicación con nginx
FROM nginx:alpine

# Limpiar archivos predeterminados de nginx
RUN rm -rf /usr/share/nginx/html/*

# Copiar los archivos generados en la etapa 1
COPY --from=builder usr/src/app/dist/angular-project/browser/ /usr/share/nginx/html

# Exponer el puerto 80
EXPOSE 80

# Comando para iniciar nginx
CMD ["nginx", "-g", "daemon off;"]
