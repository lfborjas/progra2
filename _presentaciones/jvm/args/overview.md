!SLIDE

#Interacción con la línea de comandos

!SLIDE bullets

* Para ejecutar un programa de java escribís `java NombreDeClase` 
* Si has usado la línea de comandos, verás que un programa puede recibir "parámetros"
* `cd C:\Users`
* En java, el usuario puede enviarle parámetros al main de un programa:
* `java ElPrograma param1 param2`
* Los separás *por espacios*

!SLIDE smbullets incremental
#¿Cómo recibir parámetros de la línea de comandos?

* Te acordás de la firma de `main`?
* `public static void main(String[] args)`
* Así es: `args` es un arreglo con cada parámetro
* de modo que: `java ElPrograma param1 param2` => `{"param1", "param2"}`
* y: `java ElPrograma "param con espacios" param` => `{"param con espacios", "param"}`


!SLIDE code small
    
    @@@java
    //Args.java
    public class Args{
        public static void main(String[] args){
            for(String param: args)
                System.out.printf("El parámetro: %s \n",
                                  param);
        }
    }

!SLIDE command small
    
    C:\Users\username> javac Args.java
    C:\Users\username> java Args hola progra2 "tengo espacios" 
    hola
    progra2
    tengo espacios

!SLIDE bullets
##Ejercicios

* Recibir cualquier cantidad de enteros de la línea de comandos 
  y encontrar el mayor y el menor
* Recibir cualquier cantidad de Strings de la línea de comandos
  y convertirlas a `Title Case` (cada palabra con mayúscula).
