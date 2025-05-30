# Laboratorio 4. Determinación de los Niveles de Seguridad
### **Práctica 4.2. Identificación de vulnerabilidades en fuentes abiertas**

<p style="text-align:justify;">
<b>Open LDAP</b> es una solución de código abierto para crear, administrar y consultar directorios LDAP. LADP es un protocolo que se utiliza para acceder y gestionar servicios de directorios, como bases de datos con información de usuarios, equipos y grupos de una red. Permite buscar, modificar, agregar y eliminar entradas en esos directorios. Se utiliza para la autenticación centralizada, es decir centralizar la gestión de usuarios y contraseñas. También para la integración de aplicaciones, la gestión de recursos así como la integración con la herramienta Active Directory para sistemas mixtos (Linux-Windows). 
En resumen es una herramienta de autenticación y gestión de identidades en redes corporativas de forma centralizada.

##### 1. Vulnerabilidad 

- ID de CVE: CVE-2025-27507 [^1] [^2]
- Descripción: Zitadel permite a los administradores desactivar el autorregistro de usuarios. [^3]
- Fecha de Publicación: 4 de marzo de 2025
- Impacto: Control total de las cuentas de usuario y exposición de la contraseña del servidor LDAP.
- Vectores de Ataque: Red
- Parches Disponibles: Se recomienda actualizar Zitadel como se indica.
  - Las versiones 2.x se corrigen en >= 2.71.0
  - Las versiones 2.70.x se corrigen en >= 2.70.1
  - Las versiones 2.69.x se corrigen en >= 2.69.4
  - Las versiones 2.68.x se corrigen en >= 2.68.4
  - Las versiones 2.67.x se corrigen en >= 2.67.8
  - Las versiones 2.66.x se corrigen en >= 2.66.11
  - Las versiones 2.65.x se corrigen en >= 2.65.6
  - Las versiones 2.64.x se corrigen en >= 2.64.5
  - Las versiones 2.63.x se corrigen en >= 2.63.8


##### CWE asociado

La debilidad de software asociada es la <b>CWE-639: Omisión de autorización mediante clave controlada por el usuario </b> [^4]

<p style="text-align:justify;">
La funcionalidad de autorización del sistema no impide que un usuario acceda a los datos de otro usuario al modificar el valor de la clave que los identifica. Esta clave, controlada por el usuario, se utiliza para recuperar y mostrar el registro correspondiente, pero el proceso de autorización no valida correctamente si el usuario tiene los derechos suficientes para acceder a esos datos, lo que permite saltarse las comprobaciones de autorización.
<p style="text-align:justify;">
Esto puede provocar la omisión de las comprobaciones de control de acceso a los datos o funcionalidades de otros usuarios; la posibilidad de escalada horizontal de privilegios, donde un usuario puede ver o modificar la información de otro; escalada vertical de privilegios si la clave controlada por el usuario es una bandera que indica el estado de administrador.

Las posibles mitigaciones propuestas son:
- Verificar que el usuario tenga los privilegios necesarios para acceder a los datos solicitados.
- Asegurarse de que la clave utilizada para buscar un registro no sea controlable por el usuario ni manipulable.
- Utilizar cifrado o firmas digitales en las claves para dificultar su adivinanza o manipulación.


##### Consideraciones finales

<p style="text-align:justify;">
ZITADEL permite la integración con LDAP y otros protocolos para ofrecer una solución moderna para gestionar identidades y el acceso a aplicaciones y recursos dentro de una organización. Dicho software permite a los administradores desactivar el autorregistro de usuarios, afectando a distintos puntos finales. La vulnerabilidad más crítica radica en la capacidad de manipular configuraciones LDAP. Los puntos finales vulnerables más críticos son:

/idps/ldap
/idps/ldap/{identificación}

