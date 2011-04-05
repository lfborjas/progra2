!SLIDE

#Java en la línea de comandos


!SLIDE bullets
#¿Por qué? 

* Para entender cómo funciona java sin la "magia" de netbeans 


!SLIDE smbullets

#En windows 7

* Ir a `Start -> Computer -> System Properties -> Advanced system settings -> Environment Variables -> System variables -> PATH`

* Buscar en `C:\Program Files\Java` el jdk, digamos que tuviera el nombre `jdk1.6.0_23`. En éste, buscar la carpeta `bin`.
* Ahora tenemos una ruta como `C:\Program Files\Java\jdk1.6.0_23\bin`
* Agregar, *al principio* de la variable `PATH`,**sin borrar nada**, la ruta de arriba *seguida de un punto y coma*:
  `C:\Program Files\Java\jdk1.6.0_23\bin;`
* Para otros windows: <http://introcs.cs.princeton.edu/15inout/windows-cmd.html>


!SLIDE 

#Probándolo

!SLIDE command small

    C:\Users\username>java -version
    java version "1.6.0_23"
    Java(TM) 2 Runtime Environment, Standard Edition (build 1.6.0_23-b07)
    Java HotSpot(TM) Client VM (build 1.6.0_23-b13, mixed mode, sharing)

!SLIDE command 

    C:\Users\username>javac -version
    javac 1.6.0_23

!SLIDE  code small

    @@@java
    /*escribir esto en el archivo Hello.java
    en la misma carpeta donde estábamos arriba*/
    public class Hello{
        public static void main(String[] args){
            System.out.println("Hello world!");
        }
    }

!SLIDE command

    C:\Users\username> javac Hello.java
    C:\Users\username> java Hello
    Hello World!


