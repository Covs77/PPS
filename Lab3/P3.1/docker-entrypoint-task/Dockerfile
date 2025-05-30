# Usar una imagen base de Linux ligera
FROM alpine:latest

# Instalar tar para la compresión
RUN apk add --no-cache tar bash

# Crear los directorios necesarios
RUN mkdir -p /data/input /data/output

# Copiar el script al contenedor

COPY compress.sh /bin/

RUN chmod +x /bin/compress.sh


# Hacer que el script sea el comando predeterminado
ENTRYPOINT ["/bin/compress.sh"]
