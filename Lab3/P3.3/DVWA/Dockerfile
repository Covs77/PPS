FROM php:7.0-apache
RUN docker-php-ext-install mysqli pdo pdo_mysql
RUN sed -i s/deb.debian.org/archive.debian.org/g /etc/apt/sources.list
RUN sed -i 's|security.debian.org|archive.debian.org|g' /etc/apt/sources.list 
RUN sed -i '/stretch-updates/d' /etc/apt/sources.list
RUN apt-get update 
RUN apt-get -y install libpng-dev
RUN docker-php-ext-install gd

WORKDIR /var/www/html/
COPY ./DVWA/ .
RUN cp config/config.inc.php.dist config/config.inc.php
RUN chmod -R 755 .
RUN chmod 777 config hackable/uploads

EXPOSE 80