<p style="text-align:justify;">
Al acceder a estos puntos finales, usuarios no autorizados podrían modificar la configuración LDAP de la instancia ZITADEL, redirigiendo todos los intentos de inicio de sesión LDAP a un servidor malicioso, tomando control efectivamente de las cuentas de usuario; exponer la contraseña del servidor LDAP original, comprometiendo potencialmente todas las cuentas de usuario.
Puntos finales vulnerables adicionales; 
<p style="text-align:justify;">
Según las métricas <b>CVSS:3.1/AV:N/AC:L/PR:H/UI:N/S:C/C:H/I:H/A:L </b> se trata de una vulnerabilidad con puntaje 9.0 y de caracter crítica, de complejidad baja, alto nivel de privilegios requeridos que pone en riesgo la <b>confidencialida e integridad </b> de la información ya que podría llegar a asumirse el control total de las cuentas de usuario así como la exposición de la contraseña del propio servidor LDAP.
<p style="text-align:justify;">
El fabricante por tanto recomienda actualizar a las versiones de Zitadel corregidas para mitigar esta vulnerabilidad. De ahí la importancia de mantener todo el software actualizado y así mitigar vulnerabilidades como esta.


----------------------------

##### 2. Vulnerabilidad CVE-2024-25976

- ID de CVE: CVE-2024-25976 [^5]
- Descripción: Permite a un atacante insertar código malicioso en una página web, el cual se ejecuta cuando un usuario visita un enlace malicioso.
- Fecha de Publicación:  29 de mayo de 2024 (actualizado:10 de junio de 2024)
- Impacto: 
- Vectores de Ataque: 
- Parches Disponibles o Medidas de mitigación: EL proveeodr proporciona un parche para solucionar esta vulnerabilidad [^6]


##### CWE asociado

La debilidad de software asociada a esta vulnerabilidad es <b>CWE-79 : Neutralización incorrecta de la entrada durante la generación de páginas web (XSS o "Cross-site Scripting")</b> [^7]

<p style="text-align:justify;">La vulnerabilidad XSS ocurre cuando una aplicación web no neutraliza adecuadamente los datos controlados por el usuario antes de incorporarlos en una página web. Esto permite que un atacante inyecte contenido malicioso, como JavaScript, que luego es ejecutado por los navegadores de los usuarios que visitan la página.
Esto puede provocar la lectura de datos de la aplicación, la ejecución de código o comandos no autorizados, engaño o redireccionamiento a sitios maliosos (phishing) o el robo de la información senible o incluso la toma de control de la cuenta de usuario.
Como medidas de mitigación se propone el uso de bibliotecas seguras para evitar la inyección de scripts, codificación adecuada de entradas externas, reducción de la superficie de ataque mediante la identificación de áreas no confiables, separación de datos y código mediante parametrización y la validación rigurosa de todas las entradas.

##### Consideraciones finales
<p style="text-align:justify;"> Cuando la autenticación LDAP está activada en la configuración, es posible obtener una ejecución reflejada de XSS mediante la creación de una URL personalizada que la víctima solo necesita abrir para ejecutar código JavaScript arbitrario en su navegador. Esto se debe a un error en el archivo login.php, donde el contenido de "$_SERVER['PHP_SELF']" se refleja en el HTML del sitio web. Por lo tanto, el atacante no necesita una cuenta válida para explotar este problema.
<p style="text-align:justify;">Este tipo de vulnerabilidad puede ser aprovechado por los atacantes para robar información sensible como cookies o credenciales de usuario, realizar acciones no autorizadas en nombre de la víctima o inyectar contenido no deseado en la página, como redirecciones maliciosas.

Las medidas de protección sugeridas antes este ataque son:
- Validar y sanear todas las entradas de los usuarios.
- Utilizar técnicas de codificación, como HTML encoding, para evitar la interpretación de código malicioso.
- Implementar políticas de seguridad como Content Security Policy (CSP).

