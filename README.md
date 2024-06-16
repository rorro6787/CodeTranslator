# Traductor a Código 3 Direcciones
Este es el proyecto final que realicé en la asignatura de procesadores de lenguajes durante mi tercer curso de ingeniería informática. Esta práctica consiste en la implementación mediante JFlex y Cup de un compilador de un pequeño lenguaje de programación, similar a C, denominado lenguaje PLX. El lenguaje PLX es una extensión del lenguaje PL que se describe como practica de la asignatura, pero en esta versión extendida se requieren algunas funciones adicionales. Se presupone que todos los elementos del lenguaje PL están presentes en el lenguaje PLX y que no se modifica su funcionamiento al incluir los nuevos elementos de esta extensión. La mayor diferencia entre PL y PLX es que en PLX se exige la declaración de variables previa. El código intermedio generado por ambos lenguajes es el mismo y el esquema de compilación también. La siguiente imagen representa un diagrama de flujo que describe el proceso de compilación y ejecución de un programa.

<p align="center">
   <br>
   <img src="https://github.com/rorro6787/rorro6787/blob/main/Images/plxc.png" width = 100%/>
</p>

## Funcionalidades del Compilador

- **Aspectos léxicos**: desde el punto de vista léxico el lenguaje PLX es igual que los lenguajes C, C++ y JAVA, y rigen las mismas reglas de ámbito de declaración de variables. PLX admite el mismo tipo de comentarios que C++. Cualquier duda que surja al implementar, y que no estuviera suficientemente clara en este enunciado debe resolverse de acuerdo con las especificaciones de estos lenguajes.
  
- **Tipos**: el lenguaje PLX tiene 4 tipos básicos correspondientes a los tipos en Java int, float, boolean y char. Cada uno de estos tipos tiene asociadas constantes, en el caso de los enteros se usará la notación decimal, en los reales la notación con punto decimal y exponente, y en los caracteres, las constantes aparecen entre comillas simples. Se utiliza también el tipo compuesto String, cuyas constantes son secuencias de caracteres entre comillas dobles, al igual que en Java. Se pueden definir asimismo matrices unidimensionales de cualquiera de los tipos simples anteriores, siendo las matrices de caracteres equivalentes al tipo String.
- **Declaración de variables**: para poder usar variables es necesario declararlas, asignándoles un tipo. Los identificadores de las variables se componen (al igual que en Java) de caracteres alfanuméricos, comenzando por un carácter no numérico. En una misma línea se pueden declarar varias variables, separándolas por comas, y opcionalmente se les puede asignar un valor inicial. Si una variable no se inicializa se considera que su valor es cero (o el equivalente según el tipo).
- **Expresiones aritméticas**: se incluyen en el lenguaje expresiones aritméticas con los cuatro operadores de suma, resta, multiplicación y división. La operación que se traduzca a nivel de código intermedio dependerá del tipo de la expresión, pudiendo interoperar tanto números enteros como números reales, realizando conversiones implícitas o explícitas entre enteros y reales en caso necesario. La operación de suma aplicada a dos caracteres implica la concatenación de ambos (como en Java) dando lugar a un objeto de tipo String.
- **Condiciones**: las condiciones resultan de la aplicación de operadores relacionales (igual, distinto, menor, mayor, menor que, etc.) entre dos expresiones. Las condiciones se pueden componer mediante los operadores lógicos de conjunción, disyunción y negación. (&&, || y  !) realizando evaluaciones en cortocircuito.
- **Sentencia de salida**: la única sentencia de salida es la instrucción print, que puede aplicarse a cualquiera de los tipos del lenguaje PLX. El código generado será diferente según el tipo.
- **Sentencias de control**: el núcleo del lenguaje dispondrá de sentencias de asignación, y de las sentencias de control if-else, while, do-while y for, con la misma semántica que en el lenguaje Java. Las sentencias de control pueden anidarse indistintamente unas sobre otras.
- **Detección de errores**: el compilador no incorpora la recuperación de fallos, de manera que detiene su ejecución al encontrar la primera instrucción incorrecta, ya sea en el análisis léxico, sintáctico o semántico. En estos casos basta con que la salida contenga la instrucción “error”, no siendo necesario indicar la causa.

## Código 3 Direcciones

El código objeto CTD implementa una maquina abstracta con infinitos registros a los que se accede mediante variables.  Todas las variables se considera que están previamente definidas y que su valor inicial es 0. No se diferencia entre números enteros y reales, salvo para realizar operaciones. El conjunto de instrucciones del código intermedio, y su semántica son las siguientes: 
<p align="center">
   <br>
   <img src="https://github.com/rorro6787/rorro6787/blob/main/Images/codigo%C3%A7.png" width = 100%/>
</p>

## Uso
Antes que nada, es necesario configurar el entorno "CUP" y "JFLEX". Para ello, seguiendo los mismos pasos que en esta WEB https://www2.in.tum.de/repos/cup/develop/testgrammars/calc/ hacer lo siguiente:
1. Para compilar CUP, JFLEX y los ficheros JAVA con las siguientes instrucciones (cada uno debe adaptarla a las rutas de su propio ordenador):
   
   ```bash
   java -jar /Applications/cup-0.11b/java-cup-11b.jar Calculadora.cup /Applications/jflex-1.8.2/bin/jflex Calculadora.flex
   javac -cp /Applications/cup-0.11b/java-cup-11b-runtime.jar:. *.java
   java -cp /Applications/cup-0.11b/java-cup-11b-runtime.jar:. Calculadora test1.txt 
2. Para mayor comodidad, es conveniente definir localmente la variable de entorno CLASSPATH en el fichero de inicio del shell, por ejemplo en el fichero "$HOME/.profile" (Depende del shell que use cada uno) y crear en algun lugar accesible en el PATH un fichero "cup", por ejemplo, crear el fichero "/usr/local/bin/cup" con el siguiente contenido:
   
   ```bash
   export CLASSPATH=.:/Applications/cup-0.11b/java-cup-11b-runtime.jar
   java -jar /Applications/cup-0.11b/java-cup-11b.jar $@

3. Una vez configurado el paso anterior debe funcionar directamente la siguiente secuencia:
   
   ```bash
   cup Calculadora.cup
   jflex Calculadora.flex 
   javac *.java
   java Calculadora test1.txt
3. También se puede usar la macro que viene incluida en el código fuente para hacer todas las instrucciones anteriores a la vez:
   
   ```bash
   . comp.sh

4. En el src del repositorio puede encontrar también el archivo ctd que compila el código 3 direcciones resultante y nos devuelve el resultado de la compilación:
   
   ```bash
   java PLXC test1.plx tes1.ctd 
   ./ctd test1.ctd
