
<h2 style="text-align:center; font-family: Arial, sans-serif; color:#333;font-size: 32px">Prueba de verificación de prácticas: Laboratorio 4
<h2 style="color:darkorange; text-align:center; font-family: Arial, sans-serif;font-size: 24px">Determinación de los Niveles de Seguridad</h2>
<p style="color:darkblue; text-align:justify; font-family: Arial, sans-serif;font-size: 24px"><b>Covadonga Leguina Roig</b></p>
<!--<p style="color:darkorange; text-align:justify; font-family: Arial, sans-serif; font-size: 22px;">Prueba de verificación de prácticas</p> -->
<p style="font-family: Arial, sans-serif; text-align:justify;">Puesta en Producción Segura. CECTI 2024/2025. <span style="color: #666;">9 de Abril de 2025</span></p>

____________



<p style="text-align:justify;font-size: 22px">
<b> Microsoft Exchange Server</b>  es un sw de carácter colaborativo integrado con Microsoft Office para la gestión y de correo electrónico, permitiendo la gestión de contactos, calendarios y tareas. 



#### 1. Vulnerabilidad de suplantación de identidad.


| ID de la vulnerabilidad | CVE-2024-49040	|
|-----------|------------------- |
| Descripción| Vulnerabilidad de suplantación de identidad. |
| Explicación | Esta vulnerabilidad permite a los atacantes eludir las protecciones establecidas para evitar la suplantación de identidad. 
| Fecha de publicación| 12 de noviembre de 2024, actualizado 30 de enero de 2025
| Impacto potencial| Suplantación de identidad, control de acceso, no repudio (no se sabe quien a hecho qué)
| Vectores de ataque:| Un atacante desde cualquier sitio de internet facilita enlaces fraudulentos a usuarios para acceder a una web que suplanta el interfaz original del sw y así conseguir información de forma fraudulenta.
| Medidas de mitigación o parches| Se recomiendan las actualizaciones de seguridad ofrecidas por Microsoft el 12 de noviembre 2024 disponibles en este enlace  https://msrc.microsoft.com/update-guide/vulnerability/CVE-2024-49040 

###### CWE asociada:
  
| ID | CWE-451|
|-----|---|
|Nombre del CWE | Representación errónea de información crítica en la interfaz de usuario (UI)
|Descripción del CWE| Un atacante modifica la interfaz de usuario para hacerle creer que los datos introducidos son erróneos o que proviene de una fuente fiable, lo que provoca que dicho usuario entroduzca datos sensibles de forma fraudulenta en el sistema. Es una técnica usada en ataques de phishing.
|¿Cómo afecta este CWE a la vulnerabilidad?| Esta vulnerabilidad puede provocar la exposición de información sensible así como la suplantación de identidad y por tanto el compromiso de la información y los datos.

  
#### 2. Vulnerabilidad de ejecución remota de código.


| ID de la vulnerabilidad | 	CVE-2024-26198|
|-----------|------------------- |
| Descripción|  Ejecución remota de código|
| Explicación |  Un atacante desde un equipo remoto ubicado en cualqui lugar de internet puede ejecutar código malicioso en un sistema. Vulnerando las medidas de seguridad establecidas.
| Fecha de publicación| 12 de marzo de 2024. Actualizado: 31 de diciembre de 2024
| Impacto potencial| Compromiso de la información, Denegación de Servicio
| Vectores de ataque:| Un atacante desde cualquier sitio de internet puede ejecutar código en el sistema vulnerando las medidas de seguridad tanto de acceso como de ejecución.
| Medidas de mitigación o parches|  El desarrollador propone realizar las actualizaciones pertienentes disponibles en el siguiente enlace: https://msrc.microsoft.com/update-guide/vulnerability/CVE-2024-26198 

###### CWE asociada:


