#webpwnized/mutillidae:www

# Start with recent version of PHP with Apache 
# https://hub.docker.com/_/php?tab=tags&page=1&ordering=last_updated&name=apache
FROM php:8.0.11-apache

# Update software packages
RUN apt-get update

# Copy the mutillidae project to Apache web files directory
WORKDIR /var/www/mutillidae
COPY ./mutillidae .

# Remove the .htaccess file since the containers will use container network security rather than htaccess access control
# RUN rm .htaccess
RUN [ -f /var/www/mutillidae/.htaccess ] && rm /var/www/mutillidae/.htaccess || echo ".htaccess no encontrado."

# Copy the TLS certificate files from mutillidae into cert directories
RUN cp configuration/https-certificate/mutillidae-selfsigned.crt /etc/ssl/certs/mutillidae-selfsigned.crt
RUN cp configuration/https-certificate/mutillidae-selfsigned.key /etc/ssl/private/mutillidae-selfsigned.key

# Copy the Apache configuration from Mutillidae into Apache conf
RUN mkdir /etc/apache2/conf/
RUN cp configuration/apache-configuration/conf/error-pages.conf /etc/apache2/conf/error-pages.conf
RUN cp configuration/apache-configuration/conf/headers.conf /etc/apache2/conf/headers.conf

RUN mkdir error-pages/
RUN cp configuration/apache-configuration/error-pages/404.html error-pages/404.html
RUN cp configuration/apache-configuration/error-pages/oops.jpg error-pages/oops.jpg

RUN cp configuration/apache-configuration/conf-available/aliases.conf /etc/apache2/conf-available/aliases.conf

RUN cp configuration/apache-configuration/sites-available/mutillidae.conf /etc/apache2/sites-available/mutillidae.conf

# Install PHP requirements used by Mutillidae II
RUN apt-get install -y libldap2-dev && docker-php-ext-install ldap
RUN docker-php-ext-install mysqli
RUN apt-get install -y libxml2-dev && docker-php-ext-install xml
RUN apt-get install -y libonig-dev && docker-php-ext-install mbstring
RUN apt-get install -y libcurl4-openssl-dev && docker-php-ext-install curl 

# Install nslookup to enable the command injection vulnerabilities
RUN apt-get install -y dnsutils

# Patch the container
RUN apt -y upgrade

# Enable Apache modules and sites
RUN a2enmod ssl
RUN a2dissite 000-default
RUN a2ensite mutillidae

# Open ports 80,443 in the container firewall
EXPOSE 80
EXPOSE 443