<p style="text-align:justify;">
El fabricante propone la actualización del sw a la versión corregida para subsanar este problema. Por tanto se pone en valor la relevante importancia de mantener todos los dispositivos actualizados a las últimas versiones para evitar estas vulnerabilidades siempre que estas no afecten a la funcionalidad de nuestro sistema.


----------------------------

##### 3. Vulnerabilidad CVE-2024-23832

- ID de CVE: CVE-2024-23832 [^8] [^9]
- Descripción: Suplantación y toma de control de usuarios remotos de Mastodon.
- Fecha de Publicación: 01 de febrero de 2024 (actualizado 2 de febrero de 2024)
- Impacto: Suplantación e interceptación del tráfico vulnerable.
- Vectores de Ataque: Red
- Parches Disponibles o Medidas de mitigación: Actualización inmediata de las instancias [^10]


##### CWE asociado


La debilidad de software asociada a esta vulnerabilidad es la <b>CWE-290: Omisión de autenticación mediante suplantación de identidad o Spoofing. </b>[^11]
<p style="text-align:justify;">
Esta debilidad puede permitir que un atacante acceda a recursos a los que de otro modo no serían accesibles sin una autenticación adecuada.
Los atacantes pueden falsificar fácilmente la dirección IP de origen de los paquetes que envían, pero los paquetes de respuesta volverán a la dirección IP falsificada. Para ver los paquetes de respuesta, el atacante tiene que rastrear el tráfico entre la máquina víctima y la dirección IP falsificada. Para lograr el rastreo requerido, los atacantes normalmente intentan ubicarse en la misma subred que la máquina víctima. Los atacantes pueden eludir este requisito mediante el uso del enrutamiento de origen, pero el enrutamiento de origen está deshabilitado en gran parte de Internet en la actualidad. En resumen, la verificación de la dirección IP puede ser una parte útil de un esquema de autenticación, pero no debería ser el único factor necesario para la autenticación.
Esta vulnerabilidad está etiquetada como de uso Permitido, ya que se puede usar para el mapeo de vulnerabilidades del mundo real.

##### Consideraciones finales

Mastodon [^12] es una red social gratuita y de código abierto basada en ActivityPub [^13]. Mastodon permite la configuración de LDAP para la autenticación. <p style="text-align:justify;"> Debido a la insuficiente validación de origen en todos los Mastodon, los atacantes pueden suplantar y tomar el control de cualquier cuenta remota. 
En algunas rutas de código, las versiones vulnerables de Mastodon no verificaban correctamente las propiedades de objetos ActivityPub remotos, como publicaciones y cuentas.
Esto dio como resultado una comparación incorrecta al ingerir el objeto remoto, confiando siempre en la propiedad autoinformada del objeto obtenido, idindependientemente de dónde se encontraba realmente el objeto.
<p style="text-align:justify;">
Esta vulnerabilidad permitía a los atacantes hacerse pasar por cualquier actor remoto de ActivityPub observado desde un servidor Mastodon vulnerable, incluso si el servidor remoto no utilizaba Mastodon. Esta vulnerabilidad también se podría utilizar para sobrescribir objetos existentes, incluidos los detalles del protocolo, lo que permitiría a los atacantes interceptar más tráfico entre un servidor Mastodon vulnerable y un actor remoto de ActivityPub suplantado.

<p style="text-align:justify;">
Según las métricas basadas en CVSS se trata de una vulnerabilidad de nivel cŕitico con un puntaje de 9.4. Según su cadena vectorial <b>CVSS:3.1/AV:N/AC:L/PR:N/UI:N/S:U/C:L/I:H/A:H</b> su vector de ataque es através de la red, de complejidad baja que no requiere ni de privilegios ni de interacción del usuario. 
Por tanto tiene una baja incidencia en la confidencialidad de la información pero una alta indicencia tanto en la integridad como en la disponibildad de la misma.


----------------------------

