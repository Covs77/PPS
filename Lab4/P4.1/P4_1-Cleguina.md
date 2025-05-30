# Laboratorio 4. Determinación de los Niveles de Seguridad
## **Práctica 4.1. Identificación de vulnerabilidades en fuentes abiertas**

<p style="text-align:justify;">
<b>Qlik Sense</b> es una herramienta de análisis y visualización de datos de manera sencilla cuyo objetivo es convertir grandes cantidades de información en gráficos y reportes fáciles de entender. Con Qlik, cualquier usuario, incluso los no avanzados, puede explorar la información, encontrar patrones y entender tendencias sin necesidad de depender completamente de expertos en tecnología. Además, permite combinar datos de diferentes fuentes, como bases de datos, hojas de cálculo o sistemas de gestión, para tener una visión más completa y detallada de lo que está pasando en la empresa.
<br>
Su uso es habitual en áreas de ventas, finanzas o logística, donde se analizan resultados de manera rápida. Gracias a su diseño interactivo, los usuarios pueden filtrar información, hacer comparaciones y obtener respuestas sin necesidad de generar informes complicados.

##### 1. Vulnerabilidad CVE-2024-36077

- ID de CVE: CVE-2024-36077 [^1]
- Descripción: Qlik Sense Enterprise para Windows anterior a la versión 14.187.4 permite a un atacante remoto elevar sus privilegios debido a una validación incorrecta. 
- Fecha de Publicación: 22 de mayo de 2024
- Impacto: Permite tomar el control del servidor donde se ejecuta Qlik Sense pudiendose ejecutar comandos o programas a distancia.
- Vectores de Ataque: Validación incorrecta. El desarrollador no facilita el vector de ataque concreto.[^2]
- Parches Disponibles: Este problema se ha corregido en mayo de 2024 (14.187.4) con los siguientes parches:
  -  Parche 4 de febrero de 2024 (14.173.8)
  -  Parche 9 de noviembre de 2023 (14.159.14)
  -  Parche 14 de agosto de 2023 (14.139.21)
  -  Parche 16 de mayo de 2023 (14.129.23)
  -  Parche 14 de febrero de 2023 (14.113.19)
  -  Parche 14 de noviembre de 2022 (14.97.19)
  -  Parche 17 de agosto de 2022 (14.78.25) 
  -  Parche 18 de mayo de 2022 (14.67.34).


##### CWE asociado
<p style="text-align:justify;">  

Esta vulnerabilidad tiene asociada la debilidad de software <b>CWE-269: Gestión inadecuada de privilegios</b>.[^3]
Se trata de un fallo en el control de acceso al sistema permitiendo obtener privilegios o asumir una identidad inadecuada a usuarios no autorizados para tal fin. 
<p style="text-align:justify;">  
Algunas de las medidas de mitigación propuestas para esta debilidad serían gestionar de forma exhaustiva los privilegios. Para ello es necesario gestionar de forma adecuada las zonas de confianza en el software. También se recomienda seguir el principio del mínimo privilegio al asignar derechos de acceso a entidades en un sistema de software, discriminando quién tiene acceso a qué recursos  y cómo puede utilizarlos.


##### Consideraciones finales

<p style="text-align:justify;">
Esta vulnerabilidad encontrada en versiones anteriores a la 14.187.4 de Qlik permite que un atacante remoto pueda elevar sus privilegios debido a una validación incorrecta. 
Si dicha elevación es hasta el rol interno del sistema, podría permitirle ejecutar comandos en el servidor lo que expondría información sensible del sistema, pudiendo ser robada, dañada o modificada. 
La gestion de privilegios es fundamental para garantizar la disponibilidad y la confidencialidad de la información, pilares básicos de la seguridad de la información.
Esta vulnerabilidad puntuada con un 8.8 según el marco regulatorio Mitre y de severidad alta, debilita la gestión de privilegios de un sistema que ejecute esta herramienta de análisis de datos. 
<p style="text-align:justify;">
Este fallo pone en riesgo la protección de la información así como la integridad de la misma, puntos clave de la seguridad de cualquier sistema que gestione información sensible.
La gestión de privilegios es fundamental para garantizar que los usuarios solo tengan acceso a las áreas y recursos necesarios para realizar sus tareas. 
El hecho de permitir a un usuario elevar privilegios puede comprometer toda la infraestructura tecnológica de una organización ya que podría permitir al atacante ejecutar código malicioso en cualquier equipo del sistema, robar información o sabotear operaciones.

