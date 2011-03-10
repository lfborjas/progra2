!SLIDE
#Object Streams

!SLIDE bullets incremental
##¿De qué estás hablando, Willis?

* A veces tenés objetos complejos
* Si tuvieras varias instancias relacionadas, ¿cómo le harías en texto?
* Manejar objetos que se refieren a otros se vuelve complicado
* La solución: *archivos binarios*

!SLIDE

#The diagram

!SLIDE smbullets
##En java

* Java provee las clases `ObjectInputStream` y `ObjectOutputStream`
* usamos los métodos `readObject` y `writeObject`, que guardan las *referencias*
* al leer, hay que tener cuidado de *hacer el casting correcto* y estar chivas con la *`EOFException`*
* al escribir, hay que tener cuidado de escribir instancias *serializables*
* (las clases que escribamos tienen que implementar la interfaz `Serializable`)

!SLIDE 

#Un ejemplo

!SLIDE code small

    @@@java
    static class Libro implements Serializable{
        public String nombre;
        public GregorianCalendar agregado;
        public Libro(String n){
            nombre = n;
            agregado = new GregorianCalendar();
        }
        public String toString(){
            return String.format("%s | %s\n"
                    , nombre, agregado);
        }
    }

!SLIDE code smaller

    @@@java 
    public static ArrayList<Libro> leer(){
        ObjectInputStream in = null;
        ArrayList retLibros = new ArrayList<Libro>();
        try{
            in = new ObjectInputStream(
                    new FileInputStream("libros.bk"));
            while(true){
                retLibros.add(
                    (Libro)in.readObject());
            }
        }
        catch(ClassNotFoundException cnfex){
            System.err.println(
                "Oops, usamos la clase incorrecta");
        }
        catch(EOFException eof){}
        catch(FileNotFoundException fnfex){}
        catch(Exception ex){
            System.err.println(
             "Excepción inesperada"+ ex.getMessage());
        }
        finally{
            try{
            if(in != null) in.close();
            }catch(Exception ex){
                throw new RuntimeException();}
            return retLibros;
        }
    }

!SLIDE code  

    @@@java 
    public static void guardar() throws Exception{
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(
             new FileOutputStream("libros.bk"));
            for(Libro l: libros)
                out.writeObject(l);
        }finally{
            out.close();
        }
    }

!SLIDE code smaller

    @@@java 
    public static void main (String [] args) throws Exception
    {   
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\\n");

        libros = leer();

        String opt = "";
        while(true){
           System.out.println("Libros hasta ahora");
           System.out.println(libros);
           System.out.print("> ");
           opt = in.next();
           if(opt.matches("\\s*done\\s*")){
            guardar();
            break;
           }
           libros.add(new Libro(opt));
        }
    }