<p style="text-align:justify;">
<b>Power Shell</b> es un intérprete de comandos y un lenguaje de scripting desarrollado por Microsoft para automatizar tareas y configurar sistemas en plataformas Windows. PowerShell es mucho más poderoso y flexible que la tradicional consola de comandos (CMD), ya que está diseñado para manejar tanto tareas administrativas como la automatización de flujos de trabajo complejos. Se usa para la gestión de servicios del sistema, la gestión de usuarios, la automatización de tareas así como para la gestión de redes. La ventaja de su uso radica en la felxibiilidad para ejecutar tareas sencillas o complejas mediantes scripts; permite manipular datos y objetos directamente, permite gestionar sistemas remotos de forma sencilla y es ampliable mediante módulos para personalizar su funcionalidad.


##### 1. Vulnerabilidad CVE-2024-6055


- ID de CVE: CVE-2024-6055 [^14] [^15]
- Descripción:
- Fecha de Publicación: 17 de junio de 2024
- Impacto: 
- Vectores de Ataque: 
- Medidas de mitigación: Actualización a la versión corregida 2024.2.8.0 o superior


##### CWE asociado

CWE-212 : CWE-212 Eliminación indebida de información confidencial antes del almacenamiento o la transferencia [^16]
<p style="text-align:justify;">
El producto almacena, transfiere o comparte un recurso que contiene información confidencial, pero no elimina adecuadamente dicha información antes de que el producto ponga el recurso a disposición de actores no autorizados. Los recursos que pueden contener datos confidenciales incluyen documentos, paquetes, mensajes, bases de datos, etc. Si bien estos datos pueden ser útiles para un usuario individual o un pequeño grupo de usuarios que comparten el recurso, es posible que sea necesario eliminarlos antes de que el recurso pueda compartirse fuera del grupo de confianza.

Las medidas de mitigación que se proponen son: 
- Especificar qué información debe considerarse privada o sensible, y exigir que el producto permita al usuario limpiar la información sensible del recurso antes de que se publique o exporte a otras partes.
- Dividir el sistema en compartimentos para tener áreas "seguras" donde se puedan establecer límites de confianza inequívocos.
- Asegurarse de que se incorpore una compartimentación adecuada en el diseño del sistema basado en el principio del mínimo privilegio para decidir el momento adecuado para utilizar privilegios y el momento de eliminarlos.
- Utilizar convenciones de nomenclatura y tipos estrictos para que sea más fácil detectar cuándo se están utilizando datos confidenciales. 
- Evitar errores relacionados con el cierre o la liberación inadecuados de recursos, que pueden dejar los datos confidenciales dentro del recurso si están en un estado incompleto.

Esta vulnerabilidad está etiquetada como de uso Permitido, ya que se puede usar para el mapeo de vulnerabilidades del mundo real.

##### Consideraciones finales
<p style="text-align:justify;">
La eliminación incorrecta de información confidencial en la función de exportación de fuente de datos en Devolutions Remote Desktop Manager 2024.1.32.0 y versiones anteriores en Windows permite que un atacante que obtenga las configuraciones exportadas recupere las credenciales de PowerShell configuradas en la fuente de datos mediante el robo del archivo de configuración.
Esto compromete la <b>confidencialidad</b> a nivel bajo lo que significa que la información podría ser parcialmente accesible para el atacante, la integridad de los mismos tampoco se vería afectada gravemente así como la disponibilidad, ya que podría afectar a la disponibilidad del sistema pero no en una medida crítica. Es importante resalta que esta vulnerabilidad no afectaría a otros componentes del sistema.
<p style="text-align:justify;">
Según el puntaje 4.7 indicado por la métrica <b>CVSS:3.1/AV:N/AC:L/PR:H/UI:N/S:U/C:L/I:L/A:L</b> se trata de una vulnerabilidad de severidad media que puede ser explotada a través de la red de forma remota. La complejidad del atacante es baja ya que no requiere de requisitos, ni habilidades avanzadas aunque sí de altos privilegios para poder explotarlas. Tampoco requiere de interactuación alguna.
<p style="text-align:justify;">
Puesto que la vulnerabilidad requiere privilegios altos la mitigación más efectiva es reducir los permisos innecesarios, aplicar parches, restringir el acceso a la red y monitorear actividades sospechosas.


