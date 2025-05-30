FROM php:7.0-apache
RUN docker-php-ext-install mysqli

WORKDIR /var/www/html/bWAPP
COPY ./bWAPPv2.2/bWAPP .
RUN chmod -R 755 .
RUN chmod 777 passwords images documents 
RUN sed -i s/deb.debian.org/archive.debian.org/g /etc/apt/sources.list
RUN sed -i 's|security.debian.org|archive.debian.org|g' /etc/apt/sources.list 
RUN sed -i '/stretch-updates/d' /etc/apt/sources.list

EXPOSE 80
