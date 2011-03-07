!SLIDE
#Un ejemplo de I/O

!SLIDE smbullets
#Lectura de caracteres

* Leamos un caracter
  por vez en un flujo de bytes: **es secuencial**
* Consideramos a los caracteres como enteros
* Usamos `FileInputStream` porque los datos vienen **entrando** al programa
* ¿Qué podría salir mal? `FileNotFoundException` (o `SecurityException`) e `IOException`
* **Siempre** hay que cerrar un archivo, para no corromperlo.

!SLIDE code small

    @@@java
    public static String read(String origin) throws Exception{
        StringBuilder letras = new StringBuilder();
        FileInputStream in = new FileInputStream(origin);
        int c = 0;
        while( (c = in.read() ) != -1){
                System.out.printf("Leído: %d\n", c);
                letras.append((char)c);
        }
        in.close();
        return letras.toString();
    }


!SLIDE bullets
#Escritura de caracteres

* Escribimos un caracter por pasada.
* Lo mismo que antes podría salir mal. 
* Usamos un `OutputStream` porque los datos van **de salida** del programa.

!SLIDE code small

    @@@java
    public static void write(String txt, String destination)
                                            throws Exception{
        FileOutputStream out = null;
        out = new FileOutputStream(destination);
        for(char c : txt.toCharArray()){
                out.write(c);
        }
        out.close();
    }


!SLIDE bullets
#Interacción mediante la línea de comandos

* Cuando ejecutamos un programa, con la forma `java ClaseConMain`, lo que viene después
  son los "parámetros" del programa.
* Un programa no es más que una invocación a un `main`: un punto de entrada.
* `args` trae todos los "parámetros" de la invocación del programa


!SLIDE code smaller
    
    @@@java 
    public static void main (String [] args) throws Exception
    {
        switch(args.length){
            case 1:
                System.out.printf("El contenido es: %s \n"
                                  , read(args[0]));
                break;
            case 2:
                write(args[0], args[1]);
                System.out.printf("Escribiendo %s en %s \n"
                                   , args[0], args[1]);
                break;
            default:
                System.out.println(
                    "Uso: java IOExample [contenido] archivo");
                break;
        }
    }

