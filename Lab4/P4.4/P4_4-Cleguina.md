# Laboratorio 4. Determinación de los Niveles de Seguridad

## **Práctica 4.4: Aplicación del estándar ASVS en seguridad de aplicaciones**  

### [Enlace a la presentación de clase](https://docs.google.com/presentation/d/1VK6EPdxUydR55VyRWe-7GjmswAu4EDt--MyAit66uF8/edit?usp=sharing )

## Índice
  - [Introduccción](#introduccción)
  - [V1.4. Arquitectura de control de Acceso](#v14-arquitectura-de-control-de-acceso)
      - [CWE Asociados](#cwe-asociados)
  - [V1.9 Communications Architectural Requirements](#v19-communications-architectural-requirements)
  - [V2.1 Seguridad de las contraseñas](#v21-seguridad-de-las-contraseñas)
      - [CWE Asociados](#cwe-asociados-1)
  - [V2.6 Look-up Secret Verifier Requirements](#v26-look-up-secret-verifier-requirements)
  - [V3.5 Token-based Session Management](#v35-token-based-session-management)
  - [V5.4 Memory, String, and Unmanaged Code Requirements](#v54-memory-string-and-unmanaged-code-requirements)
  - [V5.5 Deserialization Prevention Requirements](#v55-deserialization-prevention-requirements)
  - [V8.3 Sensitive Private Data](#v83-sensitive-private-data)



__________

### Introduccción
<p style="text-align:justify;">
<b>OWASP</b> (Open Web Application Security Project) es una organización sin ánimo de lucro dedicada a mejorar la seguridad del software proporcionando recursos, herramientas y documentación de código abierto a las organizaciones, desarrolladores y profesionales de seguridad.
<p style="text-align:justify;">
Para evaluar los niveles de seguridad vamos utilizar el <i>OWASP Application Security Verification Standard (ASVS)</i> que es un estándar con una lista de requisitos y controles de seguridad para aplicaciones web, móviles y APIs. Esta guía nos proporciona un marco de trabajo para identificar vulnerabilidades y áreas de mejora en el diseño, desarrollo y despliegue de las aplicaciones analizadas. Otra de sus funcionalidades clave es servir de guía para hacer auditorías y pruebas de seguridad ya que dispone de una amplia lista de verificación que cubre todos los aspectos críticos de seguridad permitiendo estandarizar las pruebas a diferentes proyectos y organizaciones.
También es una herramienta de ayuda para cumplir las regulaciones pertinentes como la protección de datos, la seguridad en pagos con tarjetas de crédito o la protección de información sensible proporcionando un enfoque claro y estructurado en el cumplimiento de requisitos de seguridad.

Este estándar de verificación está organizado en 3 niveles de verificación (L1, L2, L3) que representan diferentes grados de rigor en la evaluación de seguridad:
* Nivel 1 (L1): Requisitos básicos de seguridad. Aplicable a aplicaciones de bajo riesgo.
* Nivel 2 (L2): Requisitos intermedios. Aplicable a la mayoría de las aplicaciones que manejan datos sensibles.
* Nivel 3 (L3): Requisitos avanzados. Aplicable a aplicaciones de alto riesgo, como sistemas financieros o gubernamentales.

<p style="text-align:justify;">
Por tanto <b>ASVS</b>, es un recurso esencial para cualquier organización que desee mejorar la seguridad de sus aplicaciones. Proporciona un marco de trabajo claro y detallado para evaluar, desarrollar y auditar la seguridad, ayudando a prevenir vulnerabilidades y cumplir con estándares de la industria. Es clave para la detección temprana de fallos o vulnerabilidades lo que supone un ahorro económico en el desarrollo del software. Su enfoque práctico, su disponibilidad gratuita y la activa comunidad global que contribuye con recursos, herramientas y actualizaciones lo convierte en un activo importante para desarrolladores, auditores y profesionales de seguridad. 

A continuación vamos a desglosar algunos de los puntos de este estándar basándonos en la versión de <b>OWASP 4.0.3 de Octubre de 2021</b>. 


____________________


### V1.4. Arquitectura de control de Acceso
<p style="text-align:justify;">
Se debe garantizar que los mecanismos de control de acceso estén correctamente diseñados e implementados para proteger los datos y recursos de una aplicación. El objetivo es asegurar que solo los usuarios autorizados puedan acceder a ciertas funcionalidades o información, evitando vulnerabilidades comunes como la falta de validación en el lado del servidor o la implementación de controles inseguros en el cliente.
Al seguir estas directrices, se evitan vulnerabilidades comunes como la evasión de controles, la falta de validación en el servidor o la implementación de mecanismos inseguros. La clave está en centralizar la lógica de control de acceso, aplicarla en puntos seguros del sistema y usar verificaciones basadas en atributos. 

##### 1.4.1. Puntos de aplicación confiables: Los controles de acceso deben aplicarse en el servidor o en componentes seguros como gateways, servidores o funciones serverless. Se evitará implementar controles de acceso en el lado del cliente, ya que pueden ser más fácilmente eludidos. lado del cliente, ya que estos pueden ser fácilmente eludidos.
* Niveles: L2, L3
* CWE: 602: Aplicación de la seguridad del lado del servidor en el lado del cliente.

##### 1.4.2. ELIMINADO
##### 1.4.3. ELIMINADO
##### 1.4.4. Control de acceso único. Verificar que la aplicación utiliza un mecanismo de control de acceso único y bien probado para acceder a datos y recursos protegidos. Todas las solicitudes deben pasar por este mecanismo único para evitar copiar y pegar o rutas alternativas inseguras.
* Niveles: L2, L3
* CWE: 284. Control de acceso inadecuado.

##### 1.4.5. Control basado en atributos o características:  En lugar de sólo verificar si un usuario tiene un rol específico, se debe validar si tiene permiso para acceder a un recurso o funcionalidad específica. Esto permite un control más preciso y reduce el riesgo de que usuarios accedan a datos o funciones que no deberían.
* Niveles: L2, L3
* CWE: 275: Problemas de permisos

#### CWE ASOCIADOS
<b>CWE: 602: Aplicación de la seguridad del lado del servidor en el lado del cliente.</b>
<p style="text-align:justify;">
El cliente (navegador, aplicación móvil, etc.) no es un entorno seguro para aplicar controles de acceso, ya que un atacante podría manipular el código o las solicitudes eludiendo los mecanismos de protección. Por eso, se recomienda que la validación se haga siempre en el servidor.

<b>CWE: 284. Control de acceso inadecuado. </b>
<p style="text-align:justify;">
No se restringe el acceso a un recurso por parte de un actor no autorizado. Se vulneran los principios de autenticación, autorización y rendición de cuentas. Para mitigarlo se deben establecer políticas robustas para la gestión de privilegios, permisos, propiedad… así como evitar errores en los requisitos de control de acceso. Dividir el sistema en áreas seguras donde establecer límites de confianza basándose en el principio del mínimo privilegio.

<b>CWE: 275: Problemas de permisos</b>
<p style="text-align:justify;">
Este tipo de vulnerabilidad ocurre cuando un sistema o aplicación no implementa correctamente las políticas de control de acceso, lo que permite que los usuarios o entidades no autorizadas accedan a recursos o realicen acciones para las que no deberían tener permisos comprometiendo la seguridad y la integridad del sistema.
Para mitigarlo es importante establecer los permisos en función del principio del mínimo privilegio, revisando periódicamente dichos permisos, estableciendo validaciones estrictas para el control de acceso, centralizarlos a través de roles para evitar configuraciones inseguras y dispersas y establecer medidas de detección de accesos sospechosos.
Esta vulnerabilidad pone de manifiesto la importancia de una correcta gestión de permisos en un sistema. Si no se gestionan adecuadamente los controles de acceso y los permisos de los usuarios, el sistema se vuelve vulnerable a una amplia variedad de ataques que pueden comprometer la seguridad.


---------------
### V1.9 Arquitectura de Comunicaciones
<p style="text-align:justify;">






---------------
### V2.1 Seguridad de las contraseñas
<p style="text-align:justify;">
Las contraseñas son uno de los métodos de autenticación más comunes. Aunque son fáciles de implementar, usadas como único factor de autenticación presentan riesgos significativos que pueden comprometer la seguridad de sistemas y datos ya que es vulnerable a filtraciones o a ataques por fuerza bruta. Por ello es recomendable que las aplicaciones hagan uso de la autenticación multifactor (MFA) y que permitan a los usuarios reutilizar tokens que ya poseen, como FIDO o U2F, o integrarse con proveedores de servicios de credenciales (CSPs) que ofrezcan MFA.
<p style="text-align:justify;">
Los Proveedores de Servicios de Credenciales (CSPs) ofrecen identidad federada para los usuarios con entidades empresariales o de redes sociales como medida de seguridad. Las organizaciones deben evaluar la integración con estas identidades existentes, considerando el perfil de riesgo asociado. Por ejemplo, una organización gubernamental no debería aceptar una identidad de redes sociales para acceder a sistemas sensibles, ya que es fácil crear identidades falsas o desechables. Por otro lado, una empresa de videojuegos podría necesitar integrarse con plataformas de redes sociales para ampliar su base de jugadores.
<p style="text-align:justify;">
La implementación de las medidas que se proponen a continuación garantiza un equilibrio entre seguridad y usabilidad en la gestión de contraseñas. Se fortalecen los controles para mitigar riesgos de ataques por credenciales comprometidas y se mejora la experiencia del usuario al facilitar el uso de contraseñas seguras sin restricciones innecesarias. Adoptar estas prácticas es clave para reducir vulnerabilidades asociadas a contraseñas débiles o mal gestionadas.

<b>2.1.1 Verificar que las contraseñas configuradas por el usuario tengan al menos 12 caracteres</b>
* Niveles: L1, L2, L3
* CWE: 521

<b>2.1.2 Verificar que se permitan contraseñas de al menos 64 caracteres y que las contraseñas de más de 128 caracteres sean rechazadas.</b>
* Niveles: L1, L2, L3
* CWE: 521

<b>2.1.3 Verificar que no se trunque la contraseña, aunque los espacios consecutivos pueden ser reemplazados por un solo espacio. </b>
* Niveles: L1, L2, L3
* CWE: 521

<b>2.1.4 Verificar que se permitan caracteres Unicode imprimibles, incluidos los caracteres neutrales del idioma como espacios y Emojis.</b>
* Niveles: L1, L2, L3
* CWE: 521

<b>2.1.5 Verificar que los usuarios puedan cambiar su contraseña.</b>
* Niveles: L1, L2, L3
* CWE: 620

<b>2.1.6 Verificar que el cambio de contraseña requiera tanto la contraseña actual como la nueva.</b>
* Niveles: L1, L2, L3
* CWE: 620 

<b>2.1.7 Verificar que las contraseñas enviadas durante el registro, inicio de sesión o cambio de contraseña se comprueben contra una lista de contraseñas comprometidas. Si se usa una API externa, debe garantizarse que la contraseña en texto claro no se envíe.</b>
* Niveles: L1, L2, L3
* CWE: 521

<b>2.1.8 Verificar que se proporcione un medidor de fortaleza de contraseña para ayudar a los usuarios a configurar una contraseña más fuerte.</b>
* Niveles: L1, L2, L3
* CWE: 521

<b>2.1.9 Verificar que no haya reglas de composición de contraseñas que limiten los tipos de caracteres permitidos (como mayúsculas, minúsculas, números o caracteres especiales).</b>
* Niveles: L1, L2, L3
* CWE: 521

<b>2.1.10 Verificar que no se requiera rotación periódica de contraseñas ni un historial de contraseñas.</b>
* Niveles: L1, L2, L3
* CWE: 263

<b>2.1.11 Verificar que se permita la funcionalidad de "pegar", los ayudantes de contraseñas del navegador y los administradores de contraseñas externos.</b>
* Niveles: L1, L2, L3
* CWE: 521

<b>2.1.12 Verificar que el usuario pueda elegir ver temporalmente la contraseña completa enmascarada o ver temporalmente el último carácter escrito de la contraseña.</b>
* Niveles: L1, L2, L3
* CWE: 521

#### CWE ASOCIADOS

<b>CWE-521: Requisitos de contraseñas débiles </b>

<p style="text-align:justify;">
El producto no requiere que los usuarios tengan contraseñas seguras, lo que facilita que los atacantes comprometan las cuentas de usuario. Los mecanismos de autenticación suelen basarse en contraseñas para garantizar la identidad del usuario de un sistema. Por lo tanto, es importante que esta contraseña sea lo suficientemente compleja y difícil de adivinar para un atacante. Los requisitos de complejidad de una contraseña dependen del tipo de sistema que se protege. Seleccionar dichos requisitos e implementarlos es fundamental para el éxito general del mecanismo de autenticación. 
<p style="text-align:justify;">
Se recomienda definir una longitud mínima y máxima, además de establecer restricciones que eviten la reutilización de contraseñas, el uso de claves comunes o la inclusión de información contextual, como nombres de usuario o nombres de la aplicación.

<b>Mitigaciones</b>
<p style="text-align:justify;">
Fomentar el uso de frases de contraseña largas que incrementen la dificultad de descifrado. Su implementación debe considerar la facilidad de selección por parte del usuario para evitar contraseñas débiles.
La generación aleatoria de contraseñas ayuda a garantizar el cumplimiento de los requisitos de longitud y complejidad, aunque puede dificultar su memorización. La caducidad de contraseñas puede ser útil para reducir el tiempo en que una clave comprometida permanece activa.
La autenticación multifactor (MFA), evita que la contraseña sea el único punto de fallo. Se debe considerar el uso de un medidor de complejidad de contraseñas para verificar la solidez de las credenciales.

<b>CWE: 263. Caducidad de contraseñas con vencimiento prolongado</b>

<p style="text-align:justify;">
La caducidad de contraseñas obliga a los usuarios a cambiar sus contraseñas tras un periodo definido. Una caducidad prolongada proporciona más tiempo a los atacantes para descifrar las contraseñas antes de que los usuarios se vean obligados a cambiarlas.

<b>Mitigaciones</b>
<p style="text-align:justify;">
Establecer una caducidad definida, asegurando que las contraseñas no se mantengan activas por tiempo indefinido. Es recomendable notificar a los usuarios varias veces antes de que su contraseña caduque, permitiéndoles renovarla con anticipación. Deben implementarse mecanismos que impidan la reutilización de contraseñas o la creación de claves demasiado similares a anteriores. Deshabilitar la opción de pegar contraseñas desde el portapapeles, es una práctica desaconsejada, ya que puede provocar que los usuarios elijan claves más simples y fáciles de recordar, debilitando la seguridad general.

<b>CWE: 620 Cambio de contraseña no verificado</b>
<p style="text-align:justify;">
Un atacante podría cambiar las contraseñas de otro usuario y obtener los privilegios asociados a ese usuario.

<b>Mitigaciones</b>

<p style="text-align:justify;">
El usuario debe ingresar su contraseña actual junto con la nueva para prevenir cambios no autorizados y proteger los intentos de suplantación de identidad. Se recomienda evitar el uso de la función de recuperación de contraseña . Si es imprescindible implementarla, debe garantizarse que la información solo sea proporcionada al usuario legítimo, utilizando métodos previamente configurados, como una dirección de correo electrónico o una pregunta de seguridad. No se debe permitir que el usuario modifique estos datos sin antes verificar su identidad mediante la contraseña actual.


---------------

### V2.6 Look-up Secret Verifier Requirements
---------------

### V3.5 Token-based Session Management
---------------

### V5.4 Memory, String, and Unmanaged Code Requirements
---------------

### V5.5 Deserialization Prevention Requirements
---------------

### V8.3 Sensitive Private Data
