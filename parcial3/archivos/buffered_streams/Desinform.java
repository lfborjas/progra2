import java.io.*;
public class Desinform{
    public static void uncomment(String file){
       BufferedReader inputStream = null;
       PrintWriter outputStream = null;

        try {
            inputStream = 
                new BufferedReader(new FileReader(file));
            outputStream = 
                new PrintWriter(new FileWriter("uncommented_"+file));

            String l;
            while ((l = inputStream.readLine()) != null) {
                if(!l.trim().startsWith("//"))
                    outputStream.println(l);
            }
        }catch(FileNotFoundException fex){
            System.out.println("Archivo no encontrado");
        }catch(IOException ioex){
            System.out.println("Error escribiendo en archivo");
        }finally {
            try{
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }catch(Exception ex){
                throw new RuntimeException("too much exceptions!");
            }
        } 
    }

    public static void main (String [] args)
    {
        System.out.printf("Descomentando el archivo %s", args[0]);
        uncomment(args[0]);
    }
}
