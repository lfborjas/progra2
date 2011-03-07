!SLIDE 
# I/O en Java 

!SLIDE bullets incremental
## ¿Qué es I/O?

* Input/Output: Escritura/Lectura
* Los programas son transformadores de *entradas* y producen *salidas*
* Varios orígenes/destinos: archivos, programas, red, bases de datos, etc.
* Las computadoras sólo entienden binario

!SLIDE 
#ins

!SLIDE 
#outs

!SLIDE smbullets incremental
##¿Qué son "streams"?

* **flujos secuenciales de bytes**: goteros de letras: sólo se puede leer una cosa a la vez,
  y hay que _consumirlos_ enteros, de principio a fin.
* Hay abstracciones que transforman los datos: archivos de texto/binarios, secuenciales/aleatorios
* **texto**: para ser leídos por humanos
* **binarios**: caracteres "crudos": para ser consumidos por programas
* **secuenciales**: sólo podés leer de principio a fin, sin saltarte.
* **aleatorios**: podés leer cualquier parte del archivo en cualquier orden.
* Pero todas, en el fondo, son lo mismo: sólo se puede leer/escribir secuencialmente

!SLIDE bullets
##¿Qué hay dentro de un stream?

* Unos y ceros
* Representados al más bajo nivel por enteros/caracteres
* Tanto enteros y caracteres ocupan cuatro bytes de espacio:

!SLIDE code

    @@@java
    int num = 97;
    char let = (char)num; //=> 'a'
    char car = 'a';
    int cif = (int)car; //=> 97

!SLIDE 

#The ascii table

!SLIDE smbullets incremental
##En java

* Subclases de `InputStream` y `OutputStream`
* `FileInputStream`/`FileOutputStream`: la más cruda, trata con enteros; terminación: `-1`
* `FileReader`/`FileWriter`: menos cruda, trata con **caracteres individuales**; terminación: `-1`
* `BufferedReader`/`PrintWriter`: podemos tratar a los archivos como texto: línea por línea; terminan con `null`
* `ObjectInputStream`/`ObjectOutputStream`: trata a los archivos como secuencias de **objetos**; terminan con `EOFException`
* **Regla de dedo**: los `algoStream` son binarios, los `algoReader` o `algoWriter` son de texto. 
* Los streams se pueden **encadenar**: usar a otros internamente: `new BufferedReader(new FileInputStream(...))`


