# Laboratorio 4. Determinación de los Niveles de Seguridad
### **Práctica 4.3: Evaluación de Amenazas, Vulnerabilidades y Riesgos**  

<p style="text-align:justify;">
<b>Visual Studio Code</b> es un editor de códgio fuente gratuito y de código abierto desarrollado por Microsoft. Está diseñado para ser ligero, rápido y potente proporcionando muchas herramientas para que el desarrollo de software sea más eficiente. Se utiliza esencialmente para escribir y editar código fuente para aplicaciones y programas en múltiples lenguajes de programación compatibles. Disponde de un abanico amplio de extensiones que añaden funcionalidades adicionales. También dispone de un entorno de depuración así como de control de versiones gracias a la integración con Git además de disponer de su propia terminal de comandos integrada, muy útil para ejecutar scripts, compilar proyectos o interactuar con el sistema operativo



#### 1. Vulnerabilidad 
* ID de la vulnerabilid: CVE-2025-26631
* Descripción del fallo: Este fallo permite que un atacante, que ya tiene cierto nivel de acceso al sistema, eleve sus privilegios y obtenga un control más amplio sobre el sistema afectado. El problema radica en cómo Visual Studio Code maneja las rutas de búsqueda para encontrar recursos, como archivos ejecutables o bibliotecas de código. El producto utiliza una ruta de búsqueda que incluye directorios que podrían estar bajo el control de un atacante. Esto significa que si un atacante puede modificar uno de estos directorios, podría engañar al programa para que cargue un recurso malicioso en lugar del recurso legítimo.  Esta vulnerabilidad tiene asociadad la debilidad de software <b>CWE-427 Elemento de ruta de búsqueda no controlada</b>, que ocurre cuando un software no valida adecuadamente los directorios que forman parte de esa ruta de búsqueda, permitiendo la manipulación de la misma lo que facilita que un atacante pueda manipular la ruta de búsqueda para cargar recursos maliciosos.
* Componentes afectados: Sistema de carga de librerias y ejecutables en Visual Studio Code
* Impacto potencial: Elevación de privilegios, ejecución de código malicioso, compromiso del sistema.
* Referencias:
  * https://www.cve.org/CVERecord?id=CVE-2025-26631
  * https://cwe.mitre.org/data/definitions/427.html
  * https://msrc.microsoft.com/update-guide/vulnerability/CVE-2025-26631

_________

#### 2. Vulnerabilidad CVE-2025-24042
* ID de la vulnerabilidad: CVE-2025-24042
* Descripción del fallo: La extensión de depuración de JavaScript en Visual Studio Code presenta una vulnerabilidad que permite la elevación de privilegios. Esta vulnerabilidad tiene asociada la debilidad de software <b>CWE-284 Control de acceso inadecuado</b>, que ocurre cuando el producto, en este caso la extensión de depuración de JS, no restringe o lo hace incorrectamente, el acceso a un recurso, permitiendo que un actor no autorizado realice acciones privilegiadas. El control de acceso implica que se realice la autenticación del actor, la autorización del mismo para garantizar que realmente pueda acceder a un recurso concreto y la rendición de cuentas o el seguimiento de las actividades realizadas, comprometiendo los principios básicos de la seguridad de la información. Cuando alguno de estos mecanismos fallan los atacantes pueden comprometer la seguridad del producto, obteniendo privilegios, leyendo información confidencial, ejecutando comandos o evadiendo la detección.
  
* Componentes afectados: Extensión de depuración de JavaScript de Visual Studio Code
* Impacto potencial: Elevación de privilegios, ejecución de comandos no autorizados, exposición de información confidencial.
* Referencias:
  * https://www.cve.org/CVERecord?id=CVE-2025-24042
  * https://cwe.mitre.org/data/definitions/284.html
  * https://msrc.microsoft.com/update-guide/vulnerability/CVE-2025-24042
  * https://cwe.mitre.org/top25/archive/2022/2022_cwe_top25_supplemental.html#problematicMappingDetails


<p style="text-align:justify;">
_________________

#### 3. Vulnerabilidad 
* ID de la vulnerabilidad: CVE-2025-21176
* Descripción del fallo: Algunos productos de Microsoft como Visual Studio Code permiten la ejecución de código remoto, lo que significa que un atacante podría ejecutar código arbitrario en un sistema afectado sin necesidad de tener acceso físico o credenciales de autenticación. Eso se logra aprovechando el fallo software <b> CWE-126 Sobrelectura del búfer </b> que permite a un atacante manipular la memoria del sistema y tomar el control del proceso afectado.
  
* Componentes afectados: 
    * Microsoft Visual Studio 2017 versión 15.9 (incluye 15.0 - 15.8)
    * Microsoft Visual Studio 2019 versión 16.11 (incluye 16.0 - 16.10)
    * Microsoft Visual Studio 2022 versión 17.6, 17.8, 17.10 y 17.12
    * Actualización 3 de Microsoft Visual Studio 2015
    * .NET 8.0
    * .NET 9.0, 
    * Microsoft .NET Framework 3.5 y 4.8.1. 
    * Microsoft .NET Framework 4.8. 

* Impacto potencial: Ejecución remota de código, exposición de información sensible, denegación de servicio, corrupción de memoria.
* Referencias:
  * https://www.cve.org/CVERecord?id=CVE-2025-21176
  * https://cwe.mitre.org/data/definitions/126.html
  



| ID |Vulnerabilidad       | Amenaza Potencial          | Impacto              |
|---|-------------------|----------------------------|----------------------|
| CVE-2025-26631 | El producto utiliza una ruta de búsqueda no controlada. | Un atacante puede eludir las restricciones y acceder a datos o funcionalidades no autorizadas | Elevación de provilegios, ejecución de código malicioso o compromiso del sistema
| CVE-2025-24042 | Elevación de privilegios en la extensión de depuración de JS | Un atacante puede realizar acciones no permitidas al elevar los privilegios| Acceso a información no autorizada, ejecución de comandos no autorizados o toma de control del sistema    |
| CVE-2025-21176 | Ejecución remota de código | Un atacante puede ejecutar código malicioso, acceder a información sensible o causar corrupción de datos.  |Exposición de información sensible, corrupción de memoria o denegación de servicio.                       |