| ID | CWE-426|
|-----|---|
|Nombre del CWE | Ruta de búsqueda no confiable
|Descripción del CWE| El sw busca recursos críticos usando una herramienta externa, obviando el control que dicho sw pueda tener sobre esos recursos. Permitiendo a los atacantes ejecutar código, acceder a archivos de datos no autorizdos o modificar la configuración del sistema. Si el atacante puede cambiar la ruta de ciertos recursos críticos, como programas, podría ejecutar código malicioso en el sw atacado.
|¿Cómo afecta este CWE a la vulnerabilidad?| Esta vulnerabilidad pone en riesgo la integridad, confidencialidad y disponibilidad de la información. Así mismo podría realizar una denegación de servicio, lo que sería crítico.

#### 3. Vulnerabilidad de elevación de privilegios

| ID de la vulnerabilidad | CVE-2024-21410	|
|-----------|------------------- |
| Descripción|  Vulnerabilidad de elevación de privilegios
| Explicación | Esta vulnerabilidad permite a los atacantes acceder de forma no autizada al sistema.
| Fecha de publicación| 13 de febrero de 2024. Actualizado: 31 de diciembre de 2024
| Impacto potencial| Afectación a la integridad, confidencialidad y disponibilidad de los datos. Permitiendo incluso que el atacante, con todos los privilegios pueda realizar cualquier actividad maliciosa, llegando a la denegación del servicio, lo que sería crítico.
| Vectores de ataque:| Desde cualquier equipo de internet se vulneran los controles de acceso que permiten a un usuario elevar sus privilegios y tomar el control de un sisteam.
| Medidas de mitigación o parches| Se trata de una vulnerabilidad catalogada como KEV, lo que indica que está siendo utulizada hoy en día. Por tanto Micrososft no dispone aun de una medida de mitigación definitiva. Propone en su web consultar la documentación para aunmentar la protección del producto así como la ejecución de un script para activar la protección extendida para la Autenticación en servidores[^1] 

###### CWE asociada:

|ID |CWE-287|
|---|---|
|Nombre del CWE | Autenticación incorrecta|
|Descripción del CWE| El Sw no comprueba si un usuario que afirma tener una identidad determinada si dicha identidad es correcta o no. |
|¿Cómo afecta este CWE a la vulnerabilidad?| Esta debilidad puede exponer los recursos y/o funcionalidades a actores no deseados, proporcionandoles información confidencialo ejecutando código de forma arbitraria.|

_____________________
<p style="text-align:justify;font-size: 22px">
<b> VSphere Client</b> Es una interfaz de usuario que permite a los administradores de sistemas acceder a la plataforma de virtualización VMware VSphere. Desde dicho interfaz se pueden crear y administrar máquinas virtuales y administrar recursos del propio host.



#### 1. CVE-2016-2078

| ID de la vulnerabilidad | CVE-2016-2078	|
|-----------|------------------- |
| Descripción|  La vulnerabilidad de secuencias de comandos entre sitios (XSS) en el cliente web de VMware vCenter Server 5.1 permite a atacantes remotos inyectar secuencias de comandos web o HTML arbitrarios a través del parámetro flashvars.
| Explicación |  Permite a los atacante inyectar código malicioso y tomar el control del producto.
| Fecha de publicación|  08-06-2016. Actualizado:09-10-2018
| Impacto potencial| Ejecución de código malicioso, denegación de servicio, control de acceso.
| Vectores de ataque:| Ejecución de código malicioso.
| Medidas de mitigación o parches| El desarrollador propone la actualización del sw.[^2]

###### CWE asociada:

|ID |CWE-79|
|---|---|
|Nombre del CWE | Neutralización incorrecta de la entrada durante la generación de la página web (Cross-site Scripting) |
|Descripción del CWE| El producto no verifica ol o hace de forma incorrecta la entrada controlable por el usuario antes de colocarla en la salida que se utiliza como una página web que se sirve a otros usuarios. |
|¿Cómo afecta este CWE a la vulnerabilidad?| Aprovechando esta debilidad se puede divulgar información privada de sesión del usuario, almacenada en las cookies. Esto puede ser especialmente peligroso si la víctima tien permisos de administrador, ya que podría comprometer todo el sistema.

#### 2. CVE-2017-4928

