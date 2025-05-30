FROM php:7.0-apache
RUN docker-php-ext-install mysqli pdo pdo_mysql
RUN apt-get update && apt-get -y install libpng-dev
RUN docker-php-ext-install gd

WORKDIR /var/www/html/DVWA
COPY ./DVWA/ .
RUN chmod -R 755 .
RUN chmod 777 config hackable/uploads external/phpids/0.6/lib/IDS/tmp/phpids_log.txt

EXPOSE 80
