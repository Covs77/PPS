
## Práctica 2.3. Ejercicio Práctico: Uso de Comandos de Git y Gitflow (1.5 puntos)

### Objetivo

Demuestre con ejemplos que sabe diferenciar los siguientes conceptos:
- **Resolver conflictos**
- **Fast-forward**
- **Squash**

A partir de la figura que aparece a continuación (además, la rama `master` debe mantenerse en un repositorio GitHub privado), tenéis que hacer uso de **TODOS** los comandos y las opciones más útiles, para construir el siguiente proyecto siguiendo **Gitflow** (no usar extensiones de Gitflow, únicamente los comandos explicados en clase).

![Ejercicio](/Lab2/P2.3/capturas/exercise-git-flow.png)

> **Recomendación**: Antes de comenzar, leer el [siguiente enlace](https://www.atlassian.com/es/git/tutorials/comparing-workflows/gitflow-workflow) para hacerse una idea clara de lo que se debe hacer.


### Requisitos

- **Comandos anteriores**: No es necesario evidenciar (captura, comando y explicación) los comandos del ejercicio anterior (número 1), aunque **deben ser usados** para evidenciar los comandos de este ejercicio.
- La **primera vez** que aparezca un nuevo comando, explicar claramente qué realiza.
- El alumno tiene libertad para crear el guion que crea oportuno para explicar/evidenciar esta práctica (tipo de ficheros a usar -JavaScript, PHP, etc.-, número de ficheros, etc.).
- **Evidenciar el uso del fichero `.gitignore`** con algunos archivos/directorios.
    ##### Se me ha olvidado crearlo desde el inicio y cuando lo he añadido a la rama master ya venía arrastrando el archivo .jpg que había colado para evideciar el uso de .gitignore, así que no he podido evidenciarlo como quería.
- Los **commits** deben llamarse (C1-XXxx, C2-XXxx), los **tags** (v0.1XXxx, etc.) y las **ramas** (masterXXxx, developXXxx, feature1XXxx, etc.).
    ##### He empezado poniéndolo todo como indicas, pero llegado un punto se me ha olvidado y verás que algunas ramas que están correctamente nombradas y otras no, igual con los commits. Espero que no sea importante para la evaluación. (En mi defensa diré que lo he empezado hasta 3 veces y ya estaba un poco loca...)
- Hacer uso ocasionalmente de la pestaña **Insights > Network** en GitHub para visualizar la evolución de las ramas.
- En **una o dos ocasiones**, crear un fichero vía web y actualizar el repositorio local.

    ##### Se me ha olvidado hacer esto, pero bastaría con crearlo en github y luego hacer un git pull para actualizarlo en mi repositorio local.
- Simular que las ramas **feature** son realizadas por otro programador (**Programador Nº 2** para simularlo correctamente).

- Al generar un **tag** y subirlo al repositorio remoto, compruebe que se ha creado correctamente (fichero .zip, etc.).


### Secuencia del Proyecto

Una posible secuencia del proyecto podría ser la siguiente (obtenido del libro _Git, Controle la gestión de sus versiones - Samuel Dazón_):

##### Para realizar este proyecto he creado un repositorio fuera del repo del laboratorio2 para poder llevar un mejor control a través de GitHub: https://github.com/Covs77/PPS-P2 
##### Te envié una invitación para poder acceder como colaborador.

1. **C1 (master)**: Primer commit del proyecto. Este commit añade la base del proyecto en el repositorio. _(Tag: versión v1.0.0)._
![Ejercicio](/Lab2/P2.3/capturas/1.png)
![Ejercicio](/Lab2/P2.3/capturas/2.png)
##### He creado un nuevo repositorio desde github, clonandolo para empezar de cero ya que con las modificaciones que hicimos en clase, se habían perdido archivos y la estructura de commits no era la que se pedía. Creo el primer commit, con su etiqueta y modifico el nombre de la rama master. Hago uso de los siguientes comandos:

* git add . : Añadimos todos los archivos al repo, modo stage.
* git commit -m "C1-CLeguina": Realizamos el primer commit con un mensaje descriptivo.
* git tag -a v1.0.0-CLeguina -m "v1.0.0" : Añadimos un tag/etiqueta al commit para poder identificar de forma clara las distintas modificaciones que realicemos de nuestro proyecto.
* git branch -m master-Cleguina: Con este comando cambio de nombre la rama master para personalizarla segun se especifica en los requisitos de la práctica.


2. **C2 (develop)**: Creación de la rama `develop`. Después de este commit, las dos ramas principales están creadas.

``` bash
git checkout -b develop-CLeguina
```

![Ejercicio](/Lab2/P2.3/capturas/3_0.png)
![Ejercicio](/Lab2/P2.3/capturas/3_1.png)
![Ejercicio](/Lab2/P2.3/capturas/3.png)

###### Creo la nueva rama develop y realizo un commit a la misma del archivo con el archivo fileC2.txt. Creamos y cambiamos de rama con el siguiente comando, la flag -b crea la rama si no existe.

* Con el comando checkout y la flag -b cambiamos y creamos la rama si no exite.
* Git branch para checkear las ramas que tengo creadas hasta el momento.

3. **C3 (graph_employee)**: Creación de una rama para añadir gráficos en la página de los trabajadores (creado por Programador Nº 2).
![P2_3](/Lab2/P2.3/capturas/4.png)
![P2_3](/Lab2/P2.3/capturas/5.png)

```bash
git commit --author 'Programador2 <progmm2@test.com>'  -m "C3-CLeguina"
``` 
* Creo la rama graph-employee-CLeguina y firmamos el commit con otro usuario Programador2 con la flag --author

###### En este punto comprobamos en Github que los archivos se han ido añadiendo de rama en rama:
![P2_3](/Lab2/P2.3/capturas/6.png)
4. **C4 (hotfix-negative-time)**: Creación de una rama para gestionar el caso en que un trabajador introduzca un valor negativo en una tarea.
* Cambiamos a la rama master y creamos la nueva rama hotfix (Me he equivocado de nombre de la rama y se llama hot en lugar de hotfix, se que le puedo cambiar el nombre pero no sabía si se iba a modificar algo de la estrucctura y he preferido dejarla con ese nombre sabiendo que no es el correcto).
* Añado un nuevo fichero y lo comiteo.
###### Compruebo que se han añadido los ficheros correctos a la nueva rama. 

![P2_3](/Lab2/P2.3/capturas/7.png)


5. **C5 (master)**: Integración del parche en la rama `master`. _(Tag: versión v1.0.1)._

* Usamos el comando git merge para integrar la rama hot-negative-time a la rama master.
* Al hacer merge se ha "perdido" la visualización de la rama hotfix-negative-time, aunque en con el comando git log puedo rastrear lo que ha pasado.

    ![P2_3](/Lab2/P2.3/capturas/8.png)

    ![P2_3](/Lab2/P2.3/capturas/7_1.png)

    ![P2_3](/Lab2/P2.3/capturas/7_2.png)


6. **C6 (develop)**: Integración del parche en la rama `develop`.

* Se me he borrado de la consola, muestro el historial de comandos.

    ![P2_3](/Lab2/P2.3/capturas/7_3.png)

    ![P2_3](/Lab2/P2.3/capturas/9.png)

7. **C7 (task_type)**: Creación de una rama para añadir el tipo de tareas.
* Creo la rama, añado un nuevo archivo y hago el commit, verifico que la rama está actualizada.

    ![P2_3](/Lab2/P2.3/capturas/10.png)

8. **C8 (graph_employee)**: Último commit de la rama `graph_employee`.

* Cambiamos de rama, realizo en commit C8.

    ![P2_3](/Lab2/P2.3/capturas/11.png)


9. **C9 (develop)**: Integración de la rama `graph_employee` en `develop`. Se elimina la rama `graph_employee`.

* Integro la rama graph-employee en develop
![P2_3](/Lab2/P2.3/capturas/12.png)

    ![P2_3](/Lab2/P2.3/capturas/13.png)

![P2_3](/Lab2/P2.3/capturas/14.png)

* Borro la rama graph-employee

```bash
git branch -d graph-employee-CLeguina
```
![P2_3](/Lab2/P2.3/capturas/15.png)

* Uso la flag **-d** para eliminar la rama, es importante no estar en esa rama y que los cambios hayan sido integrados a otra rama.

10. **C10 (task_type)**: Último commit de la rama `task_type`.

    ![P2_3](/Lab2/P2.3/capturas/16.png)

11. **C11 (develop)**: Integración de la rama `task_type` en `develop`.

* Cambio a la rama develop y hago el merge.

    ![P2_3](/Lab2/P2.3/capturas/17.png)

12. **C12 (release-V1.1)**: Creación de la rama para la versión 1.1.
``` bash
    git checkout -b release-V1.1
```

13. **C13 (export_csv)**: Creación de una rama para agregar una funcionalidad de exportar a CSV las tareas de un empleado durante un periodo.

    ![P2_3](/Lab2/P2.3/capturas/18.png)
![P2_3](/Lab2/P2.3/capturas/19.png)

* Se me ha pasado hacer el commit #13 y no existe, pero es el punto en el que se crea la rama export-csv. Solo aparece el commit C14 en esa rama.

14. **C14 (release-V1.1)**: Parche para corregir un error en el gráfico cuando el trabajador no tiene tareas.
![P2_3](/Lab2/P2.3/capturas/20.png)

15. **C15 (master)**: Integración de la versión 1.1 en la rama `master`. _(Tag: versión v1.1)._

    ![P2_3](/Lab2/P2.3/capturas/21.png)

    ![P2_3](/Lab2/P2.3/capturas/22.png)

16. **C16 (develop)**: Integración del parche de la versión 1.1 en la rama `develop`.

* Hago un merge en la rama develop de la rama release.
![P2_3](/Lab2/P2.3/capturas/23.png)


17. **C17 (export_csv)**: Último commit de la rama `export_csv`.

    ![P2_3](/Lab2/P2.3/capturas/24.png)
![P2_3](/Lab2/P2.3/capturas/25.png)


18. **C18 (develop)**: Integración de la rama `export_csv` en `develop`.

    ![P2_3](/Lab2/P2.3/capturas/26.png)
![P2_3](/Lab2/P2.3/capturas/27.png)

### Instrucciones Adicionales

1. **Muestre el estado final de las ramas creadas** con el software gratuito **SourceTree**.
* Solo he encontrado versiones para Windows y Mac de SourceTree, pero como estoy en linux, te lo muestro con Gitkraken:
![P2_3](/Lab2/P2.3/capturas/28.png)

2. **Muestre el estado final de las ramas creadas** con capturas del repositorio GitHub.
![P2_3](/Lab2/P2.3/capturas/30.png)
3. **Aspectos a evitar**: 
    - Capturas poco claras.
    - No seguir las normas de presentación.
    - Explicación desordenada (use sangrías, tabulaciones, numeración, viñetas, etc.).
    - Faltan comandos.

- **Claridad en la presentación**. Uso de sangrías, capturas concluyentes, con marcas adecuadas y concretas.
- **Explicación y uso del fichero `.gitignore`**.
- **Uso y explicación de comandos**. Adecuado uso y explicación (una vez) de los comandos: `clone`, `init`, `push`, `pull`, `commit`, `merge`, `checkout`, `branch`, `status`, `tag`.
- **Uso de `--graph`** para ver la evolución en cada commit realizado.
- **Uso de `--oneline`** para ver de forma resumida los commits realizados.
- **Capturas del repositorio**. Mínimo dos capturas del repositorio final/parcial de la evolución de las ramas mediante **SourceTree**.
- **Capturas en GitHub** . Mínimo dos capturas del repositorio final/parcial de la evolución de las ramas.
- **Originalidad en el guion** 