| ID de la vulnerabilidad | CVE-2017-4928 |
|-----------|------------------- |
| Descripción| El cliente web de vSphere basado en Flash, presenta problemas de inyección de SSRF y CRLF debido a la neutralización incorrecta de las URL. Un atacante podría explotar estos problemas enviando una solicitud POST con encabezados modificados a servicios internos, lo que podría provocar la divulgación de información.
| Explicación | El atacante modifica las peticiones http al cliente permitiendo la exposición de información relevante de forma inadecuada.
| Fecha de publicación|  17 de noviembre de 2017. Actualizado:18 de noviembre de 2017
| Impacto potencial| Denegación de servicio,  confidencialidad de los datos.
| Vectores de ataque:| Peticiones HTTP fraudulentas.
| Medidas de mitigación o parches| El desarrollador propone actualizar a versiones corregidas como indican en la web [^3]

###### CWE asociada:

|ID | CWE-352 |
|---|---|
|Nombre del CWE | Falsificación de solicitud entre sitios (CSRF)
|Descripción del CWE| La aplicación web no verifica, o no puede verificar, de manera suficiente las peticiones realizadas impidiendo controlar si se trata de una solicitud lícita o no.
|¿Cómo afecta este CWE a la vulnerabilidad?| Al no controlar las peticiones se puede exponer información crítica así como la ejecución no controlada de código. Si la víctima es un usuarios con permisos privilegiados o un administrador podría obtener el control total de la aplicación web, eliminar o robar datos.

|ID | CWE-918|
|---|---|
|Nombre del CWE | Falsificación de solicitud del lado del servidor (SSRF)
|Descripción del CWE| Los atacantes pueden simular que es el servidor quien envía la solicitud, evadiendo controles de acceso o firewalls.
|¿Cómo afecta este CWE a la vulnerabilidad?| Al simular que la solicitud proviene del servidor se compromete todo el sistema, pudiendo provocar la toma de control total del sistema.



#### 3.CVE-2021-21980

| ID de la vulnerabilidad | CVE-2021-21980	|
|-----------|------------------- |
| Descripción| El cliente web de vSphere (FLEX/Flash) presenta una vulnerabilidad de lectura arbitraria de archivos no autorizados. 
| Explicación | A través de un puerto confiable se permite la lectura de archivos no autorizados sin verificación de si el acceso es de un agente malicioso o no.
| Fecha de publicación|  24 de noviembre de 2021. Actualizado:24 de noviembre de 2021
| Impacto potencial| Integridad y confidencialidad de la información.
| Vectores de ataque:| Un agente malicioso con acceso de red al puerto 443 de vCenter Server podría explotar este problema para acceder a información confidencial.
| Medidas de mitigación o parches| Se recomiendan realizar las actualizaciones propuestas por el desarrollador.[^6]

###### CWE asociada:

|ID | CWE-22|
|---|---|
|Nombre del CWE | Limitación incorrecta de una ruta a un directorio restringido ("Recorrido de ruta")
|Descripción del CWE| Se acceden a ubicaciones restringidas utilizando comandos que dan acceso mediante la ruta relativa (../) a directorios restringidos.
|¿Cómo afecta este CWE a la vulnerabilidad?| El atacante podría crear o sobreescribir archivos críticos que se usen para ejecutar código o añadir usuarios para permitir eludir la autenticación, leer contraseñas o impedir el correcto funcionamiento del producto.





____________


### ANÁLISIS DE CVE CONCRETOS.

#### CVE-2022-22965

| ID de la vulnerabilidad |CVE-2022-22965|
|-----------|------------------- |
| Descripción| Una aplicación Spring MVC o Spring WebFlux que se ejecuta en JDK 9 o superior puede ser vulnerable a la ejecución remota de código (RCE) mediante el enlace de datos. 
| Explicación | Se manipulan los parámetros de las clases referenciadas para modificar el comportamiento del sw.
| Fecha de publicación|  1 de abril de 2022. Actualizado:25 de julio de 2022
| Impacto potencial| Ejecución remota de código, 
| Vectores de ataque:| Script malicioso
| Medidas de mitigación o parches| Se propone la actualización del Sw para mitigar esta vulnerabilidad.[^4]


