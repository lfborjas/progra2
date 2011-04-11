!SLIDE bullets

## Código infernal

* Hacé un programa que maneje una lista de N personas
  y luego calcule el promedio de sus edades y 
  determine cuántas de ellas se llaman "Karl" y son mayores de edad


!SLIDE code small

    @@@java
    //tienen que estar "sincronizados"
    int[] edades = ;
    String[] nombres;
    int acum, karls;
    for(int edad: edades)
        acum += edad;
    System.out.println(acum/edades.length);
    for(int i=0;i<edades.length;i++)
        if (edades[i] > 21 
            && nombres[i].equals("Karl"))
            karls++;
    System.out.println(karls);

        
!SLIDE bullets

* ¿Y si un arreglo se hace más pequeño/grande?
* Ah, ahora tenés que guardar apellidos
* ¡No! La mayoría de edad es a los 18
* Hacé lo mismo dentro de unos meses


!SLIDE code small

##¿No sería mejor algo así?

    @@@java
    Persona[] personas;
    int acum, karls;
    for(Persona p: personas){
        acum += p.edad;
        if(p.esMayorDeEdad() && p.seLlama("Karl"))
            karls++;
    }
    System.out.println("...");


