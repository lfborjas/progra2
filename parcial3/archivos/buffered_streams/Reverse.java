import java.io.*;
public class Reverse{
    public static StringBuilder read(String file) throws IOException{
       BufferedReader in = null;
       PrintWriter out = null;
       StringBuilder contents = new StringBuilder();
        try {
            in = 
                new BufferedReader(new FileReader(file));

            String l;
            while ((l = in.readLine()) != null) {
                    contents.append(l);
            }
        }catch(FileNotFoundException fex){
            System.out.println("Archivo no encontrado");
        }catch(IOException ioex){
            System.out.println("Error leyendo en archivo");
        }finally {
            if (in != null) {
                in.close();
            }
            return contents;
        }
    }

    public static void writeReversed(StringBuilder contents) throws IOException{
        PrintWriter out = null;
        try{
            out = new PrintWriter(new FileWriter("reversed.txt"));
            out.println("¡Revertido!");
            out.println(contents.reverse());
        }
        catch(FileNotFoundException fnfex){System.err.println(contents+ " no existe");}
        catch(IOException ioex){System.err.println("Error escribiendo");}
        finally{
            if(out != null) out.close();
        }
    }

    public static void main (String [] args) throws IOException
    {
        System.out.printf("Revirtiendo el archivo %s\n", args[0]);
        writeReversed(read(args[0]));
    }
}
