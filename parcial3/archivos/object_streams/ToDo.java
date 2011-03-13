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
    public boolean isTerminada(){return terminada;}
    public String toString(){
        return this.contenido+ (terminada? " [X]" : " []");
    }
}

public class ToDo{
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

            ArrayList<Tarea> noTerminadas = new ArrayList<Tarea>();
            for(Tarea t: tareas){
                if(!t.isTerminada()) noTerminadas.add(t);
            }

            destino.writeObject(noTerminadas);

        }catch(Exception ex){
            System.err.println("No se pudieron guardar tus tareas");
        }finally{
            try{
                destino.close();
            }catch(Exception ex){ throw new RuntimeException();}
        }

    }

    public static int menu(Scanner scan){
        while(true){
            try{
                    System.out.println("1. Ingresar tarea");
                    System.out.println("2. Terminar una tarea");
                    System.out.println("9. Salir");
                    System.out.print(">");
                    return scan.nextInt();
            }catch(Exception ex){System.out.println("Opcion incorrecta");scan.next();}
        }
    }

    public static void main (String [] args)
    {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n|\n\r|\r");
        if(!leerTareas()){
            System.out.print("¿Cómo te llamás? > ");
            usuarioActual = s.next(); 
            tareas = new ArrayList<Tarea>();
        }
        
        while(true){
            System.out.printf("Hola %s, Tus tareas son:\n", usuarioActual);
            char count = 'a';
            for(Tarea t: tareas) {
                System.out.printf("\t%c. %s\n", count++, t);
            }
            int op = menu(s);
            int chore;
            try{
                switch(op){
                    case 1: 
                        System.out.print("Nueva tarea > ");
                        tareas.add(new Tarea(s.next()));
                        break;
                    case 2:
                        System.out.println("Tarea a terminar >");
                        chore = s.next().charAt(0)-97;
                        if(chore >= 0 && chore < tareas.size() && !tareas.get(chore).isTerminada() )
                            tareas.get(chore).terminar();
                        else
                            System.out.println("Esa tarea no existe o ya está terminada");
                        break;
                    case 9:
                        guardarEstado();
                        System.exit(0);
                }
            }catch(Exception ex){continue;}
        }
    }


} 
