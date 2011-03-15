import java.io.*;

public class Examen{
    public static void search(String forString, String inFile){
        BufferedReader input  = null;
        try{
            int lines = 0;
            String line = "";
            input = new BufferedReader(new FileReader(inFile));

            while( (line = input.readLine()) != null ){
                if(line.toLowerCase().contains(forString.toLowerCase()))
                    System.out.printf("%d: %s\n", ++lines, line);
            }

        }catch(FileNotFoundException fnfex){
            System.out.println("Archivo no encontrado");
        }catch(IOException ioex){
            System.out.println("Error leyendo del archivo");
        }finally{
            try{
            if(input != null)
                input.close();
            }catch(Exception ex){throw new RuntimeException("who cares?");}
        }
    }

    public static void replace(String original, String replacement, String inFile){
        BufferedReader input  = null;
        PrintWriter out = null;
        try{
            String line = "";
            input = new BufferedReader(new FileReader(inFile));
            out = new PrintWriter(new FileWriter("replaced_"+inFile));
            while( (line = input.readLine()) != null ){
                if(line.toLowerCase().contains(original.toLowerCase()))
                    out.println(line.toLowerCase().replaceAll(original, replacement));
                else
                    out.println(line);
            }

        }catch(FileNotFoundException fnfex){
            System.out.println("Archivo no encontrado");
        }catch(IOException ioex){
            System.out.println("Error leyendo del archivo");
        }finally{
            try{
            if(input != null)
                input.close();
            if(out != null)
                out.close();
            }catch(Exception ex){throw new RuntimeException("who cares?");}
        }
    }
    public static void main (String [] args)
    {
       switch(args.length){
        case 2:
            search(args[0], args[1]);
            break;
        case 3:
            replace(args[0], args[1], args[2]);
            break;
        default:
            System.out.println("uso: java Examen palabra [reemplazo] archivo");
       }
    }
}
