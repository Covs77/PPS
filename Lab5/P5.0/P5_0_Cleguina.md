# Laboratorio 5. Vulnerabilidades Web
## Covadonga Leguina Roig


## PRÁCTICA 5.0

*RFI PoC*

 ◼ Vamos a probar a incluir una reverse shell en Mutillidae II.
 
 - Descargamos el repositorio desde GitHub: https://github.com/pentestmonkey/php-reverse-shell 
 - Importante cambiar la extensión de la shell de .php a .txt → si es un .php la shell se estaría interpretando para nuestra máquina y no para el servidor web.
 - Modificamos IP y puerto dentro del código de la shell para que se conecte con nuestra máquina Kali Linux.
 - Levantamos un servidor web en Kali Linux con el comando service  apache2 start y copiamos la shell a /var/www/html.
 - Dejamos Netcat a la escucha en el puerto 1234 con el comando nc-nlvp 1234.
 - Realizamos la inclusión remota de la shell en Mutillidae II.
 - Tenemos acceso al servidor desde Kali Linux bajo el usuario www data!

<p style="text-align: justify; color: blue;">
En este ejercicio vamos a demostrar que el servidor Mutillidae II es vulnerable a la inclusión de ficheros remotos o RFI.<br>
Para ello necesitamos una máquina atacante Kali y la Mutillidae II, que será la víctima.

<p style="text-align: justify; color: blue;">
Desde la Kali atacante y descargo el fichero malicioso <b>php-reverse-shell.php</b> indicado en el enlace de Github: https://github.com/pentestmonkey/php-reverse-shell
 <br><br>
Levantamos la máquina vulnerable Mutillidae II con docker-compose <b>192.168.0.106:9004</b>

![P5.0](capturas/1.png)

<p style="text-align: justify; color: blue;">
En la Kali editamos el fichero malicioso con la IP atacante y el puerto que vamos a poner en escucha. Para ello cambiamos la extensión a .txt y modificamos como se muestra en la imagen y volvemos a cambiar el fichero como .php.

![P5.0](capturas/config.png)

<p style="text-align: justify; color: blue;">
Copiamos el fichero al directorio raíz de Apache /var/www/html para que sea accesible desde la víctima:

![P5.0](capturas/file.png)

<p style="text-align: justify; color: blue;">
Configuro Netcat en modo servidor escuchando por el puerto 1234 para conexiones entrantes. Comprobamos como tras ejecutar el comando indicado, se abre una shell inversa en el atacante dándonos acceso a la víctima:

![P5.0](capturas/fin.png)

<p style="text-align: justify; color: blue;">
Comando ejecutado en la víctima:

![P5.0](capturas/web.png)


<p style="text-align: justify; color: blue;">
De este modo hemos demostrado como explotar la vulnerabilidad de inclusión de archivos remotos (RFI) en la máquina vulnerable Mutillidae II para ejecutar una reverse shell desde nuestra máquina Kali atacante consiguiendo acceso no autorizado al servidor. Esto demuestra riesgo de un RFI sin una correcta sanitización de entradas. Para evitar esto deberíamos validar las entradas de usuario no permitiendo parámetros como ?file=  o ?page=, clave para evitar la inyección de código malicioso.

<p style="text-align: justify; color: blue;">
<b>Datos de las máquinas utilizadas: </b><br>
IP Anfitrión: 192.168.0.106<br>
Mutillidae II en el puerto 9004<br>
IP Kali atacante: 192.168.0.105<br>