<p style="text-align:justify;">
Según el proveedor esta vulnerabilidad se ve mitigada por los parches propuestos. También se recomienda tomar las siguientes medidas para reforzar la seguridad del sistema:

- Implementación de forma rigurosa de la gestión de privilegios, siguiendo el principio del mínimo privilegio, dando a cada usuario sólo los permisos estrictamente necesarios para realizar sus tareas, sin otorgarle accesos innecesarios a funciones críticas.

- Además de aplicar parches, es esencial realizar auditorías periódicas y pruebas de penetración para identificar y corregir vulnerabilidades antes de que puedan ser explotadas.

- Todos los miembros del equipo de desarrollo y operaciones deben ser capacitados sobre las mejores prácticas de seguridad, la importancia de la gestión de privilegios y la identificación de vulnerabilidades.

<p style="text-align:justify;">
Esta vulnerabilidad pone en relieve la importancia de integrar prácticas de seguridad desde el inicio del ciclo de vida del desarrollo de software. En este caso, los desarrolladores de Qlik Sense deberían haber implementado controles más estrictos sobre la asignación y validación de privilegios, asegurándose de que las tareas más sensibles solo pudieran ser ejecutadas por usuarios con los permisos apropiados.

____________

##### 2. Vulnerabilidad CVE-2024-55579

- ID de CVE: CVE-2024-55579 [^4]  [^5]
- Descripción: Un usuario sin privilegios con acceso a la red podría crear objetos de conexión que activen la ejecución de archivos EXE arbitrarios. 
- Fecha de Publicación: 09-12-2024 
- Impacto: Qlik descubrió este problema durante pruebas de seguridad internas y no se han recibido informes de que haya sido explotado maliciosamente.
- Vectores de Ataque: Ataque remoto con interacción del usuario (Phishing, enlaces maliciosos o descargas no autorizadas)
- Parches Disponibles:
  
  - Parche 10 o 11 de mayo de 2024 (ambos válidos) 
  - Parche 14 o 15 de febrero de 2024 (ambos válidos) 
  - Parche 16 o 17 de noviembre de 2023 (ambos válidos) 
  - Parche 16 o 17 de agosto de 2023 (ambos válidos) 
  - Parche 18 o 19 de mayo de 2023 (ambos válidos) 
  - Parche 15 o 16 de febrero de 2023 (ambos válidos) 


##### CWE asociado

La debilidad de software asociada a esta vulnerabilidad es la <b>CWE-863: Autorización incorrecta</b> [^6] El sistema no verifica correctamente la autorización de acceso, lo que permite a un atacante eludir restricciones y comprometer la seguridad. Esto puede provocar la exposición o modificación de datos sensibles, la elevación de privilegios, la ejecución de código malicioso y/o ataques de denegación de servicio (DoS). 
La vulnerabilidad representa un alto riesgo para la confidencialidad, integridad y disponibilidad del sistema.
<p style="text-align:justify;">
Para reducir el riesgo se recomienda: 

- Aplicar control de acceso por roles (RBAC).
- Restringir accesos indebidos a datos sensibles.
- Usar frameworks seguros como JAAS o ESAPI OWASP.
- Evitar accesos directos no autorizados en aplicaciones web.
- Configurar listas de control de acceso con "denegación por defecto".


##### Consideraciones finales
<p style="text-align:justify;">
Esta vulnerabilidad compromete la seguridad del sistema al permitir que usuarios sin privilegios ejecuten archivos EXE arbitrarios de forma remota en Qlik Sense Enterprise para Windows. 
Se trata de una explotación sencilla, que no necesita de autenticación o permisos previos donde la víctima ejecuta un archivo o enlace malicioso. 
Aunque sólo afecta al sistema donde se encuentra y no a sistemas relacionados sí que puede exponer informacion confidencial o modificar datos de forma crítica.


El fabricante no aporta otra solución más que la de aplicar los parches de seguridad proporcionados. Además, se recomienda tomar las siguientes medidas para reforzar la seguridad del sistema:

- Limitar el acceso a la red solo a usuarios autorizados.
- Reforzar las políticas de control de acceso, minimizando privilegios innecesarios.
- Capacitar a los usuarios para evitar interacciones con enlaces o archivos no verificados.