----------------------------
##### 2. Vulnerabilidad CVE-2024-55956

- ID de CVE: CVE-2024-55956 [^17] 
- Descripción: Un usuario no autenticado puede importar y ejecutar comandos Bash o PowerShell arbitrarios en el sistema host aprovechando la configuración predeterminada del directorio Autorun [^18]
- Fecha de Publicación: 13 de diciembre de 2024
- Impacto: Ejecución remota de código
- Vectores de Ataque: Red
- Parches Disponible: 
  - Parche 5.8.0.24 [^19] 


##### CWE asociado

La debilidad de software asociada a esta vulnerabilidad es la <b>CWE-77: Neutralización inadecuada de elementos especiales utilizados en un comando ('Inyección de comando') </b> [^20] 
<p style="text-align:justify;">
Muchos protocolos y productos tienen su propio lenguaje de comandos personalizado. Si bien las cadenas de comandos del sistema operativo o del shell se descubren y atacan con frecuencia, es posible que los desarrolladores no se den cuenta de que estos otros lenguajes de comandos también pueden ser vulnerables a los ataques.
Si un usuario malintencionado introduce un carácter (como un punto y coma) que delimita el final de un comando y el comienzo de otro, es posible que luego pueda insertar un comando completamente nuevo y no relacionado que no estaba destinado a ejecutarse. Esto le otorga al atacante un privilegio o capacidad que de otra manera no tendría.

Las medidas de mitigación propuestas son: 
 - Usar llamadas de biblioteca en lugar de procesos externos para recrear la funcionalidad deseada.
 - Asegurarse de que todos los comandos externos llamados desde el programa se creen estáticamente.
 - Validación de entrada suponiendo que toda la información ingresada es maliciosa
 - Aplicación de políticas de tiempo de ejecución utilizando como una lista blanca para evitar el uso de cualquier comando no autorizado.
 - Asignar permisos que impidan al usuario acceder o abrir archivos privilegiados.
  
##### Consideraciones finales

<p style="text-align:justify;">
Las versiones de las aplicaciones de transferencia de ficheros <i>Cleo Harmony</i> (anterior a la versión 5.8.0.24), <i>VLTrader</i> (anterior a la versión 5.8.0.24) y <i>LexiCom</i> (anterior a la versión 5.8.0.24), administradas a través de Power Shell permiten que un usuario no autenticado pueda importar y ejecutar comandos Bash o PowerShell arbitrarios en el sistema host aprovechando la configuración predeterminada del directorio Autorun.
<p style="text-align:justify;">
La métrica <b>CVSS:3.1/AV:N/AC:L/PR:N/UI:N/S:U/C:H/I:H/A:H</b> nos indica que se trata de un ataque para el que no serequieren condiciones especiales ni conocimientos avanzados; el atacante no necesita ninguna cuenta ni permisos previos en el sistema, tampoco se requiere que el usuario realice ninguna acción (como hacer clic en un enlace o abrir un archivo). El impacto por su parte se mantiene dentro del sistema afectado y no se extiende a otros sistemas relacionados. 
Esta vulnerabilidad permite que el atacante pueda acceder de forma remota a datos sensibles del sistema afectado, así como alterar o modificar datos críticos del sistema, por tanto esta vulnerabilidad puede provocar la interrupción completa del servicio o del sistema afectado.

<p style="text-align:justify;">
Se trata de una explotación catalogada como <span style="background-color: red; color: white; padding: 2px 5px; border-radius: 3px;">KEV</span>, lo que quiere decir que actualmente está en activo y se están realizando ataques reales a través de esta vulnerabilidad. Con un puntaje de 9.8 esta vulnerabilidad queda categorizada como crítica por lo que debe ser corregida de inmediato instalando el parche proporcionado.

