FROM php:7.0-apache
RUN docker-php-ext-install mysqli

WORKDIR /var/www/html/bWAPP
COPY ./bWAPP .
RUN chmod -R 755 .
RUN chmod 777 passwords images documents logs

EXPOSE 80