Estas medidas ayudarán a reducir el impacto de la vulnerabilidad así como la superficie de ataque expuesta a la mismta a la vez que se fortalece la seguridad del sistema frente a futuros ataques.
Esta brecha de seguridad abre la puerta a la ejecución de código malicioso o a un ataque de denegación de servicio (DoS), que podría agotar los recursos del sistema provocando la interrupción total del servicio, lo que tendría un impacto crítico para el usuario final.
Todo esto compromete gravemente la <b>integridad, confidencialidad y disponibilidad </b>del sistema, pilares clave de los principios de seguridad de la información.
Por tanto es de vital importancia realizar una gestión efectiva y eficiente de los accesos a los sistemas así como las autorizaciones y provilegios para evitar que existan estas brechas que ponen en jaque la vulnerabilidd de nuestros sistemas.

___________

##### 3. Vulnerabilidad 

- ID de CVE: CVE-2023-41266 [^7] [^8]
- Descripción: Un atacante remoto no autenticado puede crear una sesión anónima, lo que le posibilita transmitir solicitudes HTTP a puntos finales no autorizados.
- Fecha de Publicación: 29 de agosto de 2023
- Impacto: Protocolo HTTP expuesto incluso si está deshabilitado.
- Vectores de Ataque: La vulnerabilidad puede ser explotada remotamente a través de una red.
- Parches Disponibles: No se puede proporcionar ninguna mitigación. Se debe realizar una actualización lo antes posible. 
  
  - Versión de agosto de 2023
  - Parche 4 de mayo de 2023
  - Parche 8 de febrero de 2023
  - Parche 11 de noviembre de 2022
  - Parche 13 de agosto de 2022
 

##### CWE asociado


La debilidad de software asociada a esta vulnerabilidad es la <b>CWE-20: Validación de entrada incorrecta</b> [^9] 
<p style="text-align:justify;">
El producto recibe una entrada o datos, pero no valida -o lo hace incorrectamente- que la entrada tenga las propiedades necesarias para procesar los datos de forma segura y correcta.
Esto provoca que un atacante pueda crear la entrada de una forma que no espera el resto de la aplicación lo que puede causar alteraciones en el flujo de control del sistema, ejecución de código no autorizado o explotación de recursos de manera inesperada.
El impacto técnico causado por explotar esta debilidad podría ser el boqueo o consumo excesivo de recursos como CPU y memoria, lo que podría provocar un DoS o Denegación de Servicio, la exposición y modificación no autorizada de datos sensibles o incluso podría permitir ejecutar código malicioso o comandos no deseados.

Para mreducir el riesto de esta debilidad se proponen las siguientes actuaciones:

- Utilizar teorías de seguridad basadas en lenguajes formales (LangSec) para caracterizar y restringir entradas.
- Validar todas las entradas bajo la suposición de que pueden ser maliciosas.
- Reducir la superficie de ataque entendiendo todas las posibles fuentes de entrada.
- Rechazar entradas que no cumplan estrictamente con las especificaciones o transformarlas en datos válidos.
- Verificar que las comprobaciones del lado del cliente también se validen en el servidor.
- Realizar validaciones después de combinar los datos de múltiples fuentes y al interactuar entre diferentes lenguajes de programación.
- Canonizar y decodificar las entradas antes de validarlas para evitar ataques de doble decodificación.
- Asegurar la codificación consistente entre los componentes del sistema.


##### Consideraciones finales

<p style="text-align:justify;">
Una vulnerabilidad de cruce de rutas (o path traversal vulnerability) en Qlik Sense Enterprise para Windows supone que un atacante podría manipular las rutas de acceso de los archivos o directorios en el sistema. Podría modificar una solicitud de archivo para acceder a directorios fuera de los permitidos, como archivos sensibles del sistema operativo o archivos de configuración de la aplicación. Este tipo de vulnerabilidad se presenta cuando la aplicación no valida correctamente las rutas solicitadas por el usuario, lo que podría permitir a un atacante acceder a información que debería estar restringida, como archivos privados, datos de configuración. También podría permitirle ejecutar código malicioso.