----------------------------

##### 3. Vulnerabilidad CVE-2024-50616

- ID de CVE: CVE-2024-50616  [^21] [^22] 
- Descripción: Las versiones 5.0.0 a 5.0.11 son vulnerables a un exploit que permite a un atacante autenticado elevar sus privilegios y ver información del trabajo.
- Fecha de Publicación: 27 de octubre de 2024
- Impacto: Elevación de privilegios.
- Vectores de Ataque: Red
- Parches Disponibles o Medidas de mitigación: No se dispone de esta información.


##### CWE asociado
No se conocen debilidades de software asociadas a esta vulnerabilidad.

##### Consideraciones finales
La plataforma de ejecución en Power Shell Ironman PowerShell Universal 5.x anterior a 5.0.12 permite que un atacante autenticado eleve sus privilegios y vea información del trabajo.
Las versiones 5.0.0 a 5.0.11 son vulnerables a un exploit que permite a un atacante autenticado elevar sus privilegios y ver información del trabajo. Dicho exploit permite a un atacante autenticado tomar el control de la plataforma a través de una vulnerabilidad en la consola de administración.

La métrica <b>CVSS:3.1/AV:N/AC:L/PR:L/UI:N/S:U/C:H/I:H/A:H</b> con puntaje 8.8 y criticidad alta determina que un atacante con privilegios bajos pueda ejecutar un ataque a través de la red, sin requerir interacción del usuario. Además, tiene un impacto alto en <b>confidencialidad, integridad y disponibilidad </b> lo que sugiere que puede provocar robo de datos, manipulación de información y caída del sistemas.

Dado que no se conocen medidas de mitigación para esta vulnerabilidad lo recomendable es establecer una fuerte política de asignación de privilegios así como de administración de usuarios para evitar la ejecución del exploit y por tanto la toma de control del sistema.


>[^1]: https://www.cve.org/CVERecord?id=CVE-2025-27507
>[^2]: https://github.com/zitadel/zitadel/security/advisories/GHSA-f3gh-529w-v32x
>[^3]: https://zitadel.com/
>[^4]: https://cwe.mitre.org/data/definitions/639.html
>[^5]: https://www.cve.org/CVERecord?id=CVE-2024-25976
>[^6]: https://github.com/HAWK-Digital-Environments/HAWKI/commit/146967f3148e92d1640ffebc21d8914e2d7fb3f1
>[^7]: https://cwe.mitre.org/data/definitions/79.html
>[^8]: https://www.cve.org/CVERecord?id=CVE-2024-23832
>[^9]: https://www.openwall.com/lists/oss-security/2024/02/02/4
>[^10]: https://github.com/mastodon/mastodon/commit/1726085db5cd73dd30953da858f9887bcc90b958
>[^11]: https://cwe.mitre.org/data/definitions/290.html
>[^12]: https://joinmastodon.org/es
>[^13]: https://activitypub.rocks/
>[^14]: https://www.cve.org/CVERecord?id=CVE-2024-6055
>[^15]: https://devolutions.net/security/advisories/DEVO-2024-0008/
>[^16]: https://cwe.mitre.org/data/definitions/212.html
>[^17]: https://www.cve.org/CVERecord?id=CVE-2024-55956
>[^18]: https://www.huntress.com/blog/threat-advisory-oh-no-cleo-cleo-software-actively-being-exploited-in-the-wild
>[^19]: https://support.cleo.com/hc/en-us/articles/28408134019735-Cleo-Product-Security-Update-CVE-2024-55956
>[^20]: https://cwe.mitre.org/data/definitions/77.html
>[^21]: https://www.cve.org/CVERecord?id=CVE-2024-50616 
>[^22]: https://docs.powershelluniversal.com/changelogs/cves#cve-tbd-10-17-2024-privilege-escalation-and-information-disclosure