import java.io.*;

public class Kat{
    public static void search(String forString, String inFile){
        BufferedReader input  = null;
        try{
            int lines = 0;
            String line = "";
            input = new BufferedReader(new FileReader(inFile));

            while( (line = input.readLine()) != null ){
                if(line.contains(forString))
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

    public static void main (String [] args)
    {
       String toSearch = args[0];
       String file     = args[1];
       search(toSearch, file);
    }
}