###### CWE asociada:

|ID CWE| 94|
|---|---|
|Nombre del CWE | Control inadecuado de la generación de código ('Inyección de código') |
|Descripción del CWE| Al permitir inyectar código un atacante podría alterar el flujo de datos del producto. También podría afectar ala integridad de la información|
|¿Cómo afecta este CWE a la vulnerabilidad?| El cógido inyectado podría controlar la autenticación, provocando una vulnerabilidad remota; dicho código también podría acceder a recursos a los que no se podría acceder de forma directa.

_____

#### CVE-2025-31697

| ID de la vulnerabilidad |CVE-2025-31697|
|-----------|------------------- |
| Descripción| Vulnerabilidad de neutralización incorrecta de la entrada durante la generación de páginas web ('Cross-site Scripting') en Drupal Formatter Suite permite Cross-Site Scripting (XSS).
| Explicación | No se parsean corectamente las entradas lo que puede provocar secuencias de comandos en sitios cruzados (XSS) que permiten a un atacante inyectar código malicioso en un sitio web.
| Fecha de publicación|  31-03-2025. Actualizado:31-03-2025
| Impacto potencial| Control de acceso, disponibilidad de la información, ejecución de código malicioso.
| Vectores de ataque:| XSS, Secuencia de datos en sitios cruzados.
| Medidas de mitigación o parches| Se recomienda actualizar el Sw [^5]



|ID CWE|79|
|---|---|
|Nombre del CWE | Neutralización incorrecta de la entrada durante la generación de la página web (Cross-site Scripting) |
|Descripción del CWE| El producto no verifica ol o hace de forma incorrecta la entrada controlable por el usuario antes de colocarla en la salida que se utiliza como una página web que se sirve a otros usuarios. |
|¿Cómo afecta este CWE a la vulnerabilidad?| Aprovechando esta debilidad se puede divulgar información privada de sesión del usuario, almacenada en las cookies. Esto puede ser especialmente peligroso si la víctima tien permisos de administrador, ya que podría comprometer todo el sistema.
____________

___________


>Webs de referencia:
> https://www.incibe.es/incibe-cert/alerta-temprana/vulnerabilidades/cve-2024-49040 
> https://msrc.microsoft.com/update-guide/vulnerability/CVE-2024-26198
> https://msrc.microsoft.com/update-guide/vulnerability/CVE-2024-49040 
> https://msrc.microsoft.com/update-guide/vulnerability/CVE-2024-21410
> https://www.cisa.gov/known-exploited-vulnerabilities-catalog?search_api_fulltext=CVE-2024-21410
> https://www.cve.org/CVERecord?id=CVE-2021-21992
> https://support.broadcom.com/web/ecx/support-content-notification/-/external/content/SecurityAdvisories/0/23477 
> https://cwe.mitre.org/data/definitions/79.html
> https://spring.io/security/cve-2022-22965
> https://support.broadcom.com/web/ecx/support-content-notification/-/external/content/SecurityAdvisories/0/23512
> https://support.broadcom.com/web/ecx/support-content-notification/-/external/content/SecurityAdvisories/0/23617
> https://www.wetcom.com/blog/critical-updates-5/vulnerabilidad-en-vcenter-server-de-vmware-619
> https://www.cve.org/
> https://cwe.mitre.org/

[^1]: https://msrc.microsoft.com/update-guide/vulnerability/CVE-2024-21410
[^2]: https://support.broadcom.com/web/ecx/support-content-notification/-/external/content/SecurityAdvisories/0/23477
[^3]:https://support.broadcom.com/web/ecx/support-content-notification/-/external/content/SecurityAdvisories/0/23512
[^4]:https://spring.io/security/cve-2022-22965
[^5]:https://www.drupal.org/sa-contrib-2025-026
[^6]: https://support.broadcom.com/web/ecx/support-content-notification/-/external/content/SecurityAdvisories/0/23617




