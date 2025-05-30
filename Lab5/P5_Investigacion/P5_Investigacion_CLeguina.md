
# Investigación 

## Investigación 5.1. Inyección SQL

### 5.1.1. **Análisis de internals de SQLMap**  
   - Revisa el código fuente y la documentación de SQLMap para entender su motor de detección, la arquitectura de los plugins y cómo funcionan los **tamper scripts**.  
   - Elabora un informe que explique, paso a paso, cómo SQLMap decide qué técnica de inyección aplicar en cada fase.

### 5.1.2. **Evasión de WAFs y filtros**  
   - Selecciona tres WAF populares (p.ej. ModSecurity, AWS WAF, Cloudflare) y diseña una serie de pruebas automatizadas con SQLMap usando distintos tamper scripts.  
   - Mide la eficacia de cada script y documenta cómo cada WAF detecta o bloquea las cargas útiles. 

### 5.1.3. **Exfiltración out-of-band (OOB)**  
   - Investiga técnicas de exfiltración de datos vía DNS, HTTP y canales basados en tiempo (`time-based blind`).  
   - Implementa un laboratorio donde utilices SQLMap (o un script propio) para extraer datos de la base de datos mediante un servidor DNS controlado por ti. 

### 5.1.4. **Comparativa de técnicas de inyección**  
   - Realiza un documento comparativo de **error-based**, **union-based**, **boolean blind** y **time-based blind**, analizando ventajas, desventajas y escenarios óptimos para cada una.  
   - Incluye ejemplos concretos de payloads y resultados en distintas bases de datos (MySQL, PostgreSQL, MSSQL). 



<br><br>
### 5.1.5. **Estudio de casos reales**  
   - Investiga tres incidentes notables basados en SQLi (p.ej. TalkTalk 2015, Equifax 2017, otro reciente), describiendo la cadena de ataque, el impacto y las lecciones aprendidas. 
<p style="text-align: justify; color: blue;">
1. TalkTalk (Reino Unido, 2015) <br>

* Cadena de ataque
   - Un atacante menor de edad utilizó herramientas automáticas (como `sqlmap`) para detectar una vulnerabilidad SQLi en el sitio web.
   - El fallo estaba en un formulario que construía consultas SQL sin usar sentencias preparadas.
   - Se extrajo información directamente de la base de datos, como nombres, direcciones y datos bancarios parciales.

* Impacto
   - Más de **156.000 clientes afectados**.
   - **15.656** registros con datos bancarios comprometidos.
   - Coste total estimado: **£60 millones**.

* Lecciones aprendidas
   - Validar y sanitizar todas las entradas del usuario.
   - Usar **consultas preparadas** o **ORMs seguros**.
   - Implementar **Firewalls de Aplicaciones** y realizar **pentesting regularmente**.
   - Las inyecciones SQL son totalmente prevenibles con buenas prácticas.

---
<p style="text-align: justify; color: blue;">
2. Equifax (EE.UU., 2017)

* Cadena de ataque
   * Aunque comenzó con una vulnerabilidad en Apache Struts (`CVE-2017-5638`), los atacantes realizaron movimientos laterales y accedieron a bases de datos.
   * Se aprovecharon de la **falta de segmentación** y de controles internos débiles.
   * Los parches críticos no fueron aplicados durante meses.

* Impacto
   * **147 millones de personas** afectadas (SSNs, fechas de nacimiento, licencias, etc.).
   * **$700 millones** en multas y compensaciones.
   * Daño severo a la reputación de la empresa.

* Lecciones aprendidas
   - La gestión de parches es **crítica**.
   - Las brechas suelen ser **multifase**, y SQLi puede ser una etapa más.
   - Importancia de la **segmentación de red** y el monitoreo de bases de


---

## Investigación 5.2. Ataques a Credenciales

### 5.2.1. **Impacto del salting y peppering**  
   - Investiga cómo el uso de **salt** único por usuario dificulta ataques por rainbow tables y fuerza bruta.
   - Monte un laboratorio donde compares la velocidad de crackeo de hashes MD5 sin salt vs. con salt, y documenta la diferencia en complejidad computacional.

### 5.2.2. **Benchmark GPU vs. CPU**  
   - Contrasta el rendimiento de John the Ripper y Hashcat en CPU vs. GPU para un mismo diccionario (p.ej. rockyou).  
   - Presenta gráficas de velocidad (hashes/segundo) y análisis de coste-beneficio de desplegar clusters de GPU.

### 5.2.3. **Desarrollo de reglas de mangling y ataques híbridos**  
   - Diseña y prueba al menos cinco reglas de mangling (capitalización, sustituciones, sufijos) en John the Ripper.  
   - Mide cuántos hashes adicionales puedes romper frente a un ataque de diccionario puro. 

### 5.2.4. **Resistencia de algoritmos memory-hard**  
   - Analiza bcrypt, scrypt y Argon2: investiga cómo funcionan internamente y por qué son resistentes a ataques masivos.  
   - Crea un entorno con contraseñas cifradas usando cada algoritmo y mide el coste de crackeo con herramientas especializadas. 

### 5.2.5. **Patrones de reutilización de contraseñas**  
   - Obtén datasets de contraseñas filtradas (p.ej. RockYou, Have I Been Pwned) y analiza mediante scripts Python la **entropía** y patrones de reutilización entre usuarios.  
   - Propón recomendaciones de políticas de contraseñas basadas en tus hallazgos. 

## Investigación 5.3. Cross-Site Scripting (XSS)

### 5.3.1. **Comparativa de reflected, stored y DOM-based XSS**  
   - Documenta las diferencias de flujo de datos (“sources” y “sinks”) entre **XSS reflejado**, **almacenado** y **DOM-based**.  
   - Crea pruebas de concepto en DVWA para cada variante, anotando en qué punto falla la sanitización.

### 5.3.2. **Implementación y bypass de Content Security Policy (CSP)**  
   - Despliega una aplicación de demo y aplica una CSP estricta con **nonces** y hashes.  
   - Investiga y demuestra al menos dos técnicas de bypass conocidas de CSP (inline scripts con nonces reutilizados, eval deshabilitado, etc.). 

### 5.3.3. **Evasión de filtros según OWASP XSS Filter Evasion Cheat Sheet**  
   - Utiliza los ejemplos del cheat sheet de OWASP para construir payloads que eludan sanitizadores básicos de DVWA y Mutillidae II.  
   - Explica por qué cada payload evade el filtro y documenta las soluciones de código para mitigarlos. 

### 5.3.4. **Análisis de frameworks modernos**  
   - Estudia cómo librerías como React, Angular y Vue implementan auto-escape.  
   - Encuentra o desarrolla al menos un bypass para cada framework, detallando las condiciones necesarias. 

### 5.3.5. **Herramientas de detección y fuzzing automatizado**  
   - Evalúa al menos tres herramientas (Burp Suite, OWASP ZAP, XSStrike) en detección de XSS.  
   - Diseña un benchmark de precisión y falsos positivos, y recomienda un flujo de trabajo de pentesting que combine manual y automático. 