Según la Agencia de Seguridad Cibernética e Infraestructura de los EE.UU. Esta vulnerabilidad está catalogada como KEV [^10] lo que significa que es una explotación activa, es decir que en la actualidad se están realizando ataques a través de esta vulnerabilidad claro indicador de la criticidad de la misma.
<p style="text-align:justify;">
El vector de ataque asociado a esta vulnerabilidad es <b>CVSS:3.1/AC:L/AV:N/A:N/C:H/I:L/PR:N/S:U/UI:N</b>. Esto indica que se trata de una vulnerabilidad de baja complejidad y fácil explotación, sin requerir condiciones difíciles de cumplir. La explotación del fallo se realiza a través de la red, permitiendo que cualquier atacante con acceso remoto pueda aprovecharla sin necesidad de interacción del usuario, autenticación previa o escalada de privilegios.
<p style="text-align:justify;">
En cuanto a su impacto, afecta únicamente al componente vulnerable, sin extenderse a otros sistemas o infraestructuras. Sin embargo, presenta un alto riesgo para la confidencialidad, ya que podría comprometer información sensible. En términos de integridad, el impacto es limitado, dado que solo permite modificaciones parciales o restringidas en los datos.
Además, se trata de una vulnerabilidad automatizable, lo que facilita su explotación masiva y aumenta significativamente el riesgo de afectación total en los sistemas vulnerables.

Para reducir la superficie de ataque el fabricante Qlik recomienda que el proxy no esté expuesto a la red pública de internet
El fabricante no proporcionar ninguna mitigación, unicamente se indica que se realice una actualización de las versiones con los parches proporcionados en la web oficial de Qlik. 

_______________________________________________________________________

<p style="text-align:justify;">
<b>PuTTy</b> es un cliente SSH y Telnet con el que podemos conectarnos a servidores remotos iniciando una sesión en ellos que nos permite ejecutar comandos. Es una herramienta que se usa para la administración de servidores remotos, acceso a servidores en la nube o para la transferencia de archivos de forma segura. También es útil para automatizar tareas a través de scripts o para solucionar o diagnosticar problemas de forma remota. Por tanto PuTTY es una herramienta fundamental para administradores de sistemas, desarrolladores, ingenieros de redes y expertos en seguridad, ya que permite gestionar, configurar y solucionar problemas en servidores y dispositivos de forma remota, segura y eficiente.

##### 1. Vulnerabilidad CVE-2024-31497

- ID de CVE: CVE-2024-31497 [^11] [^12] [^13]
- Descripción: Permite a un atacante recuperar la clave secreta NIST P-521 de un usuario mediante un ataque rápido. 
- Fecha de Publicación: 15 de abril de 2024 (actualizado: 20 de junio de 2024)
- Impacto: Robo de claves secretas 
- Vectores de Ataque: Acceso al agente SSH  del equipo comprometido
- Medidas de Mitigación:
  -   Identificación de claves vulnerables NIST P-521
  -   Revocación de claves comprometida NIST P-521
  -   Cambiar el algortimo de encriptación de las claves SSH (ECDSA o Ed25519)
  -   Actualización del software a la version 0.81 o posterior.
  
##### CWE asociado

No se ha encontrado ninguna debilidad de software asociada a esta vulnerabilidad.

##### Consideraciones finales

<p style="text-align:justify;">
En las versiones de PuTTY anteriores a la versión 0.81, se presenta una vulnerabilidad relacionada con la generación de un <b>nonce ECDSA sesgado</b>. El nonce es un número aleatorio utilizado en el proceso de firma de mensajes con el algoritmo ECDSA (Elliptic Curve Digital Signature Algorithm). La vulnerabilidad surge porque el nonce no es generado de forma completamente aleatoria, lo que significa que puede seguir un patrón predecible o repetido. Esta falta de aleatorización permite a un atacante deducir la clave privada de un usuario a partir de varias firmas, comprometiendo así la seguridad de la clave secreta NIST P-521.
El atacante puede aprovechar esta vulnerabilidad mediante un ataque rápido que, con solo aproximadamente 60 firmas, le permitiría recuperar la clave privada de la víctima. Este riesgo se incrementa en escenarios donde el atacante tiene acceso a los mensajes firmados generados por PuTTY o Pageant, ya que dichos mensajes pueden ser almacenados en repositorios públicos de Git. Estos repositorios permiten el uso de SSH para firmar confirmaciones de manera pública, lo que significa que los mensajes firmados podrían ser accesibles para cualquier persona, incluso un atacante, lo que facilita el proceso de ataque.
<p style="text-align:justify;">
El compromiso de la clave privada podría permitir al atacante acceder a cualquier servicio SSH de la víctima. Si por ejemplo la víctima administrara un software alojado en un repositorio Git, el atacante podría manipular dicho software de manera maliciosa.
<p style="text-align:justify;">
Para evitar esta vulnerabilidad se propone identificar las claves vulnerables, revocándolas y actualizándolas a algoritmos más seguros. Actualizar PuTTy a una versión segura posterior a la 0.81 tanto en el cliente como en el servidor. También es importante no compartir claves privadas en distintos servicios. Se deberá evitar el almacenamiento público de firmas SSH en repositorios públicos. Se recomienda habilitar la autenticación de dos factores (2FA) en los servicios que utilizas SSH y Git para agregar una capa más de seguridad a nuestro sistema.
<p style="text-align:justify;">
Esta vulnerabilidad pone de relieve la importancia de reforzar la seguridad en los procesos de generación de firmas, implicando la actualización del software afectado. Por ello es fundamental reforzar la gestión de claves y configuraciones de seguridad para proteger tanto la <b>confidencialidad</b> como la <b>integridad</b> de los datos en entornos de desarrollo y de producción.


