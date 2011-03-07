import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Tarea implements Serializable{
    String contenido;
    boolean terminada;
    public Tarea(String c){
        contenido = c;
        terminada = false;
    }
    public void terminar(){this.terminada=true;}
    public String toString(){return this.contenido;}
}

public class Serializador{
    static ArrayList<Tarea> tareas;
    static String usuarioActual;
    private final static String arch = "tareas.todo";
    public static boolean leerTareas(){
        ObjectInputStream origen = null;
        try{
            origen = new ObjectInputStream(new FileInputStream(arch));
            usuarioActual = (String)origen.readObject();
            tareas        = (ArrayList<Tarea>)origen.readObject();
            return true;
        }catch(Exception ex){
            return false;
        }finally{
            try{
                if(origen != null) origen.close();
            }catch(Exception ex){throw new RuntimeException();}
        }
        
    }

    public static void guardarEstado(){
        ObjectOutputStream destino = null; 
        try{
            destino = new ObjectOutputStream(new FileOutputStream(arch));
            destino.writeObject(usuarioActual);
            destino.writeObject(tareas);
        }catch(Exception ex){
            System.out.println("meh");
        }finally{
            try{
                destino.close();
            }catch(Exception ex){ throw new RuntimeException();}
        }

    }

    public static int menu(Scanner scan){
        System.out.println("1. Ingresar tarea");
        System.out.println("9. Salir");
        System.out.print(">");
        return scan.nextInt();
    }

    public static void main (String [] args)
    {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");
        if(!leerTareas()){
            System.out.print("¿Cómo te llamás? > ");
            usuarioActual = s.next(); 
            tareas = new ArrayList<Tarea>();
        }
        
        while(true){
            System.out.printf("Hola %s, Tus tareas son: %s\n", usuarioActual, tareas);
            int op = menu(s);
            switch(op){
                case 1: 
                    System.out.print("Nueva tarea> ");
                    tareas.add(new Tarea(s.next()));
                    break;
                case 9:
                    guardarEstado();
                    System.exit(0);
            }
        }
    }


} 
