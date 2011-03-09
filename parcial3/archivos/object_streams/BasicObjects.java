import java.io.*;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class BasicObjects{
    private static ArrayList<Libro> libros;

    static class Libro implements Serializable{
        public String nombre;
        public GregorianCalendar agregado;
        public Libro(String n){
            nombre = n;
            agregado = new GregorianCalendar();
        }
        public String toString(){
            return String.format("%s | %s\n", nombre, agregado);
        }
    }
    
    public static ArrayList<Libro> leer(){
        ObjectInputStream in = null;
        ArrayList retLibros = new ArrayList<Libro>();
        try{
            in = new ObjectInputStream(new FileInputStream("libros.bk"));
            while(true){
                retLibros.add((Libro)in.readObject());
            }
        }
        catch(ClassNotFoundException cnfex){
            System.err.println("Oops, usamos la clase incorrecta");
        }
        catch(EOFException eof){}
        catch(FileNotFoundException fnfex){}
        catch(Exception ex){
            System.err.println("Excepción inesperada"+ ex.getMessage());
        }
        finally{
            try{
            if(in != null) in.close();
            }catch(Exception ex){throw new RuntimeException();}
            return retLibros;
        }
    }

    public static void guardar() throws Exception{
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream("libros.bk"));
            for(Libro l: libros)
                out.writeObject(l);
        }finally{
            out.close();
        }
    }

    public static void main (String [] args) throws Exception
    {   
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\\n");

        libros = leer();

        String opt = "";
        while(true){
           System.out.println("Libros hasta ahora\n----------------------");
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
} 