_________

##### 2. Vulnerabilidad CVE-2023-48795

- ID de CVE: CVE-2023-48795 [^14]
- Descripción: Las comprobaciones de integridad de los paquetes de datos SSH no se realizan correctamente.
- Fecha de Publicación: 18 de diciembre de 2023 (actualizado: 01 de mayo de 2024)
- Impacto: Cifrado SSH débil o nulo
- Vectores de Ataque: Ataque remoto a los paquetes SSH.
- Medidas de Mitigación: 
  - Actualizar OpenSSH a la versión 9.6 o superior.
  - Actualizar productos y bibliotecas SSH afectados.
  - Deshabilitar versiones vulnerables 
  

##### CWE asociado
No se ha encontrado ninguna debilidad de software asociada a esta vulnerabilidad.
##### Consideraciones finales

<p style="text-align:justify;">
El protocolo SSH (Secure Shell) es un sistema de comunicación segura utilizado para acceder de manera remota a servidores y otros dispositivos. Algunas implementaciones de SSH tienen extensiones que permiten realizar ciertas tareas adicionales o mejorar la seguridad, pero en versiones anteriores a la 9.6 de OpenSSH y en otros productos similares, existe una vulnerabilidad en cómo se manejan las comprobaciones de integridad de los paquetes de datos. 

Esta vulnerabilidad, conocida como el ataque Terrapin [^15] [^16], permite a un atacante eludir estas comprobaciones de seguridad. <p style="text-align:justify;">Como resultado, ciertos paquetes de datos pueden ser omitidos durante el proceso de negociación de las extensiones o <i>handshake</i> sin que el cliente o el servidor se percate, lo que hace que la conexión SSH entre ambos no use ciertas características de seguridad, dejando la conexión vulnerable. Este ataque podría utilizarse para permitir la explotación de fallos de implementación, así como ataques de phishing[^17] y Man-in-the-Middle [^18] (MitM).

<p style="text-align:justify;">
Para mitigar esta vulnerabilidad se recomienda actualizar la generación de claves a algoritmos seguros que eviten que un atacante pudiera descifrar los datos o manipularlos. Si un atacante puede manipular los paquetes, podría interceptar y modificar los datos transmitidos entre el cliente y el servidor SSH afectando gravemente a la integridad de los mismos.

______________

##### 3. Vulnerabilidad  CVE-2021-36367

- ID de CVE: CVE-2021-36367 [^19]
- Descripción: En versiones previas a la 0.75 se permite que un servidor SSH malicioso inicie sesión sin autenticación real.
- Fecha de Publicación: 9 de julio de 2021 (actualizado 25 de abril de 2024)
- Impacto: Exposición completa de información confidencial en el componente vulnerable.
- Vectores de Ataque: Esta vulnerabilidad se explota a través de la red
- Medidas de Mitigación: Actualización a la versión <b>0.74-1+deb11u1</b> [^20]
  
##### CWE asociado
La debilidad de software asociada es la <b>CWE-345:Verificación insuficiente de la autenticidad de los datos</b> [^21]
<p style="text-align:justify;">
Se trata de un error de validación de origen lo que significa que el producto no verifica suficientemente el origen o la autenticidad de los datos, de manera que acepta datos no válidos.
En el caso de esta vulnerabilidad, PuTTY no verifica adecuadamente la autenticidad del servidor SSH antes de permitir el establecimiento de una sesión. Esto permite que un servidor controlado por un atacante manipule el proceso de autenticación, facilitando ataques de phishing.


##### Consideraciones finales

<p style="text-align:justify;">
Esta vulnerabilidad afecta a PuTTY hasta la versión 0.75. El problema se basa en que el cliente establece una sesión SSH incluso si nunca ha enviado una respuesta de autenticación. Esto permite que un servidor SSH malicioso manipule el proceso de autenticación para presentar un mensaje falsificado con el fin de capturar credenciales del usuario y utilizarlas con fines malintencionados lo que implica que un atacante que controle un servidor SSH malicioso podría engañar al usuario para que ingrese credenciales que posteriormente podrían ser utilizadas para acceder a sistemas críticos.
<p style="text-align:justify;">
El vector de ataque de esta vulnerabilidad es el <b>CVSS:3.1/AV:N/AC:L/PR:N/UI:R/S:U/C:H/I:H/A:N</b> con puntaje de 8.1 y severidad alta. Lo que indica que se permite un ataque remoto sin necesidad de acceso físico ni autenticación previa. Su explotación no requiere configuraciones especiales, pero sí la interacción del usuario al intentar autenticarse en un servidor malicioso. El impacto se limita al sistema afectado, comprometiendo gravemente la <b>confidencialidad</b> al permitir la captura de credenciales y la <b>integridad</b> al posibilitar la manipulación de la sesión SSH, aunque no afecta la disponibilidad del sistema.

<p style="text-align:justify;">
Algunas medidas de mitigación son:

- Actualizar PuTTY a una versión posterior a la 0.75.
- Verificación Estricta de Servidores SSH, Utilizar listas blancas de servidores SSH de confianza.
- Implementar autenticación basada en claves en lugar de contraseñas para evitar la intercepción de credenciales.
- Implementar herramientas de detección de amenazas que alerten sobre conexiones SSH a servidores no autorizados.
- Monitorear logs de acceso SSH en busca de actividad sospechosa.
- Capacitar a los usuarios sobre ataques de phishing en entornos SSH.
- Evitar conexiones a servidores SSH desconocidos o no verificados.

<p style="text-align:justify;">
Esta vulnerabilidad en PuTTY expone a los usuarios a ataques de phishing en entornos SSH al no validar correctamente el origen del servidor antes de establecer una sesión. Esto está directamente relacionado con la debilidad CWE-346, que describe la falta de validación de origen en los datos recibidos. Para mitigar el riesgo, se recomienda actualizar PuTTY, reforzar la autenticación y concienciar a los usuarios sobre amenazas en conexiones remotas.





>[^1]: https://www.cve.org/CVERecord?id=CVE-2024-36077
>[^2]: https://community.qlik.com/t5/Support-Updates/Qlik-Sense-Enterprise-for-Windows-New-Security-Patches-Available/ba-p/2452521
>[^3]: https://cwe.mitre.org/data/definitions/269.html
>[^4]: https://www.cve.org/CVERecord?id=CVE-2024-55579
>[^5]: https://community.qlik.com/t5/Official-Support-Articles/High-Security-fixes-for-Qlik-Sense-Enterprise-for-Windows-CVE/tac-p/2496004
>[^6]: https://cwe.mitre.org/data/definitions/863.html
>[^7]: https://www.cve.org/CVERecord?id=CVE-2023-41266
>[^8]: https://community.qlik.com/t5/Support-Updates/Qlik-Sense-Enterprise-for-Windows-New-Security-Patches-Available/ba-p/2108549
>[^9]: https://cwe.mitre.org/data/definitions/20.html
>[^10]: https://www.cisa.gov/known-exploited-vulnerabilities-catalog?search_api_fulltext=CVE-2023-41266
>[^11]: https://www.cve.org/CVERecord?id=CVE-2024-31497
>[^12]: https://www.openwall.com/lists/oss-security/2024/04/15/6
>[^13]: https://lists.debian.org/debian-lts-announce/2024/06/msg00014.html
>[^14]: https://www.cve.org/CVERecord?id=CVE-2023-48795
>[^15]: https://www.incibe.es/incibe-cert/alerta-temprana/avisos/multiples-vulnerabilidades-en-openssh
>[^16]: https://terrapin-attack.com/
>[^17]: Ataque de ingeniería social que busca obtener credenciales o información sensible mediante la suplantación de identidad a través de correos electrónicos, sitios web falsificados o mensajes maliciosos
>[^18]: Ataque en el que un atacante intercepta y potencialmente altera la comunicación entre dos partes sin que estas lo sepan, comprometiendo la confidencialidad e integridad de los datos transmitidos.
>[^19]: https://www.cve.org/CVERecord?id=CVE-2021-36367
>[^20]: https://www.chiark.greenend.org.uk/~sgtatham/putty/changes.html
>[^21]: https://cwe.mitre.org/data/definitions/345.html